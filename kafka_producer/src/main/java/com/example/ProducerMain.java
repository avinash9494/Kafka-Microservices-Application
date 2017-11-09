package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.producer.KafkaProducer;
//import com.example.producer.KafkaProducerApi;

@SpringBootApplication
@EnableEurekaClient

public class ProducerMain {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProducerMain.class, args);
		
/*		KafkaProducerApi producer = (KafkaProducerApi) ctx.getBean(KafkaProducerApi.class);
		
		producer.sendMessageApi();		*/
		
		KafkaProducer producer = (KafkaProducer) ctx.getBean(KafkaProducer.class);
		
		producer.sendMessage();		
	}

}
