package com.curso.kafka.producer.cursokafkaproducer.dto;

import java.io.Serializable;

public class MessageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3273891889395146173L;

	private String message;
	private String topic;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public MessageDto(String message, String topic) {
		super();
		this.message = message;
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "MessageDto [message=" + message + ", topic=" + topic + "]";
	}

}
