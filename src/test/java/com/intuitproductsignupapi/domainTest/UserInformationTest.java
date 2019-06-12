package com.intuitproductsignupapi.domainTest;




import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.domain.UserInformation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationTest {

	@Test
	public void testSettersGetters() {
		
		UserInformation userInformation = new UserInformation();
		
		//test setter and getter for user email
		// A)
		userInformation.setUserEmail("abc@gmail.com");
		String testResult1 = "abc@gmail.com";
		assertEquals(testResult1,  userInformation.getUserEmail());
		
		// B)
		
		userInformation.setUserEmail("fgh@gmail.com");
		testResult1 = "fgh@gmail.com";
		assertEquals(testResult1,  userInformation.getUserEmail());
		
		
		//test setter and getter for user address
		// A)
		userInformation.setUserAddress("605 Arizona Road");
		String testResult2 = "605 Arizona Road";
		assertEquals(testResult2,  userInformation.getUserAddress());
				
		// B)
				
		userInformation.setUserAddress("204 - 1965 ParkView Avenue");
		testResult2 = "204 - 1965 ParkView Avenue";
		assertEquals(testResult2,  userInformation.getUserAddress());
				
		//test setter and getter for user fullname
		// A)
		userInformation.setUserFullName("Ayobami O Idowu");
		String testResult3 = "Ayobami O Idowu";
		assertEquals(testResult3,  userInformation.getUserFullName());
				
		//B)
		userInformation.setUserFullName("John Bob");
		testResult3 = "John Bob";
		assertEquals(testResult3,  userInformation.getUserFullName());
				
				
		//test all class methods
		assertEquals("John Bob",  userInformation.getUserFullName());
		assertEquals( "204 - 1965 ParkView Avenue",  userInformation.getUserAddress());
		assertEquals("fgh@gmail.com",  userInformation.getUserEmail());
	}

}

