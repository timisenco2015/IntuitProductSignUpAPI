package com.intuitproductsignupapi.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.intuitproductsignupapi.IntuitProductSignUpApiApplication;
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.service.UserInformationService;

@RestController
@RequestMapping("/productsignupapi")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(IntuitProductSignUpApiApplication.class);
	

	@Autowired
	UserInformationService userInformationService;
	
	
	@PostMapping("/UserDetails")
	@ResponseBody
	public String addNewUser(@Valid @RequestBody UserInformation userInformation,BindingResult result) { 
		logger.info("User called add user details api. parameters passed is: "+userInformation);
	    return  userInformationService.addUser(userInformation,result);
	
	}
	
	
	
	

}
