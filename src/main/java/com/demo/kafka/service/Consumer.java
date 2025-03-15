package com.demo.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {

    @KafkaListener(topics = "shiva_Topic",groupId = "shiva_group")
    public  void listenToTopic(String receivedMessage){
        System.out.println("The message received message: "+receivedMessage);
    }

}
