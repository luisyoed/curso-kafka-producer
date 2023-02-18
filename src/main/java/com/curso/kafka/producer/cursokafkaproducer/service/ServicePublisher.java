package com.curso.kafka.producer.cursokafkaproducer.service;

import org.springframework.stereotype.Repository;

@Repository
public interface ServicePublisher {

	void sendMessage(String msg, String topicName);

}
