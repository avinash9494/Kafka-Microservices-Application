package com.example.utility;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileReader {
	 public String readFileAsString(String fileName)throws Exception
	  {
		 String data="";
	    data = new String(Files.readAllBytes(Paths.get(fileName)));
	    return data;
	  }
}
