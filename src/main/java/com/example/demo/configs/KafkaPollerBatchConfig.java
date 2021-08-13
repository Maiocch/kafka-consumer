package com.example.demo.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.SeekToCurrentBatchErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.demo.dto.TestDTO;

//@EnableKafka
//@Configuration
public class KafkaPollerBatchConfig {
	
//	
//	@Bean
//	public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory(){
//		ConcurrentKafkaListenerContainerFactory<String, TestDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		
//		factory.setConsumerFactory(consumerFactory());
//		factory.setBatchListener(true);
//		factory.setBatchErrorHandler(new SeekToCurrentBatchErrorHandler());
//		
//		return factory;
//	}
//	
//	@Bean
//    public DefaultKafkaConsumerFactory<String, TestDTO> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }
//	
//	  @Bean
//	    public Map<String, Object> consumerConfigs() {
//	        Map<String, Object> props = new HashMap<>();
//	        
//	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//	        
//	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
//	        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
//	        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, TestDTO.class.getName());
//	        
//	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//	        
//	        return props;
//	  }
	  
	  
}



