package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;

public class HelloWorldServicePortugueseImpl implements HelloWorldService {

    @Override
    public String getGreeting() {
        return "Olá Mundo!!!";
    }
}
