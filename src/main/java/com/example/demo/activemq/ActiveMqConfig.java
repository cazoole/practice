package com.example.demo.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
@Slf4j
public class ActiveMqConfig {


    @Value("${spring.activemq.maximumRedelivery:4}")
    private int maximumRedlivery;

    @Value("${spring.activemq.initialRedeliveryDelay:1000}")
    private int initialRedeliveryDelay;
    public ConnectionFactory connectionFactory() {
        PooledConnectionFactory factory = new PooledConnectionFactory();

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("");
        RedeliveryPolicy policy = new RedeliveryPolicy();
        policy.setInitialRedeliveryDelay(initialRedeliveryDelay);
        policy.setRedeliveryDelay(1);
        policy.setMaximumRedeliveries(maximumRedlivery);
        policy.setMaximumRedeliveryDelay(1);

        return factory;
    }
}
