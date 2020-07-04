package com.rts.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/*import org.springframework.boot.web.support.SpringBootServletInitializer;*/
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.test"})
@EntityScan( basePackages = {"com.test"} )
@SpringBootApplication
public class ERPServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ERPServletInitializer.class);
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(ERPServletInitializer.class, args);
	}

}