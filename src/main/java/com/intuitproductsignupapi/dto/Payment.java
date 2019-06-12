package com.intuitproductsignupapi.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;

import org.springframework.context.annotation.Bean;



@Entity
@Table(name = "paymentinformationstable")
@IdClass(Payment.PaymentId.class)



public class Payment implements Serializable {
	
	
	

	private static final long serialVersionUID = -7321416499047242338L;
	
	

	
	@Id
	@Column(name = "cardnumber",unique = true, nullable = false)
	private long cardNumber;
	
	
	
	
	@Column(name = "paymentaddress",unique = true, nullable = false)
	private String paymentAddress;
	
	
	@Column(name = "expirydate",unique = true, nullable = false)
	private String expiryDate;
	
	
	@Column(name = "cvv",unique = true, nullable = false)
	private int cvv;
	

	
	public Payment()
	{
		
	}
	
	

	
	@Bean
	public long getCardNumber()
	{
		return cardNumber;
	}
	
	
	@Bean
	public String getPaymentAddress()
	{
		return paymentAddress;
	}

	@Bean
	public String getExpiryDate()
	{
		return expiryDate;
	}
	
	
	@Bean
	public int getCvv()
	{
		return cvv;
	}
	
	@Bean
	public void setCardNumber(long creditCardNumber)
	{
		cardNumber = creditCardNumber;
	}
	
	
	@Bean
	public void setPaymentAddress(String carPaymentAddress)
	{
		paymentAddress = carPaymentAddress;
	}
	
	@Bean
	public void setExpiryDate(String cardExpiryDate)
	{
		expiryDate = cardExpiryDate;
	}
	
	@Bean
	public void setCvv(int cardCvv)
	{
		cvv = cardCvv;
	}
	
	@Override
	public String toString() {
		return "PaymentInformation [cardNumber=" + String.valueOf(cardNumber).replaceAll("([\\d]{4})(?!$)", "****-") + ", paymentAddress=" + paymentAddress.replaceAll(paymentAddress.substring(2, paymentAddress.length()/3),StringUtils.repeat('*', paymentAddress.length()/3) ) + ", expiryDate="
				+ expiryDate.replaceAll("[\\d.]", "*") + ", cvv=" + String.valueOf(cvv).replaceAll("\\d{3}", "***")  + "]";
	}
	
	
	
	public static class PaymentId implements Serializable {
	   
		private static final long serialVersionUID = -7321416499047242338L;
		private long cardNumber;
		
	}
	
}
