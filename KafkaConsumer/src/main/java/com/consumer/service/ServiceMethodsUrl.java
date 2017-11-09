package com.consumer.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceMethodsUrl {

	@Autowired
	private Properties properties;
	
	@Autowired
	@Value("C:\\Users\\apasuladhi\\Documents\\Team Projects\\Kafka and microservices\\kafka_consumer-master\\kafka_consumer-master\\KafkaConsumer\\src\\main\\resources\\service-url.properties")
	private FileInputStream fis;
	
	public String urlLoaderForService(String serviceName) {
		String url;
		try {
			properties.load(fis);
		} catch (IOException e) {

		}
		url = properties.getProperty(serviceName+"-service-url.name");
		return url;
				
	}
	
	
	
}
