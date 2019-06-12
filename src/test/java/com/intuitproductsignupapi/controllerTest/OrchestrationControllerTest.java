package com.intuitproductsignupapi.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuitproductsignupapi.controller.OrchestrationController;
import com.intuitproductsignupapi.domain.PaymentInformation;
import com.intuitproductsignupapi.domain.RequestWrapper;
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.service.PaymentInformationService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class OrchestrationControllerTest {


	   @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private PaymentInformationService paymentInformationService;
		
		@InjectMocks
		private OrchestrationController orchestrationController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(orchestrationController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			 PaymentInformation paymentInformation = new PaymentInformation();
			 paymentInformation.setCardNumber(3456789238567845l);
			 paymentInformation.setCvv(667);
			 paymentInformation.setExpiryDate("06/2019");
			 paymentInformation.setPaymentAddress("506 Armitage Crescent, Edmonton");
			
			   UserInformation userInformation = new UserInformation();
				userInformation.setUserAddress("34 George Way");
				userInformation.setUserEmail("idowutimi@gmail.com");
				userInformation.setUserFullName("Ayobami O Idowu");
				
				
				RequestWrapper requestWrapper = new RequestWrapper();
				requestWrapper.setPaymentInformation(paymentInformation);
				requestWrapper.setUserInformation(userInformation);
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/productsignupapi/addPaymentDetails")
				      .content(asJsonString(requestWrapper))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isCreated());
				     
		
		}
		
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
		
	

}
