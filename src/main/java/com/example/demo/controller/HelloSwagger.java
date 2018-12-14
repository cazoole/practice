package com.example.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: wei.liuw
 * @Date: 2018/8/10 12:30
 * @version: $Id: practice, v 0.1 2018年08月2018/8/10日 wei.liuw EXP $
 */
@RestController
@Slf4j
public class HelloSwagger {

    @ApiOperation(value = "欢迎接口", notes = "向登陆者问好")
    @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "hai/{name}", method = RequestMethod.GET)
    public Object sayHello(@PathVariable(value = "id") String name) {
        log.info("开始测试：");
        return "hello,".concat(name).concat("！");
    }


    @ApiOperation(value = "获取当前时间", notes = "获取系统当前时间")
    @RequestMapping(value = "/getTime", method = RequestMethod.GET)
    public Object getTime() {
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date());
    }

}
