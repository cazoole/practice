package com.example.demo;

import com.example.demo.hessian.HelloHessian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,
        CassandraAutoConfiguration.class,CassandraDataAutoConfiguration.class,
        DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
@EnableSwagger2
@EnableCaching
@EnableRetry
@EnableScheduling
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Autowired
	private HelloHessian helloHessian;

	@Bean(name = "/helloHessian")
	public HessianServiceExporter helloService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(helloHessian);
		exporter.setServiceInterface(HelloHessian.class);
		return exporter;
	}

}
