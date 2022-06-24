package com.cj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.cj")
@EntityScan(basePackages = {"com.cj"})  // scan JPA entities
@EnableJpaRepositories("com.cj")
public class UserUtilityApplicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserUtilityApplicationDemoApplication.class, args);
	}

}
