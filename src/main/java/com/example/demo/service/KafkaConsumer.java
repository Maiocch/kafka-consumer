package com.example.demo.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TestDTO;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "my_topic", groupId = "gruppo1", containerFactory = "kafkaListenerContainerFactory")
	public void listen(@Payload List<TestDTO> test,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer>  partitionId,
			@Header(KafkaHeaders.RECEIVED_TIMESTAMP) List<Long> timestamp,
			@Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topic,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)  List<String> key,
			@Header(KafkaHeaders.OFFSET) List<Long> offset
			,
			Acknowledgment ack
			) {
		
		
		int size = test.size();
		for(int i=0; i<size; i++) {
			
			System.out.println("partitionId: "+partitionId.get(i));
			System.out.println("timestamp: "+timestamp.get(i));
			System.out.println("topic: "+topic.get(i));
			System.out.println("key: "+key.get(i));
			System.out.println("offset: "+offset.get(i));
			System.out.println(test.get(i).toString());
			
		}

		
		ack.acknowledge();
		
	}
	
}
