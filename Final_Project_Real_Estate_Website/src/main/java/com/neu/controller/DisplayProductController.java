package com.neu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.pojo.Person;

@Controller
@RequestMapping("/display.htm")
public class DisplayProductController {

		
	
		
	
	 @RequestMapping(method = RequestMethod.GET) 
	    public String initializeForm() { 
	   
	        return "Register"; 
	    } 
}
