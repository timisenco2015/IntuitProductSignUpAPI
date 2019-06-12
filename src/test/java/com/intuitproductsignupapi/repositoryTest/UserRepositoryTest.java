package com.intuitproductsignupapi.repositoryTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuitproductsignupapi.dto.User;
import com.intuitproductsignupapi.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	
	 @Autowired
	  private UserRepository userRepository;

	  @Test
	  public void saveTest() {
	    User user = new User();
	    user.setUserAddress("34 George Way");
	    user.setUserEmail("idowutimi@gmail.com");
	    user.setUserFullName("Ayobami O Idowu");
	    userRepository.save(user);
	   assertNotNull(userRepository.findByEmailAddress("idowutimi@gmail.com"));
	  }
}
