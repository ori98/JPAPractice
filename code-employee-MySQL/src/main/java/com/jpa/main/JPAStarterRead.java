package com.jpa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarterRead {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
		props.load(new FileInputStream("/Users/ori/eclipse-workspace/eclipse-ee-workspace/eclipse-accenture-training/code-employee-MySQL/src/main/java/com/jpa/main/credentials.properties"));		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp", props);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		EmployeeAccess empAccess = entityManager.find(EmployeeAccess.class, 2);
		
		System.out.println(empAccess);
		
		// Removing LEFT OUTER JOIN query
		
		// Employee emp = entityManager.find(Employee.class, 1);
		
		// System.out.println(emp); // but this also results in the access card toString being printed out
		
//		System.out.println("*******Employee Fetched********");
//		System.out.println(emp.getEmpName());
//		
//		System.out.println("=======Employee Access======");
//		System.out.println(emp.getCard());
	}
}
