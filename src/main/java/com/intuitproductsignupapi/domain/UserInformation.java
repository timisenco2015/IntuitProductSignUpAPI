package com.intuitproductsignupapi.domain;

import org.apache.commons.lang3.StringUtils;

public class UserInformation {

	
	private String address;
	
	
	private String emailAddress;
	
	
	private String userFullName;
	
	
	
	public  UserInformation()
	{
		
	}
	
	

	
	
	public String getUserFullName()
	{
		return userFullName;
	}
	
	
	
	public String getUserAddress()
	{
		return address;
	}

	public String getUserEmail()
	{
		return emailAddress;
	}
	
	
	public void setUserFullName(String userName)
	{
		userFullName = userName;
	}
	
	

	public void setUserAddress(String userAddress)
	{
		address = userAddress;
	}
	

	public void setUserEmail(String userEmail)
	{
		emailAddress = userEmail;
	}



	@Override
	public String toString() {
		return "UserInformation [address=" + address + ", emailAddress=" + emailAddress + ", userFullName="
				+ userFullName.replaceAll(userFullName.substring(2,userFullName.length()/3),StringUtils.repeat('*', userFullName.length()/3) ) + "]";
	}
	

	
	
	
	
}
