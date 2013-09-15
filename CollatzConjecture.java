//Written by David Hausner, 9/15/13

import java.util.Scanner;

public class CollatzConjecture {
	public static void main(String[] args) {
		new CollatzConjecture();
	}
	public CollatzConjecture() {
		//introduces program and prompts user for input
		Scanner userScan = new Scanner(System.in);
		System.out.println("Welcome to the Collatz Conjecture Program!");
		System.out.print("Enter a number and we'll see how many cycles it takes!");
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
		//outputs the answer
		System.out.format("It takes %d cycles to arrive at 1.", NumberOfCycles(user_number));
	}
	//outputs true if the number is even, false if it is odd
	public boolean IsEven(long number){
		if(number%2==0){
			return true;
		}
		else return false;
	}
	//does the calculation of the Collatz Conjecture
	//outputs the number of cycles needed to arrive at 1
	public int NumberOfCycles(long number){
		int counter = 0;
		while(number!=1){
			if(IsEven(number)){
				number = number / 2;
			}
			else {
				number = (number * 3) + 1;
			}
			counter++;
		}
		return counter;
	}
}
