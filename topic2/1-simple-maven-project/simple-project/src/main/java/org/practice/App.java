package org.practice;

import java.util.Scanner;

import data.DB;

public class App {
	public static void main(String[] args) {
		String name;
		Scanner scanner = new Scanner(System.in);
		DB db = new DB();
		int count = db.getCount();

		System.out.println("Count:" + count);
		System.out.println("Enter your name:");
		name = scanner.nextLine();

		scanner.close();

		System.out.println("\nHello " + name + "!");
		db.setCount(count + 1);
	}
}
