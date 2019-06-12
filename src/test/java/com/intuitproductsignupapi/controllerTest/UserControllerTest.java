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
import com.intuitproductsignupapi.controller.UserController;
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.service.UserInformationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UserInformationService userInformationService;
	
	@InjectMocks
	private UserController userController;
	
	@Before
	public void setUp() throws Exception
	{
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	
	@Test
	public void testAddNewUser() throws Exception
	{
		
		
		UserInformation userInformation = new UserInformation();
		userInformation.setUserAddress("34 George Way");
		userInformation.setUserEmail("idowutimi@gmail.com");
		userInformation.setUserFullName("Ayobami O Idowu");
		
		
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/productsignupapi/UserDetails")
			      .content(asJsonString(userInformation))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
			     // .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
}
