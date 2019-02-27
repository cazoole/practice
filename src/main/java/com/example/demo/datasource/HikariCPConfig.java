package com.example.demo.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.driver.OracleConnection;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.example.demo.entity"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class HikariCPConfig {

    @Value("${hikariCP.driverClass:oracle.jdbc.driver.OracleDriver}")
    private String driverClass;

    @Value("${hikariCP.jdbcUrl:jdbc:oracle:thin:@192.168.4.228:1521:testdb}")
    private String jdbcUrl;

    @Value("${hikariCP.user:uss}")
    private String user;

    @Value("${hikariCP.password:uss}")
    private String password;

    @Value("${hikariCP.minimumIdle:3}")
    private int minimumIdle;

    @Value("${hikariCP.maxPoolSize:10}")
    private int maxPoolSize;

    @Value("${hikariCP.connectionTestQuery:select 1 from dual}")
    private String connectionTestQuery;

    @Value("${hikariCP.validationTimeout:5000}")
    private long validationTimeout;

    @Value("${hikariCP.maxLifetime:600000}")
    private long maxLifetime;

    @Value("${hikariCP.connectionTimeout:300000}")
    private long connectionTimeout;

    @Value("${hikariCP.readOnly:false}")
    private boolean readOnly;

    @Value("${hikariCP.idleTimeout:600000}")
    private long idleTimeout;

    @Value("${oracle.jdbc.connectTimeout:600000}")
    private long oracleJdbcConnectTimeout;

    @Value("${oracle.jdbc.readTimeout:1800000}")
    private long oracleJdbcReadTimeout;


    @Bean("dataSource")
    public DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        if(StringUtils.isNotEmpty(driverClass)) {
            config.setDriverClassName(driverClass);
        }

        // 基本配置
        config.setPoolName("Hikari");
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(user);
        config.setPassword(password);

        // 设置最小空闲连接数
        config.setMinimumIdle(minimumIdle);
        // 一个连接idle状态的最大时长（毫秒），超时则被释放
        config.setIdleTimeout(idleTimeout);
        // 一个连接的生命时长（毫秒），超时而且没被使用则被释放
        config.setMaxLifetime(maxLifetime);

        // 最大连接数，推荐的公式：((core_count * 2) + effective_spindle_count)
        config.setMaximumPoolSize(maxPoolSize);

        // 连接超时时间  等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException
        config.setConnectionTimeout(connectionTimeout);

        // 设置心跳检测语句
        config.setConnectionTestQuery(connectionTestQuery);
        // 心跳检测的时间间隔
        config.setValidationTimeout(validationTimeout);
        // JMX监控
        //config.setRegisterMbeans(true);

        // 设置数据库的配置信息
        config.addDataSourceProperty("", "2048");
        config.addDataSourceProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT, oracleJdbcConnectTimeout);
        config.addDataSourceProperty(OracleConnection.CONNECTION_PROPERTY_THIN_READ_TIMEOUT, oracleJdbcReadTimeout);
        config.addDataSourceProperty("cachePrepStmts", true);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() {
        return null;
    }
}
