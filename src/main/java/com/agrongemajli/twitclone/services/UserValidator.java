package com.agrongemajli.twitclone.services;

import com.agrongemajli.twitclone.models.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private AuthUserService authUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AuthUser user = (AuthUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (authUserService.findByUsername(user.getUsername()) != false) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "NotEmpty");


    }
}
