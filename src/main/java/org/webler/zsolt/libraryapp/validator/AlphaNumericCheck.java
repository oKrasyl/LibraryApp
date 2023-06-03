package org.webler.zsolt.libraryapp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphaNumericCheck implements ConstraintValidator<AlphaNumeric,String> {
    @Override
    public void initialize(AlphaNumeric constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[a-zA-Z0-9]*$");
    }
}
