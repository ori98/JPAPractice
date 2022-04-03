package com.jpa.main;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity	
@Table(name="employee_table")
public class Employee {
	private int empId;
	private String empName;
	
	// storing dates
	@Temporal(TemporalType.DATE)
	private Date date;
	
	// storing ENUM
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	// transient (not to be persisted)
//	@Transient
//	private String debugCode;
	
	// adding a card column to employee table
	private EmployeeAccess card;
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY) //fetchType lazy doesn't print toString of foreign key
	public EmployeeAccess getCard() {	
		return card;
	}

	public void setCard(EmployeeAccess card) {
		this.card = card;
	}

	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // for auto-increment
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(name="emp_name")
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name = "DoB")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="Employee_Type")
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", date=" + date + ", employeeType=" + employeeType
				+ ", card=" + card + "]";
	}
	
}
