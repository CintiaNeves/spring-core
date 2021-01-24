package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;

public class HelloWorldServiceEnglishImpl implements HelloWorldService {

    @Override
    public String getGreeting() {
        return "Hello World!!!";
    }
}
