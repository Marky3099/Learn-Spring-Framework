package com.springjpa.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springjpa.learn_jpa_and_hibernate.course.Course;
import com.springjpa.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.springjpa.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.springjpa.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS111 Now","in28minutes"));
		repository.save(new Course(2,"Learn AWS222 Now","in28minutes"));
		repository.save(new Course(3,"Learn AWS333 Now","in28minutes"));
		repository.deleteById(2l);
		System.out.println(repository.findById(1l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println("Author:" + repository.findByAuthor("in28minutes"));
		System.out.println("Course: " + repository.findByName("Learn AWS333 Now"));
	}

}
