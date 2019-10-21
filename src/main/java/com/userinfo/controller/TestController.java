package com.userinfo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {
	
	
	@GetMapping("/test")
	public ResponseEntity<List<PersonalInfo> >responseValue(@RequestParam String name)
	{
		System.out.println("Inside responseVlue");
		List<PersonalInfo> infoList=new ArrayList<PersonalInfo>();
		
		PersonalInfo info= new PersonalInfo();
		info.setLastName(name);
		info.setName("First Service Name");
		
		infoList.add(info);
		/*RestTemplate restTemplate = new RestTemplate();
		EncryptResponse res = restTemplate.getForObject("http://127.0.0.1:8200/v1/transit/encrypt/Vincent", EncryptResponse.class);

		System.out.println(res.getRequestId());
		PersonalInfo info1= new PersonalInfo();
		info1.setLastName(res.getRequestId());
		info1.setName("starting");
		
		infoList.add(info1);*/
		
		return new ResponseEntity<List<PersonalInfo> > (infoList, HttpStatus.OK);
	}
	@GetMapping("/test1")
	public ResponseEntity<List<PersonalInfo> >responseValue1(@RequestParam String name)
	{
		System.out.println("Inside responseVlue");
		List<PersonalInfo> infoList=new ArrayList<PersonalInfo>();
		
		PersonalInfo info= new PersonalInfo();
		info.setLastName(name+"--Own");
		info.setName("starting");
		
		infoList.add(info);
		RestTemplate restTemplate = new RestTemplate();
		try{
			
				
			TestDataDAO[] res = restTemplate.getForObject("http://localhost:3004/test?name={name}", TestDataDAO[].class,name);
				
				System.out.println(res[0].getLastName());
				PersonalInfo info1= new PersonalInfo();
				info1.setLastName(res[0].getLastName());
				info1.setName(res[0].getName());
				
				infoList.add(info1);
		 }
		catch(Exception ex)
		{
				ex.printStackTrace();
		}
		
		return new ResponseEntity<List<PersonalInfo> > (infoList, HttpStatus.OK);
	}
	
	
	@GetMapping("/test2")
	public ResponseEntity<List<PersonalInfo> >responseValue2(@RequestParam String name)
	{
		System.out.println("Inside responseVlue");
		List<PersonalInfo> infoList=new ArrayList<PersonalInfo>();
		
		PersonalInfo info= new PersonalInfo();
		info.setLastName(name+"--Own");
		info.setName("starting");
		
		infoList.add(info);
		RestTemplate restTemplate = new RestTemplate();
		try{
			
				HttpHeaders header= new HttpHeaders();
				header.add("X-Vault-Token", "s.V9KpctBKGSQr9qlPFh6cxWZv");
				Map param= new HashMap<String, String>();
				param.put("plaintext", "VmluY2VudA==");
				param.put("request_id", name);
				
				HttpEntity entity =  new HttpEntity<>(param , header);
				EncryptResponse res = restTemplate.postForObject("http://127.0.0.1:8200/v1/transit/encrypt/Vincent",entity, EncryptResponse.class);
				
				System.out.println(res.getRequestId());
				PersonalInfo info1= new PersonalInfo();
				info1.setLastName(res.getRequestId());
				info1.setName(res.getData().getCiphertext());
				
				infoList.add(info1);
		 }
		catch(Exception ex)
		{
				ex.printStackTrace();
		}
		
		return new ResponseEntity<List<PersonalInfo> > (infoList, HttpStatus.OK);
	}
}
