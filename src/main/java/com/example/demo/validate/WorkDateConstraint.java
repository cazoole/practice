package com.example.demo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WorkDateEnumValidator.class)
@Documented
public @interface WorkDateConstraint {
    String message() default "不是一周日期类型！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
