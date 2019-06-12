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
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.service.UserInformationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInformationServiceImplTest  {

	 @Autowired
	 UserInformationService userInformationService;
	
	 
	 @Test
	public void contextLoads() 
	 {
		//checks for all fields for valid value
		 UserInformation userInformation = new  UserInformation();
		 userInformation.setUserAddress("616 Armitage Crescent");
		 userInformation.setUserEmail("idowutimi@gmail.com");
		 userInformation.setUserFullName("Ayobami O Idowu");
		 DataBinder binder = new DataBinder(userInformation);
		 
		 String message = userInformationService.addUser(userInformation, binder.getBindingResult());
		 JSONObject messageObject = null;
		 try {
			messageObject = new JSONObject(message);
			assertEquals("Success", messageObject.get("errorStatus").toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		 
		@Test
		public void TestUserAddress()
		{
			 UserInformation userInformationTest1 = new  UserInformation();
			 
			//checks for invalid character(s) in user address field 
			 userInformationTest1.setUserAddress("616 Armitage@@@@ Crescent");
			 userInformationTest1.setUserEmail("idowutimi@gmail.com");
			 userInformationTest1.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest1 = new DataBinder(userInformationTest1);
			 String message = userInformationService.addUser(userInformationTest1, binderTest1.getBindingResult());
			
			 try {
				 JSONObject messageObjectTest1  = new JSONObject(message);
				assertEquals("field contains invalid characters", messageObjectTest1 .get("userAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			//checks when setUserAddress is not called
			 UserInformation userInformationTest2 = new  UserInformation();
			 userInformationTest2.setUserEmail("idowutimi@gmail.com");
			 userInformationTest2.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest2 = new DataBinder(userInformationTest2);
			  message = userInformationService.addUser(userInformationTest2, binderTest2.getBindingResult());
			 try {
				 JSONObject messageObjectTest2  = new JSONObject(message);
				assertEquals("field required", messageObjectTest2.get("userAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			
			//checks field empty value
			 UserInformation userInformationTest3 = new  UserInformation();
			 userInformationTest3.setUserAddress("");
			 userInformationTest3.setUserEmail("idowutimi@gmail.com");
			 userInformationTest3.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest3 = new DataBinder(userInformationTest3);
			  message = userInformationService.addUser(userInformationTest3,  binderTest3.getBindingResult());
			
			 try {
				 JSONObject messageObjectTest3  = new JSONObject(message);
				assertEquals("field required",  messageObjectTest3.get("userAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			
			//checks field length is less than minimum length required (min = 10)
			 UserInformation userInformationTest4 = new  UserInformation();
			 userInformationTest4.setUserAddress("616 Arm");
			 userInformationTest4.setUserEmail("idowutimi@gmail.com");
			 userInformationTest4.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest4 = new DataBinder(userInformationTest4);
			  message = userInformationService.addUser(userInformationTest4,  binderTest4.getBindingResult());
			
			 try {
				 JSONObject messageObjectTest4  = new JSONObject(message);
				assertEquals("field length must be between 10 and 80",  messageObjectTest4.get("userAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 
				//checks field length is greater than minimum length required (min = 10)
			 UserInformation userInformationTest5 = new  UserInformation();
			 userInformationTest5.setUserAddress("616 Portage Avenue,svsvsvsvsvsvsvvsvvcvcvcvcvvvc"
			 		+ "zbzbbcvczvcxvxzvvvvvvvvvvvvvvvvvvxzcvbffbfgjhjgbdfgffdhghgngfbdzfbd"
			 		+ "fbdfhgfhgfhgfhfghfghgfhfghngfhgfhgfhgfhgfbhfdbhdfhbdfhrhynyghhtyjmn"
			 		+ "ngfjgmhgmhjngfngfnhgmghmghnfgnhmhm");
			 userInformationTest5.setUserEmail("idowutimi@gmail.com");
			 userInformationTest5.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest5 = new DataBinder(userInformationTest5);
			  message = userInformationService.addUser(userInformationTest5,  binderTest5.getBindingResult());
			
			 try {
				 JSONObject messageObjectTest5  = new JSONObject(message);
				assertEquals("field length must be between 10 and 80",  messageObjectTest5.get("userAddress").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 
			 
				//checks field length is between the minimum length and maximun length required (min = 10, max=80)
			 UserInformation userInformationTest6 = new  UserInformation();
			 userInformationTest6.setUserAddress("616 Portage Avenue");
			 userInformationTest6.setUserEmail("idowutimi@gmail.com");
			 userInformationTest6.setUserFullName("Ayobami O Idowu");
			 DataBinder binderTest6 = new DataBinder(userInformationTest6);
			  message = userInformationService.addUser(userInformationTest6,  binderTest6.getBindingResult());
			
			 try {
				 JSONObject messageObjectTest6  = new JSONObject(message);
				assertEquals("Success",  messageObjectTest6.get("errorStatus").toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 
		}
		 
	
		@Test
		public void TestUserFullName()
		{
			 UserInformation userInformationTest1 = new  UserInformation();
			 
				//checks for invalid character(s) in user address field 
				 userInformationTest1.setUserAddress("616 Armitage Crescent");
				 userInformationTest1.setUserEmail("idowutimi@gmail.com");
				 userInformationTest1.setUserFullName("Ayobami[]][kk O Idowu");
				 DataBinder binderTest1 = new DataBinder(userInformationTest1);
				 String message = userInformationService.addUser(userInformationTest1, binderTest1.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest1  = new JSONObject(message);
					assertEquals("field contains invalid characters", messageObjectTest1 .get("userFullName").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
				//checks when setUserAddress is not called
				 UserInformation userInformationTest2 = new  UserInformation();
				 userInformationTest1.setUserAddress("616 Armitage Crescent");
				 userInformationTest2.setUserEmail("idowutimi@gmail.com");
				 DataBinder binderTest2 = new DataBinder(userInformationTest2);
				  message = userInformationService.addUser(userInformationTest2, binderTest2.getBindingResult());
				 try {
					 JSONObject messageObjectTest2  = new JSONObject(message);
					assertEquals("field required", messageObjectTest2.get("userFullName").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				
				//checks field empty value
				 UserInformation userInformationTest3 = new  UserInformation();
				 userInformationTest1.setUserAddress("616 Armitage Crescent");
				 userInformationTest3.setUserEmail("idowutimi@gmail.com");
				 userInformationTest3.setUserFullName("");
				 DataBinder binderTest3 = new DataBinder(userInformationTest3);
				  message = userInformationService.addUser(userInformationTest3,  binderTest3.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest3  = new JSONObject(message);
					assertEquals("field required",  messageObjectTest3.get("userFullName").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				
				//checks field length is less than minimum length required (min = 10)
				 UserInformation userInformationTest4 = new  UserInformation();
				 userInformationTest4.setUserAddress("616 Armitage Crescent");
				 userInformationTest4.setUserEmail("idowutimi@gmail.com");
				 userInformationTest4.setUserFullName("Ayobami");
				 DataBinder binderTest4 = new DataBinder(userInformationTest4);
				  message = userInformationService.addUser(userInformationTest4,  binderTest4.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest4  = new JSONObject(message);
					assertEquals("field length must be between 10 and 30",  messageObjectTest4.get("userFullName").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				 
					//checks field length is greater than minimum length required (min = 10)
				 UserInformation userInformationTest5 = new  UserInformation();
				 userInformationTest5.setUserAddress("616 Portage Avenue, Edmonton");
				 userInformationTest5.setUserEmail("idowutimi@gmail.com");
				 userInformationTest5.setUserFullName("Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu Ayobami O Idowu");
				 DataBinder binderTest5 = new DataBinder(userInformationTest5);
				  message = userInformationService.addUser(userInformationTest5,  binderTest5.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest5  = new JSONObject(message);
					assertEquals("field length must be between 10 and 30",  messageObjectTest5.get("userFullName").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				 
				 
					//checks field length is between the minimum length and maximun length required (min = 10, max=80)
				 UserInformation userInformationTest6 = new  UserInformation();
				 userInformationTest6.setUserAddress("616 Portage Avenue");
				 userInformationTest6.setUserEmail("idowutimi@gmail.com");
				 userInformationTest6.setUserFullName("Ayobami O Idowu");
				 DataBinder binderTest6 = new DataBinder(userInformationTest6);
				  message = userInformationService.addUser(userInformationTest6,  binderTest6.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest6  = new JSONObject(message);
					assertEquals("Success",  messageObjectTest6.get("errorStatus").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
		}
	
		@Test
		public void TestUserEmail()
		{
			 UserInformation userInformationTest1 = new  UserInformation();
			 
				//checks email field is null 
				 userInformationTest1.setUserAddress("616 Armitage Crescent");
		
				 userInformationTest1.setUserFullName("Ayobami O Idowu");
				 DataBinder binderTest1 = new DataBinder(userInformationTest1);
				 String message = userInformationService.addUser(userInformationTest1, binderTest1.getBindingResult());
				
				 try {
					 JSONObject messageObjectTest1  = new JSONObject(message);
					assertEquals("field required", messageObjectTest1 .get("userEmail").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 UserInformation userInformationTest2 = new  UserInformation();
				 
					//checks email field is null 
					 userInformationTest2.setUserAddress("616 Armitage Crescent");
					 userInformationTest2.setUserEmail("");
					 userInformationTest2.setUserFullName("Ayobami O Idowu");
					 DataBinder binderTest2 = new DataBinder(userInformationTest2);
					 message = userInformationService.addUser(userInformationTest2, binderTest2.getBindingResult());
					
					 try {
						 JSONObject messageObjectTest2  = new JSONObject(message);
						assertEquals("field required", messageObjectTest2 .get("userEmail").toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
					//checks email field is not valid 
					 UserInformation userInformationTest3 = new  UserInformation();
					 userInformationTest3.setUserAddress("616 Armitage Crescent");
						 userInformationTest3.setUserEmail("idowutimi@gmail");
						 userInformationTest3.setUserFullName("Ayobami O Idowu");
						 DataBinder binderTest3 = new DataBinder(userInformationTest3);
						 message = userInformationService.addUser(userInformationTest3, binderTest3.getBindingResult());
						
						 try {
							 JSONObject messageObjectTest3  = new JSONObject(message);
							assertEquals("email address is invalid", messageObjectTest3.get("userEmail").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
						 
							//checks email field is valid 
						 UserInformation userInformationTest4 = new  UserInformation();
						 userInformationTest4.setUserAddress("616 Armitage Crescent");
						 userInformationTest4.setUserEmail("idowutimi@gmail.com");
						 userInformationTest4.setUserFullName("Ayobami O Idowu");
						 DataBinder binderTest4 = new DataBinder(userInformationTest4);
						 message = userInformationService.addUser(userInformationTest4, binderTest4.getBindingResult());
						
						 try {
							 JSONObject messageObjectTest4  = new JSONObject(message);
							assertEquals("Success",  messageObjectTest4.get("errorStatus").toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}
		
}

