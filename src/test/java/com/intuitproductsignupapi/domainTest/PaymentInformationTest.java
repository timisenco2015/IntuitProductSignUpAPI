package com.intuitproductsignupapi.domainTest;

	import static org.junit.Assert.assertEquals;

import org.junit.Test;
	import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

import com.intuitproductsignupapi.domain.PaymentInformation;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class PaymentInformationTest {
		
		

		@Test
		public void testSettersGetters() {
			
			//check setter and getter for card number
			// A)
			PaymentInformation paymentInformation = new PaymentInformation();
			paymentInformation.setCardNumber(4567890495768456l);
			long testResult1 = 4567890495768456l;
			assertEquals(testResult1,  paymentInformation.getCardNumber());
			
			// B)
			
			paymentInformation.setCardNumber(4567891957684566l);
			 testResult1 = 4567891957684566l;
			assertEquals(testResult1,  paymentInformation.getCardNumber());
			
		
			
			//check setter and getter for card number
			
			// A)
			
			paymentInformation.setCvv(987);
			int testResult2 = 987;
			assertEquals(testResult2,  paymentInformation.getCvv());
			
			// B)
			
			paymentInformation.setCvv(657);
			testResult2 = 657;
			assertEquals(testResult2,  paymentInformation.getCvv());
			
			
			//check  setter and getter for card expirydate
			
			// A)
			paymentInformation.setExpiryDate("08/19");
			String testResult3 = "08/19";
			assertEquals(testResult3,  paymentInformation.getExpiryDate());
			
			// B)
			paymentInformation.setExpiryDate("06/22");
			testResult3 = "06/22";
			assertEquals(testResult3,  paymentInformation.getExpiryDate());	
			
			
			//check  setter and getter for card expirydate
			
			// A)
			paymentInformation.setPaymentAddress("24 Octopus Street");
			String testResult4 = "24 Octopus Street";
			assertEquals(testResult4,  paymentInformation.getPaymentAddress());
			
			// B)
			paymentInformation.setPaymentAddress("45 Georgetown Avenue");
			testResult4 = "45 Georgetown Avenue";
			assertEquals(testResult4,  paymentInformation.getPaymentAddress());	
			
			
			
			//check all methods

			assertEquals("45 Georgetown Avenue",  paymentInformation.getPaymentAddress());
			assertEquals("06/22",  paymentInformation.getExpiryDate());
			assertEquals(657,  paymentInformation.getCvv());
			assertEquals(4567891957684566l,  paymentInformation.getCardNumber());
		}

	}

