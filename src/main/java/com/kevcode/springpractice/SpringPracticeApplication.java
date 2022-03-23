package com.kevcode.springpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.kevcode.springpractice","com.kevcode.springpractice.application","com.kevcode.springpractice.api", "com.kevcode.springpractice.domain"})
@EnableJpaRepositories("com.kevcode.springpractice.infrastructure.repository")
@EntityScan("com.kevcode.springpractice.domain")
public class SpringPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPracticeApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);

				for(String beanName: beanNames){
					System.out.println("BEAN:" + beanName);
				}
			};
		}
}

