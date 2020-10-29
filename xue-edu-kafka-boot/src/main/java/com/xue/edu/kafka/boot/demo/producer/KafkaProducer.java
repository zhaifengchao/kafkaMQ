package com.xue.edu.kafka.boot.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class KafkaProducer {

	@Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

	public String send(@RequestParam  String message) {
		kafkaTemplate.send("gptest", message);
        return "ok";
	}

}
