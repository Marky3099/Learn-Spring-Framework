package com.practice.practice_spring_boot.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All Dependency");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Clean Up");
	}
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some dependency");
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
