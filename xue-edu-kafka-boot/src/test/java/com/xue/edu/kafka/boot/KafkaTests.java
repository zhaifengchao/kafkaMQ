package com.xue.edu.kafka.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xue.edu.kafka.boot.demo.App;
import com.xue.edu.kafka.boot.demo.producer.KafkaProducer;

@SpringBootTest(classes = App.class)
public class KafkaTests {

	 @Autowired
	  KafkaProducer producer;
	@Test
	void testMessage() {
        long time = System.currentTimeMillis();
        System.out.println("----"+time +"，已经发出----");
        producer.send("qingshan penyuyan, " +time);
	}
}
