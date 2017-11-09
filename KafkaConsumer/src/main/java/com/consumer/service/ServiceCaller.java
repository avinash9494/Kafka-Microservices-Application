package com.consumer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class ServiceCaller {

	@Autowired
    private EurekaClient eurekaClient;
	
/*	@Autowired
	private ServiceMethodsUrl serviceUrl;*/
	
   // @Autowired
    private RestTemplate restTemplate = new RestTemplate();
	
	public void serviceMethodCaller(String data) {
		
		Map<String,String> methodMap = 
				new HashMap<>();
		methodMap.put("employees","EmployeeService");
		methodMap.put("books","BookService");
		methodMap.put("addresses","AddressService");
		
		Map<String,String> serviceId = 
				new HashMap<>();
		serviceId.put("EmployeeService", "employee-service");
		serviceId.put("BookService", "book-service");
		serviceId.put("AddressService", "address-service");
		
		 
		System.out.println(data.toLowerCase());
		
		if(data.toLowerCase().contains("employee")) {

			
			Application application = eurekaClient.getApplication("employee-service");
			
			System.out.println("====================================================");

			InstanceInfo instanceInfo = application.getInstances().get(0);
			//
			String url = "http://"+
			instanceInfo.getIPAddr()+
			":"+instanceInfo.getPort()+
			"/"+"employeeData"; 
			
			String response = restTemplate.getForObject(url, String.class);	    
		    
			System.out.println("======================================================");
			System.out.println("making call to employee service");
			System.out.println("Response from employee service is: " + response);
		}
		
		if(data.toLowerCase().contains("book")) {
			
			Application application = eurekaClient.getApplication("book-service");
			InstanceInfo instanceInfo = application.getInstances().get(0);

			String url = "http://"+
					instanceInfo.getIPAddr()+
					":"+instanceInfo.getPort()+
					"/"+"bookData"; 
					
					String response = restTemplate.getForObject(url, String.class);

			System.out.println("======================================================");
			System.out.println("making call to book service");
			System.out.println("Response from book service is: " + response);
		}
		
		if(data.toLowerCase().contains("address")) {
			
			Application application = eurekaClient.getApplication("address-service");
			InstanceInfo instanceInfo = application.getInstances().get(0);

			String url = "http://"+
					instanceInfo.getIPAddr()+
					":"+instanceInfo.getPort()+
					"/"+"addressData"; 
					
					String response = restTemplate.getForObject(url, String.class);

			System.out.println("======================================================");
			System.out.println("making call to address service");
			System.out.println("Response from address service is: " + response);
		}
		
		
		
		
	}
	
}
