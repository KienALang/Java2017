package com.kenny;

public class UserInterface {
	private Controller controller;

	public UserInterface() {
		controller = new Controller();
	}
	
	public void showMenu() {
		// TODO Auto-generated method stub
		Console.println("_ CUSTOMER MANAGEMENT _");

		Console.println("1. Generate a list of customer");
		Console.println("2. View customer list");
		Console.println("3. View customer detail");
		Console.println("4. Add a customer");
		Console.println("5. Delete a customer");
		Console.println("6. Update a customer");
		Console.println("7. Delete a contact");
		Console.println("8. Clear screen");
	}

	public void generateCustomerList() {
		// TODO Auto-generated method stub
		Console.println("_ GENERATE A CUSTOMER LIST _");
				
		controller.generateCustomerList();

		Console.println("Generated a customer list");
		Console.println("There are " + controller.getCustomerList().size() + " customers");
	}

	public void viewCustomerList() {
		// TODO Auto-generated method stub
		Console.println("_ VIEW CUSTOMER LIST _");
		TableView tbView = new TableView();

		String[] header = { "CUSTOMER ID", "FULLNAME", "GENDER", "DOB" };
		tbView.addHeader(header);

		String[] row = new String[4];

		for (Customer customer : controller.getCustomerList()) {
			row[0] = String.valueOf(customer.getId());
			row[1] = customer.getName();
			row[2] = customer.getGender();
			row[3] = customer.getDayofBirth().toString();

			tbView.addRow(row);
		}

		tbView.viewTable();
	}

	public void viewCustomerDetail() {
		// TODO Auto-generated method stub
		Console.println("_ VIEW CUSTOMER DETAIL _");
	}

	public void addCustomer() {
		// TODO Auto-generated method stub
		Console.println("_ ADD A CUSTOMER _");
	}

	public void deleteCustomer() {
		// TODO Auto-generated method stub
		Console.println("_ DELETE A CUSTOMER _");
	}

	public void UpdateCustomer() {
		// TODO Auto-generated method stub
		Console.println("_ UPDATE A CUSTOMER _");
	}

	public void deleteContact() {
		// TODO Auto-generated method stub
		Console.println("_ DELETE A CONTACT _");
	}

	public void refresh() {
		// TODO Auto-generated method stub
	}

}
