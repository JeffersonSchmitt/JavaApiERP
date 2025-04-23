package com.example.FirstApi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String helloWorld(String mensagem) {
        return "retorno da mensagem " + mensagem;
    }
}
