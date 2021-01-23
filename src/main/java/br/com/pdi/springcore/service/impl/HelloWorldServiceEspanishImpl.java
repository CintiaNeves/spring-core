package br.com.pdi.springcore.service.impl;

import br.com.pdi.springcore.service.HelloWorldService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("espanish")
public class HelloWorldServiceEspanishImpl implements HelloWorldService {

    @Override
    public String getGreeting() {
        return "Hola Mundo!!!";
    }
}
