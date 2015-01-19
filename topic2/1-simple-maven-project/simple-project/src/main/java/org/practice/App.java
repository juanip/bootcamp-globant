package org.practice;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String name;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your name:");
		name = scanner.nextLine();

		scanner.close();

		System.out.println("\nHello " + name + "!");
	}
}
