package br.com.pdi.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectedByConstructorService {

    @Autowired
    private HelloWorldService helloWorldService;

    public InjectedByConstructorService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public void getMessage(){
        helloWorldService.sayHello();
    }
}
