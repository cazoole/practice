package com.example.demo.aspect;

import com.example.demo.aspect.demo.MyAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 前驱切面注解
 */
@Component
@Aspect
public class MyAspectToHello {

    @Pointcut("(execution(public * com.example.demo..*(..))) && @annotation(com.example.demo.aspect.demo.MyAspect)")
    public void toHelloBefore() {
    }

    @Before(value = "toHelloBefore() && @annotation(myAspect)", argNames = "joinPoint,myAspect")
    public void doBefore(JoinPoint joinPoint, MyAspect myAspect) {
        System.out.println("Before method to say hello");
    }
}
