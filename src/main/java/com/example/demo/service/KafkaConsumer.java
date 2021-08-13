package com.example.demo.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
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
			) {
		
		System.out.println("messaggio: "+test.get(0));
		System.out.println("partitionId: "+partitionId.get(0));
		System.out.println("timestamp: "+timestamp.get(0));
		System.out.println("topic: "+topic.get(0));
		System.out.println("key: "+key.get(0));
		System.out.println("offset: "+offset.get(0));
		
//		ObjectMapper mapper = new ObjectMapper();
//		TestDTO testDTO = new TestDTO();
		
//		try {
//			testDTO = mapper.readValue(test.get(0), TestDTO.class);
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(test.get(0).toString());
		
	}
	
}
