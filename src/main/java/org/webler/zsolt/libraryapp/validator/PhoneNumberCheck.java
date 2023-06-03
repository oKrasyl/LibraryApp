package org.webler.zsolt.libraryapp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberCheck implements ConstraintValidator<PhoneNumber,String> {
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[+][0-9]{2}[ ]?[0-9]{2}[ ]?[0-9]{3}[ ]?[0-9]{4}$");
    }
}
