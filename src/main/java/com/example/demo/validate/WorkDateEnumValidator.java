package com.example.demo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkDateEnumValidator implements ConstraintValidator<WorkDateConstraint, String> {
    @Override
    public void initialize(WorkDateConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !(WorkDateEnum.valueByCode(s) == null);
    }
}
