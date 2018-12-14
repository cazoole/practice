package com.example.demo.domain;

import com.example.demo.validate.SubLimit;
import com.example.demo.validate.WorkDateConstraint;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WorkDateBO {

    @WorkDateConstraint
    @SubLimit(len = 1)
    @NotNull
    private String day;
}
