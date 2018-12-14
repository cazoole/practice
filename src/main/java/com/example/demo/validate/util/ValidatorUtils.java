package com.example.demo.validate.util;

import com.example.demo.validate.SubLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
@Slf4j
public class ValidatorUtils {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> ValidatorResult validatorEntity(T obj) {
        ValidatorResult result = new ValidatorResult();
        Set<ConstraintViolation<T>> violations = validator.validate(obj, Default.class);

        if(CollectionUtils.isEmpty(violations)) {
            result.setHasError(false);
            return result;
        }

        Map<String, String> errorMap = new HashMap<>();
        result.setHasError(true);
        result.setErrorMsg(errorMap);
        for(ConstraintViolation constraintViolation : violations) {
            String property = constraintViolation.getPropertyPath().toString();
            String errMsg;
            if(errorMap.get(property) != null) {
                errMsg = errorMap.get(property).concat(",").concat(constraintViolation.getMessage());
            } else {
                errMsg = constraintViolation.getMessage();
            }
            errorMap.put(property, errMsg);
        }
        result.setErrorMsg(errorMap);

        return result;
    }

    public static <T> void limitSubstr(T obj, boolean needLimit) {
        if(!needLimit) {
            return;
        }

        log.info("bo = " + obj);
        try {
            Class clazz = obj.getClass();
            for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
                Field[] fields = clazz.getDeclaredFields();

                for (Field field : fields) {
                    SubLimit subLimit = field.getAnnotation(SubLimit.class);
                    if(null != subLimit) {
                        int len = subLimit.len();
                        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
                        Method getMethod = propertyDescriptor.getReadMethod();
                        Object value = getMethod.invoke(obj);

                        log.info("len = " + len + "; value = " + value);
                        if(null == value || value.toString().length() <= len) {
                            continue;
                        }

                        Method setMethod = propertyDescriptor.getWriteMethod();
                        if(field.getType() == BigDecimal.class) {
                            BigDecimal bigVal = (BigDecimal) value;
                            String subVal = bigVal.toString();
                            if(subVal.length() > len) {
                                if(subVal.contains(".")) {
                                    int docIndex = subVal.indexOf(".");
                                    if(docIndex != len) {
                                        len = len + 1;
                                    }
                                    subVal = subVal.substring(0, len);
                                    setMethod.invoke(obj, new BigDecimal(subVal));
                                }
                            }
                        } else {
                            String subVal = (String) value;
                            setMethod.invoke(obj, subVal.substring(0, len));
                        }
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
