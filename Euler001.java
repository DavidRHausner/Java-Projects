// Problem 1
//If we list all the natural numbers below 10 that are multiples of 
//3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.

// Written by David Hausner 8/20/13
public class Euler001 {
	
	public static void main(String[] args)
	{
		int sum = 0, divisible_by_three = 0, divisible_by_five = 0,
			divisible_by_fifteen = 0;
		
		// adds the sum of all numbers 1-999 that are divisible by 3
		for(int i = 1; i <= 333; i++)
		{
			divisible_by_three += i;
		}
		// adds the sum of all numbers 1-999 that are divisible by 5
		for(int j = 1; j <=199; j++)
		{
			divisible_by_five += j;
		}
		// subtracts the sum of all numbers 1-999 that are divisible
		// by 15, since they've been added to the total twice
		for(int k = 1; k <= 66; k++)
		{
			divisible_by_fifteen -= k;
		}
		// multiply each sub-total by the number we factored out and add them together
		sum = 3 * divisible_by_three + 5 * divisible_by_five - 15 * divisible_by_fifteen;
		System.out.print(sum);
	}
}
