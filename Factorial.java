//Written by David Hausner, 9/15/13

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		new Factorial();
	}
	public Factorial() {
		//introduces program and prompts user for input
		Scanner userScan = new Scanner(System.in);
		System.out.println("Welcome to the Factorial Program!");
		System.out.print("Enter a integer greater than or equal to 1: ");
		String input = userScan.next();
		userScan.close();
		
		//attempts to parse user input as a long
		long user_number;
		try{
			user_number = Long.parseLong(input);
			}
		catch(NumberFormatException nfe){
			//notifies the user that they input their data incorrectly
			//and replaces their data with a valid number
			System.out.println("You entered the number incorrectly.");
			user_number = 1;
		}
		//outputs the answer found by each method of calculating the factorial
		System.out.format("The value of %d factorial (calculated with loops) is %d.%n", 
				user_number, FactorialWithLoops(user_number));
		System.out.format("The value of %d factorial (calculated with recursion) is %d.",
				user_number, FactorialWithRecursion(user_number));
	}
	//calculates the factorial using a loop
	public long FactorialWithLoops(long number) {
		long total = 1;
		for(long i = 1; i <= number; i++) {
			total *= i;
		}
		return total;		
	}
	//calculates the factorial using recursion
	public long FactorialWithRecursion(long number) {
		long total;
		if(number==1) {
			return 1;
		}
		total = number * FactorialWithRecursion(number-1);
		return total;
	}
}
