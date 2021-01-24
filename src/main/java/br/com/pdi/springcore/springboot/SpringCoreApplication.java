package br.com.pdi.springcore.springboot;

import br.com.pdi.springcore.controller.GrettingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml")
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
