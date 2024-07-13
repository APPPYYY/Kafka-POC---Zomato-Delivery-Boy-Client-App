package com.kafka.service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafka.config.AppConstants;
import com.kafka.dto.Employee;

@Service
public class KafkaService {
	
	private Logger logger=LoggerFactory.getLogger(KafkaService.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateOrderLocation(String location) {
			kafkaTemplate.send(AppConstants.LIVE_LOCATION_TOPIC, location);
		return true;
	}
	
	public boolean sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstants.CHAT_TOPIC2, message);
		future.whenComplete((result,ex)->{
			if (Objects.isNull(ex)) {
				System.out.println("Sent message =[ "+message+" ] with offset =["+result.getRecordMetadata().offset()+"]");
			}
			else {
				System.out.println("Unable to sent message =[ "+message+" ] due to :"+ex.getMessage());
			}
		});
	return true;
}
	
	public boolean testProducer(String message) {
		kafkaTemplate.send(AppConstants.TEST_TOPIC, message);
		logger.info("{} message sent successfully to the consumer !!!",message);
		return true;
	}
	public boolean sendEmpDetails(Employee employee) {
		kafkaTemplate.send(AppConstants.EMP_TOPIC, 2, null, employee);
		logger.info("{} employee sent successfully to the consumer !!!",employee);
		return true;
	}
}
