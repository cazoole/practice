package com.example.demo.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Comsumer {

    @JmsListener(destination = MqDestinationName.TP_Q_USS_LOCAL_TEST)
    public void receiveQueue(String text) {
        System.out.println("Comsumer receive : " + text);
    }

}
