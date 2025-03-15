package com.demo.kafka.controller;

import com.demo.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class RestControllerForKafkaMsg {

    @Autowired
    Producer producer;

    @GetMapping("/produceMsg")
    public ResponseEntity<String> getMessageFromClient(@RequestParam("message") String message){
        producer.sendMsgToTopic(message);

//        for(int i=0;i<1000000000;i++){
//            message="i value:"+i;
//            producer.sendMsgToTopic(message);
//        }
        return ResponseEntity.ok("Thanks");
    }


}
