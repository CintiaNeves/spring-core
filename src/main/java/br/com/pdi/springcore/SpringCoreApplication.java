package br.com.pdi.springcore;

import br.com.pdi.springcore.controller.GrettingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);
		GrettingController grettingController = (GrettingController) ctx.getBean("grettingController");
		grettingController.sayHello();
	}
}
