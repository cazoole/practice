package com.example.demo.hessian;

import com.example.demo.batch.model.Person;
import org.springframework.stereotype.Service;

@Service("helloHessian")
public class HelloHessianImpl implements HelloHessian {
    @Override
    public String sayHello() {
        return "Hello, this is my first hessian service!";
    }

    @Override
    public Person getPerson() {
        Person person = new Person();
        person.setName("lw");
        person.setHobby("ball");
        person.setAge(11);
        return person;
    }
}
