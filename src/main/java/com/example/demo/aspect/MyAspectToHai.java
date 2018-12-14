package com.example.demo.aspect;

import com.example.demo.aspect.demo.MyAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 后继切面注解
 */
@Component
@Aspect
public class MyAspectToHai {

    @Pointcut("(execution(public * com.example.demo..*(..) )) && @annotation(com.example.demo.aspect.demo.MyAspect)")
    public void toHaiAfter() {
    }

    @AfterReturning(value = "toHaiAfter() && @annotation(myAspect)", argNames = "joinPoint,myAspect,result", returning = "result")
    public void sayHai(JoinPoint joinPoint, MyAspect myAspect, Object result) {
        System.out.println(joinPoint.getArgs() + joinPoint.getKind() + joinPoint.getSourceLocation() + joinPoint.getSignature());
        System.out.println("After method to say hai!");
    }
}
