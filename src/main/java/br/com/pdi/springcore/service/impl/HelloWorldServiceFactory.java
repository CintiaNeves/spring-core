package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;

public class HelloWorldServiceFactory {

    public HelloWorldService createHelloWorldService(String language){
        HelloWorldService service = null;

        switch (language){
            case "en":
                service = new HelloWorldServiceEnglishImpl();
                break;
            case "es":
                service = new HelloWorldServiceEspanishImpl();
                break;
            case "br":
                service = new HelloWorldServicePortugueseImpl();
                break;
            default: new HelloWorldServiceEnglishImpl();
        }
        return service;
    }
}
