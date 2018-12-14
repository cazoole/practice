package com.example.demo.validate.util;

import lombok.Data;

import java.util.Map;

@Data
public class ValidatorResult {

    private boolean hasError;

    private Map<String, String> errorMsg;
}
