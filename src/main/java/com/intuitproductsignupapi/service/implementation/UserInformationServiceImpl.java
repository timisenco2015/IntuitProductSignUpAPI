package com.intuitproductsignupapi.service.implementation;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.intuitproductsignupapi.IntuitProductSignUpApiApplication;
import com.intuitproductsignupapi.domain.UserInformation;
import com.intuitproductsignupapi.dto.User;
import com.intuitproductsignupapi.repository.UserRepository;
import com.intuitproductsignupapi.service.UserInformationService;
import com.intuitproductsignupapi.service.Validation.ValidateUserInformation;

@Service("UserInformationService")
@Transactional(propagation=Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserInformationServiceImpl implements UserInformationService {
	private static final Logger logger = LoggerFactory.getLogger(IntuitProductSignUpApiApplication.class);
	
	 
	@Autowired
	UserRepository  userRepository;
	
	 
	public String addUser(UserInformation userInformation,BindingResult result)
	{
		logger.info("User information service launched");
		   

		new ValidateUserInformation().validate(userInformation, result);
		ErrorHandler  errorHandler = new ErrorHandler()	;
		if (result.hasErrors())
		{
			errorHandler.setErrorStatus("Failed");
			errorHandler.setMessage("Failed validation test for all or most of the fields");
			errorHandler.setAllErrorObject(result.getAllErrors());
			logger.info("User information validation error. Error info: "+errorHandler.getMessageObject());
		}
		else
		{
			User user = new User();
			user.setUserEmail(userInformation.getUserEmail());
			user.setUserAddress(userInformation.getUserAddress());
			user.setUserFullName(userInformation.getUserFullName());
			User savedUser = userRepository.save(user);
			if (savedUser instanceof User)
			{
				errorHandler.setErrorStatus("Success");
				errorHandler.setMessage("saved into our record");
				errorHandler.setReturnEntityObject(savedUser);
				logger.info("User information saved: user information: "+errorHandler.getMessageObject());
				
			}
			else
			{
				errorHandler.setErrorStatus("Success");
				errorHandler.setMessage("saved into our record");
				logger.info("Unable to save user information to the database: "+errorHandler.getMessageObject());
				
			}
		}
			
		return errorHandler.getMessageObject();
	}
	 
	

}
