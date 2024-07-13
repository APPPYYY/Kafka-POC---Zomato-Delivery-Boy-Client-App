package com.kafka.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.Employee;
import com.kafka.service.KafkaService;

@RestController
@RequestMapping("/kafka/update")
public class KafkaController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/location")
	public ResponseEntity<?> updateOrderLocation(){
		boolean isLocationUpdated = kafkaService.updateOrderLocation(UUID.randomUUID().toString()+" - "+UUID.randomUUID().toString());
		if (isLocationUpdated) {
			return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Location updated successfully !!!"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid input !!!"));
	}

	@PostMapping("/chat")
	public ResponseEntity<?> updateChatsMessage(@RequestBody String message){
		boolean isChatSent = kafkaService.sendMessageToTopic(message);
		if (isChatSent) {
			return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Chat send successfully !!!"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid input !!!"));
	}
	
	@PostMapping("/test")
	public ResponseEntity<String> sendTestMessage(){
		boolean testProducer=false;
		for(int i=0;i<=100000;i++) {
			 testProducer = kafkaService.testProducer("test");
		}
		
		if (testProducer) {
			return ResponseEntity.status(HttpStatus.OK).body("Message sent successfully !!!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected exception occured !!!");
	}
	
	@PostMapping("/emp")
	public ResponseEntity<String> sendEmpDetails(@RequestBody Employee employee){
		
			boolean sendEmpDetails = kafkaService.sendEmpDetails(employee);
		
		if (sendEmpDetails) {
			return ResponseEntity.status(HttpStatus.OK).body("Employee created successfully !!!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected exception occured !!!");
	}
	
	
}
