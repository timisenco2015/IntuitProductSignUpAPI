package com.intuitproductsignupapi.service;




import org.springframework.validation.BindingResult;
import com.intuitproductsignupapi.domain.RequestWrapper;


public interface OrchestrationService {
	public String addNewUserRegistration(RequestWrapper requestWrapper,BindingResult result);
}
