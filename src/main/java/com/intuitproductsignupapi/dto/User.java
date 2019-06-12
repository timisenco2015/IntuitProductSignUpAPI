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
@Table(name = "userinformationstable")
@IdClass(User.UserId.class)

public class User implements Serializable {


	private static final long serialVersionUID = -7321416499047242338L;
	
	@Id
	@Column(name = "email", nullable = false)
	private String emailAddress;

	

	
	@Column(name = "fullname", nullable = false)
	private String userFullName;
		
	
	@Column(name = "address", nullable = false)
	private String address;
	
	
	
	
	
	public User()
	{
		
	}
	
	

	
	@Bean
	public String getUserFullName()
	{
		return userFullName;
	}
	
	
	@Bean
	public String getUserAddress()
	{
		return address;
	}
	
	@Bean
	public String getUserEmail()
	{
		return emailAddress;
	}
	
	
	@Bean
	public void setUserFullName(String userName)
	{
		userFullName = userName;
	}
	
	
	@Bean
	public void setUserAddress(String userAddress)
	{
		address = userAddress;
	}
	
	@Bean
	public void setUserEmail(String userEmail)
	{
		emailAddress = userEmail;
	}
	
	
	

	@Override
	public String toString() {
		return "UserInformation [address=" + address + ", emailAddress=" + emailAddress + ", userFullName="
				+ userFullName.replaceAll(userFullName.substring(2,userFullName.length()/3),StringUtils.repeat('*', userFullName.length()/3) ) + "]";
	}
	
	public static class UserId implements Serializable {
		   
		private static final long serialVersionUID = -7321416499047242338L;

		private String emailAddress;
		
		
	}
}


