package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @RequestMapping("/register")
    public Object getInfo() {
        return "index";
    }

    @RequestMapping("/commit")
    public Object  commit(HttpServletRequest request, ModelAndView modelAndView) {
        for(String key : request.getParameterMap().keySet()) {
            System.out.println("key = " + request.getParameter(key));
        }
        Map result = new HashMap();
        result.put("name", "NoN");
        result.put("age", 20);
        result.put("gender", "F");

        modelAndView.setViewName("show");
        modelAndView.addObject("data", result);

        return modelAndView;
    }
}
