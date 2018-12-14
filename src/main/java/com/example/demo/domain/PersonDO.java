package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonDO {

    @Getter
    private String name;
    private String gender;
    private int age;
    private String hobby;
}
