package com.intuitproductsignupapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication


@ComponentScan(basePackages={"com.intuitproductsignupapi","com.intuitproductsignupapi.controller","com.intuitproductsignupapi.domain","com.intuitproductsignupapi.dto","com.intuitproductsignupapi.repository","com.intuitproductsignupapi.service","com.intuitproductsignupapi.dto"})
@EntityScan(basePackageClasses = {com.intuitproductsignupapi.dto.User.class,com.intuitproductsignupapi.dto.Payment.class
		})

@EnableJpaRepositories(basePackageClasses = {com.intuitproductsignupapi.repository.UserRepository.class, com.intuitproductsignupapi.repository.PaymentRepository.class
		})
public class IntuitProductSignUpApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntuitProductSignUpApiApplication.class, args);
		

	}

}








