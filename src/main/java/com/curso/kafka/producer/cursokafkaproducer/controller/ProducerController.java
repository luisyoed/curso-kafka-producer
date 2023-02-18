package com.curso.kafka.producer.cursokafkaproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.curso.kafka.producer.cursokafkaproducer.dto.MessageDto;
import com.curso.kafka.producer.cursokafkaproducer.service.ServicePublisher;

@RestController
@RequestMapping("/")
public class ProducerController {

	static final Logger log = LoggerFactory.getLogger(ProducerController.class);
	
	@Autowired
	ServicePublisher servicePublisher;
	
	@PostMapping(value = "/publishMessage", consumes = MediaType.APPLICATION_JSON_VALUE,  produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> seandMessage(@RequestBody MessageDto request){
		
		servicePublisher.sendMessage(request.getMessage(),	request.getTopic());
		log.info("Fin de servicio");
		
		return new ResponseEntity<>(request.getMessage() + " publicado", HttpStatus.OK);
		
	}

}
