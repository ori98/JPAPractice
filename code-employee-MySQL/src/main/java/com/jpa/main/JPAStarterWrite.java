package com.jpa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAStarterWrite {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
		props.load(new FileInputStream("/Users/ori/eclipse-workspace/eclipse-ee-workspace/eclipse-accenture-training/code-employee-MySQL/src/main/java/com/jpa/main/credentials.properties"));
		
		Employee emp1 = new Employee();
		emp1.setDate(new Date());
		emp1.setEmployeeType(EmployeeType.FULL_TIME);
		emp1.setEmpName("Ori");
		
		Employee emp2 = new Employee();
		emp2.setDate(new Date());
		emp2.setEmpName("JLB");
		emp2.setEmployeeType(EmployeeType.CONTRACTOR);
		
		Employee emp3 = new Employee();
		emp3.setDate(new Date());
		emp3.setEmpName("Sushi");
		emp3.setEmployeeType(EmployeeType.PART_TIME);
		
		// Mapping One to One relationship with accessCard
		
		EmployeeAccess accessCard1 = new EmployeeAccess();
		accessCard1.setIssueDate(new Date());
		accessCard1.setActive(false);
		accessCard1.setFirmwareVersion("1.0.0");
		emp1.setCard(accessCard1);							// mapping relationship for emp1
		accessCard1.setOwner(emp1);							// setting owner for accessCard1
		
		EmployeeAccess accessCard2 = new EmployeeAccess();
		accessCard2.setIssueDate(new Date());
		accessCard2.setActive(true);
		accessCard2.setFirmwareVersion("1.2.0");
		emp2.setCard(accessCard2);
		accessCard2.setOwner(emp2);
		
		EmployeeAccess accessCard3 = new EmployeeAccess();
		accessCard3.setIssueDate(new Date());
		accessCard3.setActive(true);
		accessCard3.setFirmwareVersion("1.2.1");
		emp3.setCard(accessCard3);
		accessCard3.setOwner(emp3);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp", props);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		
		entityManager.persist(accessCard1);
		entityManager.persist(accessCard2);
		
		transaction.commit();
		
		// DELETE operation
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		Employee emp2 = entityManager.find(Employee.class, 2);
//		
//		EntityTransaction transaction = entityManager.getTransaction();
//		
//		transaction.begin();
//		
//		entityManager.remove(emp2);
//		
//		transaction.commit();
		
		// UPDATE operation
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		Employee emp1 = entityManager.find(Employee.class, 1);
//		
//		emp1.setEmployeeType(EmployeeType.CONTRACTOR);
//		emp1.setEmpName("Oriii");
		
//		EntityTransaction transaction = entityManager.getTransaction();
//		
//		transaction.begin();
//		entityManager.persist(emp1);
//		transaction.commit();
		
		// READ operation
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		Employee emp1 = entityManager.find(Employee.class, 1);
//		// translation: SELECT * FROM EMPLOYEE_DATA WHERE ID = 1;
//		
//		Employee emp2 = entityManager.find(Employee.class, 2);
//		Employee emp3 = entityManager.find(Employee.class, 3);
//		
//		System.out.println(emp1);
//		System.out.println(emp2);
//		System.out.println(emp3);
		
		// creation and insertion
		
//		Employee employee = new Employee();		
//		employee.setEmpName("ori");
//		employee.setDate(new Date());
//		employee.setEmployeeType(EmployeeType.FULL_TIME);
//		
//		Employee employee1 = new Employee();
//		employee1.setEmpName("sushi");
//		employee1.setDate(new Date());
//		employee1.setEmployeeType(EmployeeType.PART_TIME);
//		
//		Employee employee2 = new Employee();
//		employee2.setEmpName("JLB");
//		employee2.setDate(new Date());
//		employee2.setEmployeeType(EmployeeType.CONTRACTOR);
//		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		
//		entityTransaction.begin();
//		entityManager.persist(employee);
//		entityManager.persist(employee1);
//		entityManager.persist(employee2);
//		entityTransaction.commit();
		
		// entityManager.close();
		// entityManagerFactory.close();
		
	}
}
