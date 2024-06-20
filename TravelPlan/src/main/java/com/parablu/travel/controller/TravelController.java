package com.parablu.travel.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parablu.travel.service.TravelService;



@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}

	@PostMapping("/place")
	 public String place(@RequestParam String userName, @RequestParam String place) {
		System.out.println("controller is calling ");
		
		System.out.println("This is test controller");
	     System.out.println("User Name: " + userName);
	     System.out.println("Place: " + place);
		travelService.travelPostService(userName, place);
		return   "hai";
	}
	 @GetMapping("/users")
	 public List<Document> usersGet(@RequestParam String userName) {
		 
		  System.out.println("hai this GetMapping");
		  System.out.println("userName: " + userName);
		  travelService.travelGetService(userName);
		  
		  
		return null;
		 
	 }
}
