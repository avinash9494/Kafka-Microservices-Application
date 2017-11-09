package com.example.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileNamesReader {

	public List<String> readAllFiles(String path) {
		List<String> fileNames = new ArrayList<>();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        fileNames.add(listOfFiles[i].getName());
		      }
		    }
		    return fileNames;
	}
	
}
