package com.cj.service;

import org.apache.tomcat.jni.User;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class KafKaConsumerService 
{
    //private final Logger logger 
       // = LoggerFactory.getLogger(KafKaConsumerService.class);
 /*    
    @KafkaListener(topics = "${general.topic.name}", 
            groupId = "${general.topic.group.id}")
    public void consume(String message) {
    	System.out.println("KafKaConsumerService==>"+String.format("Message recieved -> %s", message));
        
    }
 
    @KafkaListener(topics = "${user.topic.name}", 
            groupId = "${user.topic.group.id}",
            containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
    	System.out.println("KafKaConsumerService==>"+String.format("User created -> %s", user));
    }*/
}
