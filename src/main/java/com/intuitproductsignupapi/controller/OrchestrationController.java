package com.intuitproductsignupapi.controller;



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
import com.intuitproductsignupapi.domain.RequestWrapper;
import com.intuitproductsignupapi.service.implementation.OrchestrationServiceImpl;


@RestController
@RequestMapping("/productsignupapi")
public class OrchestrationController {
	
	@Autowired
	OrchestrationServiceImpl orchestrationServiceImpl;
	private static final Logger logger = LoggerFactory.getLogger(IntuitProductSignUpApiApplication.class);
	
	
	@PostMapping("/addUserRegistration")
	@ResponseBody
	public String addNewUserRegistration(@RequestBody RequestWrapper requestWrapper,BindingResult result)
	{
		logger.info("User called orchestration  api. parameters passed is: "+requestWrapper);
		return orchestrationServiceImpl.addNewUserRegistration(requestWrapper, result);
	}

}
	
	
	
	


