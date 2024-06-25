package com.practice.practice_spring_boot.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Params"));
			System.out.println(context.getBean("address2"));
			System.out.println(context.getBean(Address.class));
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
