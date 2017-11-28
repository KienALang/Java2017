package com.kenny;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Controller {
	private ArrayList<Customer> customers;

	public Controller() {
		customers = new ArrayList<>();
	}

	public ArrayList<Customer> getCustomerList() {
		return customers;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customers = customerList;
	}

	public void generateCustomerList() {
		Random rand = new Random();
		int n = rand.nextInt(10);
		
		while (n > 0) {
			Customer customer = new Customer();

			customer.setName("Fullname_" + customer.getId());
			customer.setGender("Gender_" + customer.getId());
			customer.setDayofBirth(new Date());
			customer.generateContacts();

			customers.add(customer);
			--n;
		}
	}

}
