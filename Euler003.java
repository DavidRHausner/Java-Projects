//Written by David Hausner, 9/10/2013

//Problem 3
//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

public class Euler003 {
	public static void main(String[] args) {
		long number = 600851475143L;
		long max = 0L;
		//the number is odd, so the program needs to test
		//each odd number from 3 to the square root of
		//our long number and determine whether they are
		//factors
		for(long i = 3L; i<775147L; i+=2)
		{
			if (number % i == 0)
			{
				//only test factors for primeness to save computing time
				if(IsPrime(i))
				{
					//since i is only increasing, there's no need to test
					//if i>max; it will always be true
					max = i;
				}
			}
		}
		System.out.println(max);

	}
	//tests numbers for primeness; assumes numbers are positive long integers
	public static boolean IsPrime(long num) {
		if(num%2==0)
			return false;
		for(long j=3L; j<=(Math.sqrt((double)num)); j+=2)
		{
			if(num%j==0)
			{
				return false;
			}
		}
		return true;
	};
}
