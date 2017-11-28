package com.kenny;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Customer {

	private static int staticId;
	private int id;
	private ArrayList<Contact> contacts;
	private String name;
	private String gender;
	private Date dayofBirth;

	public Customer() {
		this.id = ++staticId;
		contacts = new ArrayList<>();
	}

	public Customer(ArrayList<Contact> contacts, String name, String gender, Date dayofBirth) {
		this.id = ++staticId;
		this.contacts = contacts;
		this.name = name;
		this.gender = gender;
		this.dayofBirth = dayofBirth;
	}

	public int getId() {
		return id;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDayofBirth() {
		return dayofBirth;
	}

	public void setDayofBirth(Date dayofBirth) {
		this.dayofBirth = dayofBirth;
	}

	public void generateContacts() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int n = rand.nextInt(5);		
		
		while (n > 0) {
			Contact contact = new Contact();

			contact.setName("Contact Name " + contact.getId());
			contact.setEmail("email_" + contact.getId());
			contact.setPhone("0123644 " + contact.getId());
			contact.setAddress("Address " + contact.getId());

			contacts.add(contact);

			--n;
		}
	}
}
