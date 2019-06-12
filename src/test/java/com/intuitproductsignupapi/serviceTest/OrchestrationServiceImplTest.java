package com.intuitproductsignupapi.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;

import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.domain.RequestWrapper;
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.service.OrchestrationService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OrchestrationServiceImplTest  {

	 @Autowired
	 OrchestrationService orchestrationService;
	
	 
	 @Test
	public void orchestrationTest() 
	 {
		//test for when request was successfull
		 DataBinder binder = null;
		RequestWrapper requestWrapper = new RequestWrapper();
		PaymentInformation paymentInformation = new PaymentInformation();
		 long cardNumber = 8989567889072345l;
		 int cardCvv = 999;
		 paymentInformation.setCardNumber(cardNumber);
		 paymentInformation.setCvv(cardCvv);
		 paymentInformation.setExpiryDate("04/09/19");
		 paymentInformation.setPaymentAddress("616 Armitage Crescent");
		
		 UserInformation userInformation = new  UserInformation();
		 userInformation.setUserAddress("616 Armitage Crescent");
		 userInformation.setUserEmail("idowutimi@gmail.com");
		 userInformation.setUserFullName("Ayobami O Idowu");
		 
		 requestWrapper.setPaymentInformation(paymentInformation);
		 requestWrapper.setUserInformation(userInformation);
		 
		 binder = new DataBinder(requestWrapper);
		
		 String message = orchestrationService.addNewUserRegistration(requestWrapper, binder.getBindingResult());
		 try {
			 JSONObject messageObjectTest  = new JSONObject(message);
			 
				assertEquals("Success",  messageObjectTest.get("errorStatus").toString());
				} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	 }
	 
	 
	
}

