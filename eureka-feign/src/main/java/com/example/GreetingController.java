package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {

	@Autowired
	private GreetingClient greetingClient;
	
	@RequestMapping("/get-greeting")
	public String getGreeting(){
		return greetingClient.getGreeting();
	}

	
	@RequestMapping("/model/UserModel")
	public String getUserModel() throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
		UserModel userModel=new UserModel();
		return mapper.writeValueAsString(userModel);
		
	}
}

