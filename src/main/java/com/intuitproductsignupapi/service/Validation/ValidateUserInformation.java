package com.intuitproductsignupapi.service.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;
import com.intuitproductsignupapi.domain.UserInformation;

public class ValidateUserInformation  implements Validator{

    boolean invalid = false;
	public boolean supports(Class<?> clazz) {
        return UserInformation.class.equals(clazz);
    }
	
		@Override
		public void validate(Object target, Errors errors) {
			UserInformation userInformation = (UserInformation) target;
			
			 // starting from line 19 to line 37 checks for valid user address 
			
			 if(userInformation.getUserAddress()!=null && userInformation.getUserAddress().length()>0 && !Character.isWhitespace(userInformation.getUserAddress().charAt(0)))
		     {
				 for(int i=0; i<userInformation.getUserAddress().length() && !invalid; i++) 
		         {

					 if (!Character.isDigit(userInformation.getUserAddress().charAt(i)) && !Character.isAlphabetic(userInformation.getUserAddress().charAt(i)) && !Character.isWhitespace(userInformation.getUserAddress().charAt(i)) && userInformation.getUserAddress().charAt(i)!='.' && userInformation.getUserAddress().charAt(i)!=','&& userInformation.getUserAddress().charAt(i)!='-')
		             {
						 invalid = true;
						 errors.rejectValue("userAddress", "field contains invalid characters");
		                  
		             }
		           }
				 if(!invalid)
	                {
	                	if(userInformation.getUserAddress().length()<10 || userInformation.getUserAddress().length()>80)
	                	{
	                		 errors.rejectValue("userAddress", "field length must be between 10 and 80");
	   	                  
	                	}
	                }
		        }
			 else
			 { 
		    	errors.rejectValue("userAddress", "field required");
		     }
			 
			 
			 
			 // starting from line 40 to line 57 checks for valid email address 
			 if(userInformation.getUserEmail()!=null&& userInformation.getUserEmail().length()>0 && !Character.isWhitespace(userInformation.getUserEmail().charAt(0)))
		     {
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +
			                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			                "A-Z]{2,7}$";
				 
				 Pattern pat = Pattern.compile(emailRegex);
			       if(!pat.matcher(userInformation.getUserEmail()).matches())
			       {
			    	   errors.rejectValue("userEmail", "email address is invalid");
			       }
		     }
			 else
			 {
				 errors.rejectValue("userEmail", "field required");
		     }
			 
			 
			 // starting from line 60 to line 84 checks for valid card fullname 
			 if(userInformation.getUserFullName()!=null&& userInformation.getUserFullName().length()>0 && !Character.isWhitespace(userInformation.getUserFullName().charAt(0)))
		     {
				
			      boolean invalid = false;
			            
			                  for(int i=0; i<userInformation.getUserFullName().length() && !invalid; i++) {
			                      if (!Character.isAlphabetic(userInformation.getUserFullName().charAt(i)) && userInformation.getUserFullName().charAt(i) != 32)
			                      {
			                          invalid = true;
			                          errors.rejectValue("userFullName", "field contains invalid characters");
			                         
			                      }
			                  }
			                  if(!invalid)
				                {
				                	if(userInformation.getUserFullName().length()<10 || userInformation.getUserFullName().length()>30)
				                	{
				                		 errors.rejectValue("userFullName", "field length must be between 10 and 30");
				   	                  
				                	}
				                }   
		       }
			   else
			   {
				   errors.rejectValue("userFullName", "field required");
			   }

			             
		    
			
		}
       

}
