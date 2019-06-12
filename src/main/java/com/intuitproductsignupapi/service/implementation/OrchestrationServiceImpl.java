package com.intuitproductsignupapi.service.implementation;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import com.intuitproductsignupapi.domain.RequestWrapper;

import com.intuitproductsignupapi.service.OrchestrationService;

@Service("OrchestrationService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class OrchestrationServiceImpl implements OrchestrationService {
	
	@Autowired
	UserInformationServiceImpl userInformationServiceImpl;
	
	@Autowired
	PaymentInformationServiceImpl paymentInformationServiceImpl;
	
	@Override
	public String addNewUserRegistration(RequestWrapper requestWrapper,BindingResult result)
	{
		JSONObject errorResultObject = new JSONObject();
		String errorResult = userInformationServiceImpl.addUser(requestWrapper.getUserInformation(), result);
		
		JSONObject messageObjectTest  = new JSONObject(errorResult);
		
		if(messageObjectTest.get("errorStatus").toString().equalsIgnoreCase("Success"))
		{
			errorResultObject.put("userStatus", errorResult);
			errorResult = paymentInformationServiceImpl.addUserPayment(requestWrapper.getPaymentInformation(), result);
			errorResultObject.put("paymentStatus", errorResult);
			errorResultObject.put("errorStatus", "Success");
		}
		else
		{
			errorResultObject.put("errorStatus", "Failed");
		}
		
		return errorResultObject.toString() ;
				
	}
	
}
