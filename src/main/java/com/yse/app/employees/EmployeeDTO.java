package com.yse.app.employees;

import java.sql.Date;

public class EmployeeDTO {
	
	//멤버변수의 접근자는 private 으로 선언한다.
	//멤버변수의 데이터 타입과 변수명은 DB테이블과 동일하게 
	//database는 스네이크 케이스, java는 카멜 케이스로 작성한다.
	//접근지정자가 private인 멤버변수는 getter/setter 메서드를 통해 접근한다.
	//생성자는 여러개 있어도 상관없지만 기본생성자(매개변수가 비어있는)는 꼭 작성한다.
	
	private int employeeId;
	private String password;
	private String firstName;
	private String lastName;
	private String eamil;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct; //null이 들어갈 수 있기 때문에 Double로 선언한다. null을 허용하는 래퍼타입
	private int managerId;
	private Integer dpartmentId; //null이 들어갈 수 있기 때문에 Integer로 선언한다. null을 허용하는 래퍼타입
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Integer getDpartmentId() {
		return dpartmentId;
	}
	public void setDpartmentId(Integer dpartmentId) {
		this.dpartmentId = dpartmentId;
	}
	
}
