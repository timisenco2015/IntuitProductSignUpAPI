package com.intuitproductsignupapi.service;


import org.springframework.validation.BindingResult;


import com.intuitproductsignupapi.domain.UserInformation;



public interface UserInformationService {
	
	

	public String addUser(UserInformation userInformation,BindingResult result);
	
}
