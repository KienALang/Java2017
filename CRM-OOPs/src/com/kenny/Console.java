package com.kenny;

import java.util.Scanner;

public class Console {

	private static Scanner sc;

	public static void print(String str) {
		System.out.print(str);
	}

	public static void println(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		sc = new Scanner(System.in);
		ui.showMenu();

		while (true) {

			String key;
			print("Please chose function: ");
			key = sc.nextLine();

			switch (key) {
			case "1":
				ui.generateCustomerList();
				break;
			case "2":
				ui.viewCustomerList();
				break;
			case "3":
				ui.viewCustomerDetail();
				break;
			case "4":
				ui.addCustomer();
				break;
			case "5":
				ui.deleteCustomer();
				break;
			case "6":
				ui.UpdateCustomer();
				break;

			case "7":
				ui.deleteContact();
				break;
			case "8":
				ui.refresh();
				ui.showMenu();
				break;
			default:
				return;
			}
		}
	}

}
