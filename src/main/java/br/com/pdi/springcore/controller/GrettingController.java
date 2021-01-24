package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.service.HelloWorldService;

//@Controller
public class GrettingController {

    private HelloWorldService helloWorldService;

    private HelloWorldService helloWorldServiceSpanish;

    private HelloWorldService helloWorldServicePortuguese;

    private HelloWorldService helloWorldServiceFrench;

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public void setHelloWorldServiceSpanish(HelloWorldService helloWorldServiceSpanish) {
        this.helloWorldServiceSpanish = helloWorldServiceSpanish;
    }

    public void setHelloWorldServicePortuguese(HelloWorldService helloWorldServicePortuguese) {
        this.helloWorldServicePortuguese = helloWorldServicePortuguese;
    }

    public void setHelloWorldServiceFrench(HelloWorldService helloWorldServiceFrench) {
        this.helloWorldServiceFrench = helloWorldServiceFrench;
    }

    public String sayHello(){
        String greeting = helloWorldService.getGreeting();

        System.out.println(greeting);
        System.out.println(helloWorldServiceSpanish.getGreeting());
        System.out.println(helloWorldServicePortuguese.getGreeting());
        System.out.println(helloWorldServiceFrench.getGreeting());
        return greeting;
    }
}
