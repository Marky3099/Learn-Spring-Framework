package com.practice.practice_spring_boot.examples.c1;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService {
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}