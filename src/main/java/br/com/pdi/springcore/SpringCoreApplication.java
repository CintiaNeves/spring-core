package br.com.pdi.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.sayHello();
	}

}
