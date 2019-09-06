package com.marcio.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.marcio.entity.Data;
import com.marcio.service.IService;

@Service
public class ServiceImpl implements IService {

	public List<Data> search(String message) {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Data>> typeReference = new TypeReference<List<Data>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
		try {
			List<Data> datas = mapper.readValue(inputStream,typeReference);
			
			if(message != null){
				
			}
			
			return datas;
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
		
		return null;
	}

	public void gravar(Data data) {
		String filePath = TypeReference.class.getResource("data.json").getPath();
		
		List<Data> list = search(null);
		list.add(data);
		
		Gson gson = new GsonBuilder()
				  .setPrettyPrinting()
				  .create();
		
		try {
			gson.toJson(list, new FileWriter(filePath));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
