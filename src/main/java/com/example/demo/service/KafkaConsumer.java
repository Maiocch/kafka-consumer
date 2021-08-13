package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "my_topic", groupId = "gruppo1")
	public void listen(@Payload String test,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer  partitionId,
			@Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)  String key,
			@Header(KafkaHeaders.OFFSET) Long offset
			) {
		
		System.out.println("messaggio: "+test);
		System.out.println("partitionId: "+partitionId);
		System.out.println("timestamp: "+timestamp);
		System.out.println("topic: "+topic);
		System.out.println("key: "+key);
		System.out.println("offset: "+offset);
		
		ObjectMapper mapper = new ObjectMapper();
		TestDTO testDTO = new TestDTO();
		
		try {
			testDTO = mapper.readValue(test, TestDTO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(testDTO.toString());
		
	}
	
}
