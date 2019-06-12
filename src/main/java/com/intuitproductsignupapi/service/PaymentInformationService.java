package com.intuitproductsignupapi.service;


import org.springframework.validation.BindingResult;


import com.intuitproductsignupapi.domain.PaymentInformation;



public interface PaymentInformationService {
	public String addUserPayment(PaymentInformation paymentInformation,BindingResult result);
	
}
