package com.kevcode.springpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages =
		{"com.kevcode.springpractice.domain","com.kevcode.springpractice.infrastructure", "com.kevcode.springpractice.api", "com.kevcode.springpractice.application"})
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

