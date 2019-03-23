package it.garbi.consuntivo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.garbi.consuntivo.entities.User;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "the password must be at least 8 chars long!");
        }
    }

}
