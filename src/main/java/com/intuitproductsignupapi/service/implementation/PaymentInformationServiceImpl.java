package com.intuitproductsignupapi.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.intuitproductsignupapi.IntuitProductSignUpApiApplication;
import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.dto.Payment;
import com.intuitproductsignupapi.repository.PaymentRepository;
import com.intuitproductsignupapi.service.PaymentInformationService;
import com.intuitproductsignupapi.service.Validation.ValidatePaymentInformation;

@Service("PaymentInformationService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)

public class PaymentInformationServiceImpl implements PaymentInformationService {

	private static final Logger logger = LoggerFactory.getLogger(IntuitProductSignUpApiApplication.class);
	
	 
	@Autowired
	PaymentRepository  paymentRepository;
	
	@Override
	public String addUserPayment(PaymentInformation paymentInformation,BindingResult result)
		{
		
		logger.info("Payment information service launched");
		  
		
		new ValidatePaymentInformation().validate(paymentInformation, result);
		ErrorHandler  errorHandler = new ErrorHandler()	;
			
			if (result.hasErrors())
			{
			
				errorHandler.setErrorStatus("Failed");
				errorHandler.setMessage("Failed validation test for all or most of the fields");
				errorHandler.setAllErrorObject(result.getAllErrors());
				logger.info("Payment information validation error. Error info: "+errorHandler.getMessageObject());
			}
			else
			{
				Payment payment = new Payment();
				payment.setCardNumber(paymentInformation.getCardNumber());
				payment.setPaymentAddress(paymentInformation.getPaymentAddress());
				payment.setExpiryDate(paymentInformation.getExpiryDate());
				payment.setCvv(paymentInformation.getCvv());
				Payment savedPayment = paymentRepository.save(payment);
				
				if(savedPayment instanceof Payment)
				{
					errorHandler.setErrorStatus("Success");
					errorHandler.setMessage("saved into our record");
					errorHandler.setReturnEntityObject(savedPayment);
					logger.info("Payment information saved: user information: "+errorHandler.getMessageObject());
					
				}
				else
				{
					errorHandler.setErrorStatus("Success");
					errorHandler.setMessage("saved into our record");
					logger.info("Unable to save payment information to the database: "+errorHandler.getMessageObject());
					
				}
			}
				
			return errorHandler.getMessageObject();
		}
		
		
}
