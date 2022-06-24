package com.cj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cj.service.KafkaSender;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {
	// small comment added
/*
	@Autowired
	KafkaSender kafkaSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		
		System.out.println("producer Sending========>>"+message);
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
*/
}
