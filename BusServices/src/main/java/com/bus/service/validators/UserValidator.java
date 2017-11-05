package com.bus.service.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bus.service.beans.User;

@Component("userValidator")
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		User user = (User) obj;
		System.out.println("Validating User.....!"+user);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name", "Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "user.age", "Age is mandatory");
		if (user.getAge() < 18 || user.getAge() > 80) {
			errors.rejectValue("age", "user.age.invalid");
		}

	}

}
