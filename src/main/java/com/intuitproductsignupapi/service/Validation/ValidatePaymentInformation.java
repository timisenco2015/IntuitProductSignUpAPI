package com.intuitproductsignupapi.service.Validation;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.intuitproductsignupapi.domain.PaymentInformation;

public class ValidatePaymentInformation implements Validator{

    boolean invalid = false;
	public boolean supports(Class<?> clazz) {
        return PaymentInformation.class.equals(clazz);
    }
	
		@Override
		public void validate(Object target, Errors errors) {
			PaymentInformation paymentInformation = (PaymentInformation) target;
			
            // starting from line 24 to line 52 checks for user enters card number and valid card number
            
			boolean invalid = false;
            String cardNumberInString =String.valueOf(paymentInformation.getCardNumber());
            
			if(paymentInformation.getCardNumber()!=0)
            {
            	for(int i=0; i<cardNumberInString.length() && !invalid; i++) 
            	{
            		if (!Character.isDigit(cardNumberInString.charAt(i)))
            		{
            			invalid = true;
            			errors.rejectValue("cardNumber", "card number must be numbers only");
                   
            		}
            	}
            
            	if(!invalid)
            	{
            		
            			if(String.valueOf(paymentInformation.getCardNumber()).length()!=16)
            			{
            				errors.rejectValue("cardNumber", "card number must be 16 numbers");
            			}
		            
            	
            	}
            }
		    else
		     { 
		    	errors.rejectValue("cardNumber", "field required");
		      }
			 
			
           // starting from line 60 to line 89 checks for user enters card cvv and valid card cvv 
            invalid = false;
            String cardCvvInString =String.valueOf(paymentInformation.getCvv());
            if(paymentInformation.getCvv()!=0)
            {
            	for(int i=0; i<cardCvvInString.length() && !invalid; i++) 
                {
            		if (!Character.isDigit(cardCvvInString.charAt(i)))
                	{
            			invalid = true;
                		errors.rejectValue("cvv", "card cvv must be numbers only");
                       
                	}
                }
                
                if(!invalid)
                {
                	if(String.valueOf(paymentInformation.getCvv()).length()!=3)
                	{
                		errors.rejectValue("cvv", "card cvv must be 3 numbers");
                	}
    		            
                }
    		    

            }
            else
		    { 
		    	errors.rejectValue("cvv", "field required");
		    }
            
            
         // starting from line 92 to 108 checks for valid payment address 
            if(paymentInformation.getPaymentAddress()!=null && paymentInformation.getPaymentAddress().length()>0 && !Character.isWhitespace(paymentInformation.getPaymentAddress().charAt(0)))
	        {
	            for(int i=0; i<paymentInformation.getPaymentAddress().length() && !invalid; i++) {

	                if (!Character.isDigit(paymentInformation.getPaymentAddress().charAt(i)) && !Character.isAlphabetic(paymentInformation.getPaymentAddress().charAt(i)) && !Character.isWhitespace(paymentInformation.getPaymentAddress().charAt(i)) && paymentInformation.getPaymentAddress().charAt(i)!='.' && paymentInformation.getPaymentAddress().charAt(i)!=','&& paymentInformation.getPaymentAddress().charAt(i)!='-')
	                {
	                    invalid = true;
	                    errors.rejectValue("paymentAddress", "field contains invalid characters");
	                  
	                }
	                
	               
	            }
	            
	            if(!invalid)
                {
                	if(paymentInformation.getPaymentAddress().length()<10 || paymentInformation.getPaymentAddress().length()>80)
                	{
                		 errors.rejectValue("paymentAddress", "field length must be between 10 and 80");
   	                  
                	}
                }
	        }
	        else
	        { 
	        	errors.rejectValue("paymentAddress", "field required");
	        }
    
         // starting from line 110 to line 131 checks for valid card expiry date 
            if(paymentInformation.getExpiryDate()!=null&& paymentInformation.getExpiryDate().length()>0 && !Character.isWhitespace(paymentInformation.getExpiryDate().charAt(0)))
	        { 
            	try 
        		{
        			SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
        			formatter.setLenient(true);
        			Date utilDate = formatter.parse(paymentInformation.getExpiryDate());
        		} 
        		catch (ParseException e ) 
        		{	
        			
        			errors.rejectValue("expiryDate", "field contains invalid characters");
        		}
        		
	        }
            else
            {
            	errors.rejectValue("expiryDate", "field required");
            }
        	
       
        }
	}
