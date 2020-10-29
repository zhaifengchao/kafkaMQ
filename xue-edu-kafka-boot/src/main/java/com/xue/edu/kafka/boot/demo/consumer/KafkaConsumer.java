package com.xue.edu.kafka.boot.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
		@KafkaListener(topics = "gptest",groupId = "springboottopic-group")
	    public void onMessage(String msg){
	        System.out.println("----收到消息："+msg+"----");
	    }
}
