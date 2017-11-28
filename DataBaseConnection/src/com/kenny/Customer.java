package com.kenny;

public class Customer {

	private int id;
	private String fullname;
	private String address;
	private double salary;
	
	public Customer(int id, String fullname, String address, double salary) {
		
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.salary = salary;
	}
	public Customer() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
	
}
