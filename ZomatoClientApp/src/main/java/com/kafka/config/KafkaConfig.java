package com.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.dto.Employee;

@Configuration
public class KafkaConfig {
	
	Logger logger=LoggerFactory.getLogger(KafkaConfig.class);

	@KafkaListener(topics = AppConstants.TOPIC_NAME,groupId = AppConstants.GROUP_ID)
	public void fetchUpdatedLocation(String location) {
		System.out.println(location);
	}
	
	@KafkaListener(topics = AppConstants.TEST_TOPIC,groupId = AppConstants.GROUP2_ID)
	public void testConsumer1(String message) {
		logger.info("Consumer 1 = {}",message);
	}
	@KafkaListener(topics = AppConstants.TEST_TOPIC,groupId = AppConstants.GROUP2_ID)
	public void testConsumer2(String message) {
		logger.info("Consumer 2 = {}",message);
	}
	@KafkaListener(topics = AppConstants.TEST_TOPIC,groupId = AppConstants.GROUP2_ID)
	public void testConsumer3(String message) {
		logger.info("Consumer 3 = {}",message);
	}
	@KafkaListener(topics = AppConstants.EMP_TOPIC,groupId = AppConstants.EMP_GROUP_ID)
	public void empConsumer(Employee employee) {
		logger.info("empConsumer = {}",employee);
	}
}
