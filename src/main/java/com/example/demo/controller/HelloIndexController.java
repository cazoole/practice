package com.example.demo.controller;

import com.example.demo.aspect.demo.MyAspect;
import io.swagger.models.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloIndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object helloPage() {
        return "search";
    }



    @RequestMapping(value = "/result")
    public String hello(@RequestParam(defaultValue = "springboot") String searchStr, Model model) {
        return "search";
    }

    @RequestMapping(value = "/postResult", method = RequestMethod.POST)
    public String result(@RequestParam("search") String searchStr, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if(searchStr.toLowerCase().equals("struts2")) {
            redirectAttributes.addFlashAttribute("error", "Try using spring instead!");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("search", searchStr);
        return "redirect:result";
    }

    @RequestMapping(value = "/sayHai")
    @ResponseBody
    @MyAspect
    public String sayHai() {
        System.out.println("controller sayHai() to call");
        return "hai";
    }
}
