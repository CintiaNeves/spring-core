package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterBaseService {
    private HelloWorldService helloWorldService;

    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
