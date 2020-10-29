package com.xue.edu.kafka.demo.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleConsumer {

	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("bootstrap.servers","192.168.159.232:9092");
		p.put("group.id", "gp-test-group");
		p.put("enable.auto.commit", "true");
		p.put("auto.commit.interval.ms","1000");
		p.put("auto.offset.reset","earliest");
        p.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        p.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(p);
        // 订阅topic
        consumer.subscribe(Arrays.asList("gptest"));
        try {
        	while(true) {
        		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        		for(ConsumerRecord<String, String> record:records) {
        			System.out.printf("offset = %d ,key =%s, value= %s, partition= %s%n" ,record.offset(),record.key(),record.value(),record.partition());
        		}
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        	consumer.close();
        }
	}

}
