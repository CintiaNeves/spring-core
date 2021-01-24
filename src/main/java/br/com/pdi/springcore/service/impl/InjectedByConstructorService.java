package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectedByConstructorService {

    @Autowired
    private HelloWorldService helloWorldService;

    public InjectedByConstructorService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

}
