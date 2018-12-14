package com.example.demo;

import com.example.demo.validate.WorkDateEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clz = WorkDateEnum.class;

        Method method = clz.getMethod("getCode");
        Method m = clz.getMethod("valueByCode", String.class);
        Object[] objects = clz.getEnumConstants();

        Object obj = m.invoke(objects[0], "1");
        System.out.println(obj);

        System.out.println(Enum.valueOf(WorkDateEnum.class,"SUNDAY"));
    }
}
