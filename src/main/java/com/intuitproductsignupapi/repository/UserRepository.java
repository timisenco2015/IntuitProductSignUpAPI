package com.intuitproductsignupapi.repository;


import org.springframework.data.repository.CrudRepository;

import com.intuitproductsignupapi.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmailAddress(String emailAddress);
}
