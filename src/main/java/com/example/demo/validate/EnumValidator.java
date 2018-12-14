package com.example.demo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumValidator implements ConstraintValidator<EnumConstraint, String> {

    private static final String VALUE_BY_CODE = "valueByCode";
    Class<?>[] classes;

    @Override
    public void initialize(EnumConstraint constraintAnnotation) {
        classes = constraintAnnotation.target();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(classes.length > 0) {
            try {
                for(Class clz : classes) {
                    if(clz.isEnum()) {
                        Method method = clz.getMethod(VALUE_BY_CODE, String.class);
                        Object object = method.invoke(clz.getEnumConstants()[0], null);
                        if(null != object) {
                            return true;
                        }
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
