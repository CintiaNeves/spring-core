package br.com.pdi.springcore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ImportResource("classpath:/spring/spring-config.xml")
public class SpringCoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
