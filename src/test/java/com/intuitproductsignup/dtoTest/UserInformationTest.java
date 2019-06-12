package com.intuitproductsignup.dtoTest;




import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.intuitproductsignupapi.dto.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationTest {

	@Test
	public void testSettersGetters() {
		
		User user = new User();
		
		//test setter and getter for user email
		// A)
		user.setUserEmail("abc@gmail.com");
		String testResult1 = "abc@gmail.com";
		assertEquals(testResult1,  user.getUserEmail());
		
		// B)
		user.setUserEmail("fgh@gmail.com");
		testResult1 = "fgh@gmail.com";
		assertEquals(testResult1,  user.getUserEmail());
		
		
		//test setter and getter for user address
		// A)
		user.setUserAddress("605 Arizona Road");
		String testResult2 = "605 Arizona Road";
		assertEquals(testResult2,  user.getUserAddress());
				
		// B)
		user.setUserAddress("204 - 1965 ParkView Avenue");
		testResult2 = "204 - 1965 ParkView Avenue";
		assertEquals(testResult2,  user.getUserAddress());
				
		//test setter and getter for user fullname
		// A)
		user.setUserFullName("Ayobami O Idowu");
		String testResult3 = "Ayobami O Idowu";
		assertEquals(testResult3,  user.getUserFullName());
				
		//B)
		user.setUserFullName("John Bob");
		testResult3 = "John Bob";
		assertEquals(testResult3,  user.getUserFullName());
				
		//test all class methods
		assertEquals("John Bob",  user.getUserFullName());
		assertEquals( "204 - 1965 ParkView Avenue",  user.getUserAddress());
		assertEquals("fgh@gmail.com",  user.getUserEmail());
	}

}

