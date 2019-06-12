package com.intuitproductsignupapi.serviceTest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.service.PaymentInformationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentInformationServiceImplTest  {

	 @Autowired
	 PaymentInformationService paymentInformationService;
	
	 
	
	 
	 
	 	@Test
		public void TestPaymentAddress()
		{
		 	//checks for invalid character(s) in payment address field 
			PaymentInformation paymentInformationTest1 = new PaymentInformation();
			paymentInformationTest1.setPaymentAddress("616 Armitage@@@@ Crescent");
			paymentInformationTest1.setCardNumber(6767121345468798l);
			paymentInformationTest1.setExpiryDate("03/19");
			paymentInformationTest1.setCvv(929);
			
			 DataBinder binderTest1 = new DataBinder(paymentInformationTest1);
			 String message = paymentInformationService.addUserPayment(paymentInformationTest1, binderTest1.getBindingResult());
					 
			
			 try {
				 JSONObject messageObjectTest1  = new JSONObject(message);
				assertEquals("field contains invalid characters", messageObjectTest1 .get("paymentAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			//checks when setUserAddress is not called
			 	PaymentInformation paymentInformationTest2 = new PaymentInformation();
				paymentInformationTest2.setCardNumber(6767121345468798l);
				paymentInformationTest2.setExpiryDate("03/19");
				paymentInformationTest2.setCvv(929);
			 DataBinder binderTest2 = new DataBinder(paymentInformationTest2);
			 message = paymentInformationService.addUserPayment(paymentInformationTest2, binderTest2.getBindingResult());
				try {
				 JSONObject messageObjectTest2  = new JSONObject(message);
				assertEquals("field required", messageObjectTest2.get("paymentAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			
			//checks field empty value
				PaymentInformation paymentInformationTest3 = new PaymentInformation();
				paymentInformationTest3.setPaymentAddress("");
				paymentInformationTest3.setCardNumber(6767121345468798l);
				paymentInformationTest3.setExpiryDate("03/19");
				paymentInformationTest3.setCvv(929);
			 DataBinder binderTest3 = new DataBinder(paymentInformationTest3);
			 message = paymentInformationService.addUserPayment(paymentInformationTest3, binderTest3.getBindingResult());
			 try {
				 JSONObject messageObjectTest3  = new JSONObject(message);
				assertEquals("field required",  messageObjectTest3.get("paymentAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			
			//checks field length is less than minimum length required (min = 10)
			PaymentInformation paymentInformationTest4 = new PaymentInformation();
				paymentInformationTest4.setPaymentAddress("616 Arm");
				paymentInformationTest4.setCardNumber(6767121345468798l);
				paymentInformationTest4.setExpiryDate("03/19");
				paymentInformationTest4.setCvv(929);
			 DataBinder binderTest4 = new DataBinder(paymentInformationTest4);
			 message = paymentInformationService.addUserPayment(paymentInformationTest4, binderTest4.getBindingResult());
			 try {
				 JSONObject messageObjectTest4  = new JSONObject(message);
				assertEquals("field length must be between 10 and 80",  messageObjectTest4.get("paymentAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 
				//checks field length is greater than minimum length required (min = 10)
			PaymentInformation paymentInformationTest5 = new PaymentInformation();
				paymentInformationTest5.setPaymentAddress("616 Portage Avenue,svsvsvsvsvsvsvvsvvcvcvcvcvvvc"
				 		+ "zbzbbcvczvcxvxzvvvvvvvvvvvvvvvvvvxzcvbffbfgjhjgbdfgffdhghgngfbdzfbd"
				 		+ "fbdfhgfhgfhgfhfghfghgfhfghngfhgfhgfhgfhgfbhfdbhdfhbdfhrhynyghhtyjmn"
				 		+ "ngfjgmhgmhjngfngfnhgmghmghnfgnhmhm");
				paymentInformationTest5.setCardNumber(6767121345468798l);
				paymentInformationTest5.setExpiryDate("03/19");
				paymentInformationTest5.setCvv(929);
			 DataBinder binderTest5 = new DataBinder(paymentInformationTest5);
			 message = paymentInformationService.addUserPayment(paymentInformationTest5, binderTest5.getBindingResult());
			 try {
				 JSONObject messageObjectTest5  = new JSONObject(message);
				assertEquals("field length must be between 10 and 80",  messageObjectTest5.get("paymentAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 
			 
			//checks field length is between the minimum length and maximun length required (min = 10, max=80)
			 PaymentInformation paymentInformationTest6 = new PaymentInformation();
				paymentInformationTest6.setPaymentAddress("616 Portage Avenue");
				paymentInformationTest6.setCardNumber(6767121345468798l);
				paymentInformationTest6.setExpiryDate("03/19");
				paymentInformationTest6.setCvv(929);
			 
			 DataBinder binderTest6 = new DataBinder(paymentInformationTest6);
			 message = paymentInformationService.addUserPayment(paymentInformationTest6, binderTest6.getBindingResult());
			 try {
				 JSONObject messageObjectTest6  = new JSONObject(message);
				assertEquals("Success",  messageObjectTest6.get("errorStatus").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 
		}
	 
	 
	 	@Test
		public void TestPaymentCardNumber()
		{
	 		//checks for payment card number field is zero length 
			PaymentInformation paymentInformationTest1 = new PaymentInformation();
			paymentInformationTest1.setPaymentAddress("616 Armitage Crescent");
			paymentInformationTest1.setCardNumber(0l);
			paymentInformationTest1.setExpiryDate("03/19");
			paymentInformationTest1.setCvv(929);
			
			 DataBinder binderTest1 = new DataBinder(paymentInformationTest1);
			 String message = paymentInformationService.addUserPayment(paymentInformationTest1, binderTest1.getBindingResult());
					 
			
			 try {
				 JSONObject messageObjectTest1  = new JSONObject(message);
				assertEquals("field required", messageObjectTest1.get("cardNumber").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			//checks for payment card number field total digit is less than 16   
				PaymentInformation paymentInformationTest2 = new PaymentInformation();
				paymentInformationTest2.setPaymentAddress("616 Armitage Crescent");
				paymentInformationTest2.setCardNumber(345435443634l);
				paymentInformationTest2.setExpiryDate("03/19");
				paymentInformationTest2.setCvv(929);
				 DataBinder binderTest2 = new DataBinder(paymentInformationTest2);
				 message = paymentInformationService.addUserPayment(paymentInformationTest2, binderTest2.getBindingResult());
						 
				
				 try {
					 JSONObject messageObjectTest2  = new JSONObject(message);
					assertEquals("card number must be 16 numbers", messageObjectTest2.get("cardNumber").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				//checks for payment card number field total digit is more than 16   
					PaymentInformation paymentInformationTest3 = new PaymentInformation();
					paymentInformationTest3.setPaymentAddress("616 Armitage Crescent");
					paymentInformationTest3.setCardNumber(43545678466643634l);
					paymentInformationTest3.setExpiryDate("03/19");
					paymentInformationTest3.setCvv(929);
					 DataBinder binderTest3 = new DataBinder(paymentInformationTest3);
					 message = paymentInformationService.addUserPayment(paymentInformationTest3, binderTest3.getBindingResult());
							 
					
					 try {
						 JSONObject messageObjectTest3  = new JSONObject(message);
						assertEquals("card number must be 16 numbers", messageObjectTest3.get("cardNumber").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
					//checks for payment card number field total digit is exact 16 digits  
					PaymentInformation paymentInformationTest4 = new PaymentInformation();
						paymentInformationTest4.setPaymentAddress("616 Portage Avenue");
						paymentInformationTest4.setCardNumber(6767121345468798l);
						paymentInformationTest4.setExpiryDate("03/19");
						paymentInformationTest4.setCvv(929);
					 
					 DataBinder binderTest4 = new DataBinder(paymentInformationTest4);
					 message = paymentInformationService.addUserPayment(paymentInformationTest4, binderTest4.getBindingResult());
					 try {
						 JSONObject messageObjectTest4  = new JSONObject(message);
						assertEquals("Success",  messageObjectTest4.get("errorStatus").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 
		}
	 	
	 	
	 	@Test
		public void TestPaymentCardCvv()
		{
	 		//checks for payment card cvv field is zero length
			PaymentInformation paymentInformationTest1 = new PaymentInformation();
			paymentInformationTest1.setPaymentAddress("616 Armitage Crescent");
			paymentInformationTest1.setCardNumber(0l);
			paymentInformationTest1.setExpiryDate("03/19");
			paymentInformationTest1.setCvv(0);
			
			 DataBinder binderTest1 = new DataBinder(paymentInformationTest1);
			 String message = paymentInformationService.addUserPayment(paymentInformationTest1, binderTest1.getBindingResult());
					 
			
			 try {
				 JSONObject messageObjectTest1  = new JSONObject(message);
				assertEquals("field required", messageObjectTest1.get("cvv").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			//checks for payment card cvv field total digit is less than 3   
				PaymentInformation paymentInformationTest2 = new PaymentInformation();
				paymentInformationTest2.setPaymentAddress("616 Armitage Crescent");
				paymentInformationTest2.setCardNumber(6767121345468798l);
				paymentInformationTest2.setExpiryDate("03/19");
				paymentInformationTest2.setCvv(92);
				 DataBinder binderTest2 = new DataBinder(paymentInformationTest2);
				 message = paymentInformationService.addUserPayment(paymentInformationTest2, binderTest2.getBindingResult());
						 
				
				 try {
					 JSONObject messageObjectTest2  = new JSONObject(message);
					assertEquals("card cvv must be 3 numbers", messageObjectTest2.get("cvv").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				//checks for payment card cvv field total digit is more than 3   
					PaymentInformation paymentInformationTest3 = new PaymentInformation();
					paymentInformationTest3.setPaymentAddress("616 Armitage Crescent");
					paymentInformationTest3.setCardNumber(6767121345468798l);
					paymentInformationTest3.setExpiryDate("03/19");
					paymentInformationTest3.setCvv(92989);
					 DataBinder binderTest3 = new DataBinder(paymentInformationTest3);
					 message = paymentInformationService.addUserPayment(paymentInformationTest3, binderTest3.getBindingResult());
							 
					
					 try {
						 JSONObject messageObjectTest3  = new JSONObject(message);
						assertEquals("card cvv must be 3 numbers", messageObjectTest3.get("cvv").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
					//checks for payment card cvv field total digit is exact 3 digits  
					PaymentInformation paymentInformationTest4 = new PaymentInformation();
						paymentInformationTest4.setPaymentAddress("616 Portage Avenue");
						paymentInformationTest4.setCardNumber(6767121345468798l);
						paymentInformationTest4.setExpiryDate("03/19");
						paymentInformationTest4.setCvv(929);
					 
					 DataBinder binderTest4 = new DataBinder(paymentInformationTest4);
					 message = paymentInformationService.addUserPayment(paymentInformationTest4, binderTest4.getBindingResult());
					 try {
						 JSONObject messageObjectTest4  = new JSONObject(message);
						assertEquals("Success",  messageObjectTest4.get("errorStatus").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 
		}
	 	
	 	@Test
		public void TestPaymentCardExpiryDate()
		{
	 		//checks when setExpiryDate is not called
		 	PaymentInformation paymentInformationTest1 = new PaymentInformation();
		 	paymentInformationTest1.setPaymentAddress("616 Portage Avenue");
		 	paymentInformationTest1.setCardNumber(6767121345468798l);
			paymentInformationTest1.setCvv(929);
		 DataBinder binderTest1 = new DataBinder(paymentInformationTest1);
		 String message = paymentInformationService.addUserPayment(paymentInformationTest1, binderTest1.getBindingResult());
			try {
			 JSONObject messageObjectTest1  = new JSONObject(message);
			assertEquals("field required", messageObjectTest1.get("expiryDate").toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		
		//checks expiry date field empty value
			PaymentInformation paymentInformationTest2 = new PaymentInformation();
			paymentInformationTest2.setPaymentAddress("616 Portage Avenue");
			paymentInformationTest2.setCardNumber(6767121345468798l);
			paymentInformationTest2.setExpiryDate("");
			paymentInformationTest2.setCvv(929);
		 DataBinder binderTest2 = new DataBinder(paymentInformationTest2);
		 message = paymentInformationService.addUserPayment(paymentInformationTest2, binderTest2.getBindingResult());
		 try {
			 JSONObject messageObjectTest2  = new JSONObject(message);
			assertEquals("field required",  messageObjectTest2.get("expiryDate").toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		 
			//check for invalid date format
			PaymentInformation paymentInformationTest3 = new PaymentInformation();
			paymentInformationTest3.setPaymentAddress("616 Portage Avenue");
			paymentInformationTest3.setCardNumber(6767121345468798l);
			paymentInformationTest3.setExpiryDate("08-07-19");
			paymentInformationTest3.setCvv(929);
		 DataBinder binderTest3 = new DataBinder(paymentInformationTest3);
		 message = paymentInformationService.addUserPayment(paymentInformationTest3, binderTest3.getBindingResult());
		 try {
			 JSONObject messageObjectTest3  = new JSONObject(message);
			assertEquals("field contains invalid characters",  messageObjectTest3.get("expiryDate").toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		//check for valid date format
			PaymentInformation paymentInformationTest4 = new PaymentInformation();
			paymentInformationTest4.setPaymentAddress("616 Portage Avenue");
			paymentInformationTest4.setCardNumber(6767121345468798l);
			paymentInformationTest4.setExpiryDate("07/19");
			paymentInformationTest4.setCvv(929);
		 DataBinder binderTest4 = new DataBinder(paymentInformationTest4);
		 message = paymentInformationService.addUserPayment(paymentInformationTest4, binderTest4.getBindingResult());
		 try {
			 JSONObject messageObjectTest4  = new JSONObject(message);
				assertEquals("Success",  messageObjectTest4.get("errorStatus").toString());
				} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		}
		
}

