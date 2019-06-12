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
import com.intuitproductsignupapi.controller.PaymentController;
import com.intuitproductsignupapi.dto.Payment;
import com.intuitproductsignupapi.service.PaymentInformationService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

	
	
	 
	   
	   
	   @Autowired
		private MockMvc mockMvc;
		
		@Mock
		private PaymentInformationService paymentInformationService;
		
		@InjectMocks
		private PaymentController paymentController;
		
		@Before
		public void setUp() throws Exception
		{
			mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
		}

		
		@Test
		public void testAddNewUser() throws Exception
		{
			 Payment payment = new Payment();
			   payment.setCardNumber(3456789238567845l);
			   payment.setCvv(667);
			   payment.setExpiryDate("06/2019");
			   payment.setPaymentAddress("506 Armitage Crescent, Edmonton");
			
			
			
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/productsignupapi/addPaymentDetails")
				      .content(asJsonString(payment))
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
