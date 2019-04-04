package com.jackie.testOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/8/31
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!!";
    }
}
