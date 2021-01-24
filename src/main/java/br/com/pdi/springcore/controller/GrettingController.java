package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GrettingController {

    private HelloWorldService helloWorldService;

    private HelloWorldService helloWorldServiceSpanish;

    private HelloWorldService helloWorldServicePortuguese;

    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Autowired
    @Qualifier("spanish")
    public void setHelloWorldServiceSpanish(HelloWorldService helloWorldServiceSpanish) {
        this.helloWorldServiceSpanish = helloWorldServiceSpanish;
    }

    @Autowired
    @Qualifier("portuguese")
    public void setHelloWorldServicePortuguese(HelloWorldService helloWorldServicePortuguese) {
        this.helloWorldServicePortuguese = helloWorldServicePortuguese;
    }

    public String sayHello(){
        String greeting = helloWorldService.getGreeting();

        System.out.println(greeting);
        System.out.println(helloWorldServiceSpanish.getGreeting());
        System.out.println(helloWorldServicePortuguese.getGreeting());

        return greeting;
    }
}
