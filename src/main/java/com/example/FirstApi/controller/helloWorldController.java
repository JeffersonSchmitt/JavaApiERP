package com.example.FirstApi.controller;

import com.example.FirstApi.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class helloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    public helloWorldController(HelloWorldService helloWorldService){
        this.helloWorldService=helloWorldService;
    }

    @GetMapping
    public String helloWorld(
            @RequestParam(defaultValue = "Null")
            String mensagem) {
        return helloWorldService.helloWorld(mensagem);
    }
}
