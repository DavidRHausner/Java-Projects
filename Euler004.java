//Problem 4
//A palindromic number reads the same both ways. 
//The largest palindrome made from the product of two 
//2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of 
//two 3-digit numbers.

public class Euler004 {
	public static void main(String[] args) {
		int top = 0;
		int product = 0;
		//cycle through all combinations of 2 three digit numbers
		for(int i = 100; i<=999; i++)
		{
			for(int j = 100; j<=999; j++)
			{
				//test whether each product is a palidrome
				product = i*j;
				if(IsPalindrome(product))
				//if it is, keep the higher value of top and product
					top = Math.max(top, product);
			}
		}
		System.out.println(top);
	}
	public static boolean IsPalindrome(int number) {
		//treating the number as a string makes this test easier
		String numero = String.valueOf(number);
		//search through number from each end, comparing the first and last
		//characters with each other until reaching the middle
		for(int i=0; i<numero.length()/2; i++)
		{
			if(numero.charAt(i)!=numero.charAt(numero.length()-i-1))
			{
				return false;
			}
		}
		return true;
	}
}