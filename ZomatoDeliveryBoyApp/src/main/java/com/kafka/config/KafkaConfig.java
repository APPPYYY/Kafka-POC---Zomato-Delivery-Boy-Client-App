package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic zomatoLocationTopic() {
		return TopicBuilder.name(AppConstants.LIVE_LOCATION_TOPIC)
//				.partitions()
//				.replicas()
				.build();
	}
	
	@Bean
	public NewTopic chatMessageTopic() {
		return TopicBuilder.name(AppConstants.CHAT_TOPIC2)
				.partitions(3)
				.replicas(1)
				.build();
	}
	
	@Bean
	public NewTopic testTopic() {
		return TopicBuilder.name(AppConstants.TEST_TOPIC)
				.partitions(3)
				.replicas(1)
				.build();
	}
	
	@Bean
	public NewTopic employeeTopic() {
		return TopicBuilder.name(AppConstants.EMP_TOPIC)
				.partitions(3)
				.replicas(1)
				.build();
	}
}
