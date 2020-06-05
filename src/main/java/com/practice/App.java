package com.practice;
import java.util.List;

import com.practice.model.Record;
import com.practice.service.Operations;

public class App {
	// Yo boy
	public static void main(String[] args) {
		Operations operations = new Operations();
		//operations.insert(new Record("Abu"));
		//operations.update(2,"Mohsin khan agwan");
		List<Record> records = operations.list();
		print(records);
		//operations.delete(8);
	}

	private static void print(List<Record> records) {
		for (Record record : records) {
			System.out.print("Name: " + record.getName());
		}
	}
}
