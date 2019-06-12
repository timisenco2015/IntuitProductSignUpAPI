package com.intuitproductsignupapi.domain;

public class RequestWrapper {
	UserInformation userInformation;
    PaymentInformation paymentInformation;
    
    public RequestWrapper()
    {
    	
    }
    
    public void setUserInformation(UserInformation userDetails)
    {
    	userInformation = userDetails;
    }
    
    public UserInformation getUserInformation()
    {
    	return userInformation;
    }
    
    
    public void setPaymentInformation(PaymentInformation paymentDetails)
    {
    	paymentInformation = paymentDetails;
    }
    
    public PaymentInformation getPaymentInformation()
    {
    	return paymentInformation;
    }

}
