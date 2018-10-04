package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dto.Login;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> s) {
		return Login.class.equals(s);
	}

	@Override
	public void validate(Object obj, Errors e) {
		Login x = (Login)obj;
		if (x.getUserid().length() == 0) {
			e.rejectValue("userId", "required", "아이디는 필수입니다");
		}

	}

}
