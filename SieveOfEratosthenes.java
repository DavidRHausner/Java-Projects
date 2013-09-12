//Written by David Hausner, 9/12/13

import java.util.Scanner;

public class SieveOfEratosthenes {
	//array to store whether numbers are prime or not
	private boolean[] numbers_for_sieve;
	public static void main(String[] args) {
		new SieveOfEratosthenes();
	}
	public SieveOfEratosthenes() {
		//introduces program and prompts user for integer number less than one billion
		Scanner userScan = new Scanner(System.in);
		System.out.println("Welcome to the Sieve of Eratosthenes Prime Finder!");
		System.out.println("I'll find the primes below your number (less than one billion).");
		System.out.print("Enter the upper limit for primes you'd like to find: ");
		String input = userScan.next();
		userScan.close();
		
		int upperlimit;
		//attempts to parse user's values to an integer variable
		try{
			upperlimit = Integer.parseInt(input);
		}
		catch(NumberFormatException nfe){
			//notifies the user that they input their data incorrectly
			//and replaces their data with a valid number; in this case
			//one that will cause the rest of the program to execute
			//without crashing
			upperlimit = 0;
		}
		//declares the size of the array
		numbers_for_sieve = new boolean[upperlimit+1];

		//declares each element of the array to be true (prime)
		InitializeSieve(upperlimit);
		//switches multiples of all primes to false
		ProcessSieve(upperlimit);
		//outputs the primes left
		DisplaySieve(upperlimit);
	}
	public void InitializeSieve(int ulimit) {
		//stops the program if data is bad or no primes 
		//are below the user's chosen upper limit
		if(ulimit<2)
		{
			return;
		}
		//declares 0 and 1 not prime
		//(0 and 1 were included to keep from having to make each entry
		//multiple i+2, and to make programming the ProcessSieve function easier
		numbers_for_sieve[0]=false;
		numbers_for_sieve[1]=false;
		//declares all other numbers prime for the moment
		for(int i=2; i<=ulimit; i++)
		{
			numbers_for_sieve[i] = true;
		}
		return;
	}
	public void ProcessSieve(int ulimit) {
		//stops the program if data is bad or no primes 
		//are below the user's chosen upper limit
		if(ulimit<2)
		{
			return;
		}
		//if the number is prime, turn all of its multiples false
		//up to the user's chosen upper limit
		for(int j=2; j<=ulimit; j++)
		{
			if(numbers_for_sieve[j]==true)
			{
				for(int k=2; (j*k)<=(ulimit); k++)
				{
					numbers_for_sieve[j*k]=false;
				}
			}
		}
		return;
	}
	public void DisplaySieve(int ulimit){
		//stops the program if data is bad or no primes 
		//are below the user's chosen upper limit
		if(ulimit<2)
		{
			return;
		}
		//prints out the primes discovered at or below the user's
		//chosen upper limit
		for(int n=2; n<=ulimit; n++)
		{
			if(numbers_for_sieve[n]==true)
				{System.out.println(n);}
		}
		System.out.println("Thank you for using the program!");
	}
}
