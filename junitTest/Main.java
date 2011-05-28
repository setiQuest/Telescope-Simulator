package seti.junitTest;

import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number1;
		int number2;
		int sum = 0;
		
	Scanner scanner = new Scanner(System.in);	
	System.out.println("Enter two numbers to be added");
	
	number1 = scanner.nextInt();
	number2 = scanner.nextInt();
	
	Addition addition = new Addition();
	sum = addition.add(number1, number2);
	
	//This is not needed when using Junit testing
	System.out.println("Sum: "+sum);
	}

	

}
