package com.example.producer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.utility.FileNamesReader;
import com.example.utility.FileReader;

@Service
public class KafkaProducerApi {

	@Autowired
	FileReader fileReader;
	
	@Autowired
	private FileNamesReader fileNames;
	
    private RestTemplate restTemplate = new RestTemplate();
	
	
	public void sendMessageApi() throws Exception {
		
		List<String> files = new ArrayList<>();
		 
		files = fileNames.readAllFiles("C:\\Users\\apasuladhi\\Documents\\workspace-sts\\Kafka-Microservices-Application\\src\\main\\resources\\inputFiles");

		 for(String file : files) {
		 String data = fileReader.readFileAsString("C:\\Users\\apasuladhi\\Documents\\workspace-sts\\Kafka-Microservices-Application\\src\\main\\resources\\inputFiles\\"
				 + file);
		String url = "http://localhost:8083/producer/"+data;
		 
		String response = restTemplate.getForObject(url, String.class);
		System.out.println("==================================================");

		System.out.println(response);
		/*ResponseEntity<String> response
		  = restTemplate.getForEntity(url, String.class);
		System.out.println("==================================================");
		System.out.println(response.getStatusCode());*/
		 }
		
	}
	
}
