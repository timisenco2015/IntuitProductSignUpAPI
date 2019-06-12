package com.intuitproductsignupapi.repository;


import org.springframework.data.repository.CrudRepository;
import com.intuitproductsignupapi.dto.Payment;


public interface PaymentRepository extends CrudRepository<Payment, Long> {
	
	public Payment findByCardNumber(long cardNumber);
}
