package br.com.pdi.springcore.springboot;

import br.com.pdi.springcore.controller.GrettingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan("br.com.pdi.springcore")
public class SpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);
		System.out.println("INICIO");
		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("FIM");
		GrettingController grettingController = (GrettingController) ctx.getBean("grettingController");
		grettingController.sayHello();
	}
}
