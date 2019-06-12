package com.intuitproductsignupapi.repositoryTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuitproductsignupapi.dto.Payment;
import com.intuitproductsignupapi.repository.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRepositoryTest {
	 
	@Autowired
	  private PaymentRepository paymentRepository;

	  @Test
	  public void saveTest() {
		  
		  
	   Payment payment = new Payment();
	   payment.setCardNumber(3456789238567845l);
	   payment.setCvv(667);
	   payment.setExpiryDate("06/2019");
	   payment.setPaymentAddress("506 Armitage Crescent, Edmonton");
	   paymentRepository.save(payment);
	 
	   assertNotNull(paymentRepository.findByCardNumber(3456789238567845l));
	  }

}
