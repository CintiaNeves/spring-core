package br.com.pdi.springcore.config;

import br.com.pdi.springcore.service.HelloWorldService;
import br.com.pdi.springcore.service.impl.HelloWorldServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorldServiceFactory helloWorldServiceFactory(){
        return new HelloWorldServiceFactory();
    }

    @Bean
    @Profile({"english", "default"})
    public HelloWorldService helloWorldServiceEnglish(HelloWorldServiceFactory factory){
        return factory.createHelloWorldService("en");
    }

    @Bean
    @Profile("espanish")
    public HelloWorldService helloWorldServiceEspanishImpl(HelloWorldServiceFactory factory){
        return factory.createHelloWorldService("es");
    }

    @Bean
    @Profile("brazilian")
    public HelloWorldService helloWorldServiceBrazilianImpl(HelloWorldServiceFactory factory){
        return factory.createHelloWorldService("br");
    }
}
