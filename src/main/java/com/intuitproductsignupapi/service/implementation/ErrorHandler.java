package com.intuitproductsignupapi.service.implementation;

import java.util.List;

import org.json.JSONObject;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.intuitproductsignupapi.dto.Payment;
import com.intuitproductsignupapi.dto.User;

public class ErrorHandler {
	

	private JSONObject messageOBject=null;

	
	public ErrorHandler()
	{
		messageOBject = new JSONObject();
	}
	
	public void setErrorStatus(String status)
	{
		messageOBject.put("errorStatus", status);
	}
	
	public void setMessage(String message)
	{
		messageOBject.put("message", message);
		
	}
	
	public void setAllErrorObject(List<ObjectError> ObjectErrorList)
	{
		
		for(ObjectError obj:ObjectErrorList)
		{
			FieldError fieldErrorObject = (FieldError)obj;
			messageOBject.put(fieldErrorObject.getField(), fieldErrorObject.getCode());	
		}
		
	}
	
	
	public void setReturnEntityObject(Object object)
	{
		User userInstance = null;
		Payment  paymentInstance = null;
		
		if(object instanceof User)
		{
			userInstance = (User)object;
			messageOBject.put("getObject", userInstance);
		}
		else if (object instanceof Payment)
		{
			paymentInstance = (Payment)object;
			messageOBject.put("getObject", paymentInstance);
		}
		
		
	}
	
	
	public String getMessageObject()
	{
		return messageOBject.toString();
	}
	
}
