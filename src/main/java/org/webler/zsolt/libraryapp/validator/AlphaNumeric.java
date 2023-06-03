package org.webler.zsolt.libraryapp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Documented
@Constraint(validatedBy = {AlphaNumericCheck.class })
public @interface AlphaNumeric {

    String message() default "String is not alphanumeric";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
