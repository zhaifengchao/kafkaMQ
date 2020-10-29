package com.xue.edu.kafka.demo.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("bootstrap.servers","192.168.159.232:9092");
		p.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		p.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		p.put("acks", "1");
		p.put("retries", 3);
		p.put("batch.size", 16384);
		p.put("linger.ms", 5);
		p.put("buffer.memory", 33554432);
		p.put("max.block.ms", 300);
		
		Producer<String, String> producer  = new KafkaProducer<String, String>(p);
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, String>("gptest", Integer.toString(i), Integer.toString(i)));
		}
		producer.close();
	}
}
