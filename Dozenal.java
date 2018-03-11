// Written by David Hausner
// 3/10/2018
// Compiles but hasn't been tested yet

import java.util.*;
public class Dozenal{
	public static void main(String[] arg) {
		new Dozenal();
	}
	public Dozenal() {
		// prompts user for decimal number
		Scanner userScan = new Scanner(System.in);
		System.out.println("Decimal to Dozenal");
		System.out.print("Enter base-10 integer number: ");
		String input = userScan.next();
		userScan.close();

		// error handling in case of input invalid data
		int dec;
		try{
			// tries to parse the string into a double
			dec = Integer.parseInt(input);
		}
		catch(NumberFormatException nfe) {
			// notifies the user that they input their data incorrectly
			// and replaces their data with a valid number
			System.out.println("You entered an invalid number.");
			dec = 0;
		}

		// converts the base-10 integer (decimal) to a base-12 integer (dozenal)
		String dozenal = "";
		int mod;
		while(dec > 0) {
			mod = dec % 12;
			dozenal = Translate(mod) + dozenal;
			dec -= mod;
			dec /= 12;
		}
		System.out.format("Its equivalent base-12 integer number is %s.", dozenal);
	}
	public char Translate(int num) {
		// accepts number between 0 and 11 and returns its dozenal equivalent
		switch(num) {
			case 0: return '0';
			case 1: return '1';
			case 2: return '2';
			case 3: return '3';
			case 4: return '4';
			case 5: return '5';
			case 6: return '6';
			case 7: return '7';
			case 8: return '8';
			case 9: return '9';
			case 10: return 'X';
			case 11: return 'E';
			default: return ' ';
		}
	}
}
