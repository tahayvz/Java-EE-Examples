package com.calisma.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value= {"userRest"}) //run class as spring in this package if there is another package write as {"userRest"},{"userRest2"}
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); /*this line indicates that it is spring boot */
	}
}
