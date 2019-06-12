package com.intuitproductsignupapi.domain;

import org.apache.commons.lang3.StringUtils;

public class PaymentInformation {


	
	
	private long cardNumber;
	
	
	private String paymentAddress;
	
	
	private String expiryDate;
	
	
	private int cvv;
	

	
	public PaymentInformation()
	{
		
	}
	
	

	
	
	public long getCardNumber()
	{
		return cardNumber;
	}
	
	
	
	public String getPaymentAddress()
	{
		return paymentAddress;
	}


	public String getExpiryDate()
	{
		return expiryDate;
	}
	
	
	
	public int getCvv()
	{
		return cvv;
	}
	
	
	public void setCardNumber(long creditCardNumber)
	{
		cardNumber = creditCardNumber;
	}
	
	

	public void setPaymentAddress(String carPaymentAddress)
	{
		paymentAddress = carPaymentAddress;
	}
	

	public void setExpiryDate(String cardExpiryDate)
	{
		expiryDate = cardExpiryDate;
	}
	public void setCvv(int cardCvv)
	{
		cvv = cardCvv;
	}
	
	@Override
	public String toString() {
		return "PaymentInformation [cardNumber=" + String.valueOf(cardNumber).replaceAll("([\\d]{4})(?!$)", "****-") + ", paymentAddress=" + paymentAddress.replaceAll(paymentAddress.substring(2, paymentAddress.length()/3),StringUtils.repeat('*', paymentAddress.length()/3) ) + ", expiryDate="
				+ expiryDate.replaceAll("[\\d.]", "*") + ", cvv=" + String.valueOf(cvv).replaceAll("\\d{3}", "***")  + "]";
	}
	
}