package com.kenny;

import java.util.ArrayList;

public class TableView {
	private ArrayList<String> list;
	private int colums;

	public TableView() {
		list = new ArrayList<String>();
	}

	public int getColums() {
		return colums;
	}

	public void setColums(int colums) {
		this.colums = colums;
	}

	public void addHeader(String[] header) {
		list.clear();
		
		this.setColums(header.length);

		for (String string : header) {
			list.add(string);
		}
	}

	public void addRow(String[] row) {
		for (String string : row) {
			list.add(string);
		}
	}

	public void viewTable() {
		int longestLength = this.getLongestLength();		
		
		for (int i = 0; i < list.size(); i++) {
			if (i % colums == 0) {
				if (i != 0)
					Console.print("|");
			}
			
			Console.print(list.get(i) + "\t");
		}
				
	}
	
	private int getLongestLength() {
		// TODO Auto-generated method stub
		int length = 0;
		for (String string : list) {
			length = string.length() > length ? string.length() : length;
		}
		return length;
	}

	private void print(String str, int times)
	{
		for (int i = 0; i < times; i++) {
			System.out.print(str);
			
		}
	}

}
