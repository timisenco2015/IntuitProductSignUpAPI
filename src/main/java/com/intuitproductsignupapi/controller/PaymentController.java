package com.intuitproductsignupapi.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.intuitproductsignupapi.IntuitProductSignUpApiApplication;
import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.service.PaymentInformationService;



@RestController
@RequestMapping("/productsignupapi")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(IntuitProductSignUpApiApplication.class);
	
	
	@Autowired
	PaymentInformationService paymentInformationService;
	
	@PostMapping("/addPaymentDetails")
	@ResponseBody
	public String addNewPaymentInfo(@Valid @RequestBody PaymentInformation paymentInformation,BindingResult result) {
		logger.info("User called payment api. parameters passed is: "+paymentInformation);
		return paymentInformationService.addUserPayment(paymentInformation,result);
				
	}
    
	
	
	

}
