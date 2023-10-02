package com.deliveryBoy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaService {
    
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	 private KafkaTemplate<String, String> kafkaTemplate;
	
	 public boolean updateLocation(String location){
		 
		 kafkaTemplate.send("loc-topic",location);
		 logger.info("message produced");
		 return true;
	 }
}
