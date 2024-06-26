package com.practice.practice_spring_boot.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoDbDataService implements DataService{
	
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}
}
