package com.example.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;*/

import com.example.utility.FileNamesReader;
import com.example.utility.FileReader;

@Service
//@RestController
public class KafkaProducer {

	@Autowired
	FileReader fileReader;
	
	@Autowired
	private FileNamesReader fileNames;
	
/*	@RequestMapping(value="/producer/{data}",method = RequestMethod.GET)
	@ResponseBody
	public String sendMessage(@RequestBody String data) throws Exception{*/
	public String sendMessage() throws Exception{
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);
		 
		List<String> files = new ArrayList<>();
		 
		files = fileNames.readAllFiles("C:\\Users\\apasuladhi\\Documents\\workspace-sts\\Kafka-Microservices-Application\\src\\main\\resources\\inputFiles");

		 for(String file : files) {
		 String data = fileReader.readFileAsString("C:\\Users\\apasuladhi\\Documents\\workspace-sts\\Kafka-Microservices-Application\\src\\main\\resources\\inputFiles\\"
				 + file);
	     
		 producer.send(new ProducerRecord<String, String>("inputData", data));
		 
		 }
		 
	     producer.close();
	     
	     return "Success";
	}
}
