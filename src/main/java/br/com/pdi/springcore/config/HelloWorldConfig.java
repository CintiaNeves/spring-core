package br.com.pdi.springcore.config;

import br.com.pdi.springcore.service.HelloWorldService;
import br.com.pdi.springcore.service.impl.HelloWorldServiceBrazilianImpl;
import br.com.pdi.springcore.service.impl.HelloWorldServiceEnglishImpl;
import br.com.pdi.springcore.service.impl.HelloWorldServiceEspanishImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloWorldConfig {

    @Bean
    @Profile("english")
    public HelloWorldService helloWorldServiceEnglish(){
        return new HelloWorldServiceEnglishImpl();
    }

    @Bean
    @Profile("espanish")
    public HelloWorldService helloWorldServiceEspanishImpl(){
        return new HelloWorldServiceEspanishImpl();
    }

    @Bean
    @Profile("brazilian")
    public HelloWorldService helloWorldServiceBrazilianImpl(){
        return new HelloWorldServiceBrazilianImpl();
    }
}
