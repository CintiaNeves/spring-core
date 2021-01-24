package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;

public class HelloWorldServiceFrenchImpl implements HelloWorldService {

    @Override
    public String getGreeting() {
        return "Bonjour le monde!!!";
    }
}
