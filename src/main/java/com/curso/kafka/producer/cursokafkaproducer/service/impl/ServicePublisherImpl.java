package com.curso.kafka.producer.cursokafkaproducer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.curso.kafka.producer.cursokafkaproducer.service.ServicePublisher;

@Service
public class ServicePublisherImpl implements ServicePublisher {
	static final Logger log = LoggerFactory.getLogger(ServicePublisher.class);

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String msg, String topicName) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);

		future.addCallback(
				new ListenableFutureCallback<SendResult<String, String>>() {
		
					@Override
					public void onSuccess(SendResult<String, String> result) {
						log.info("Send Message: {} ", msg);
		
					}
		
					@Override
					public void onFailure(Throwable ex) {
						log.error("Unable to send message {}", msg);
					}
		});
	}

}
