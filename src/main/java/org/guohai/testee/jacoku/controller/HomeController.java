package org.guohai.testee.jacoku.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(String param){
        if(param.isEmpty()){
            return "Welcome back home, all.";

        }else{
            return String.format("Welcome back home, %s .", param);
        }
    }
}
