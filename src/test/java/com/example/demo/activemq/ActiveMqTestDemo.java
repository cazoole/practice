package com.example.demo.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTestDemo {

    @Autowired
    private Producer producer;

    @Autowired
    private Comsumer comsumer;

    @Test
    public void testSend() throws InterruptedException {
        Destination destination = new ActiveMQQueue(MqDestinationName.TP_Q_USS_LOCAL_TEST);

        for (int i = 0 ; i < 10 ; i++) {
            producer.sendMessage(destination, "Hello, this is my test MQ!");
        }
    }

}
