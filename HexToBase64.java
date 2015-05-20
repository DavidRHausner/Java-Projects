// Hex String To Base64 String Converter
// Written by David Hausner
// May 19, 2015

import java.math.BigInteger;
import java.lang.String;
import java.util.Scanner;

public class HexToBase64 {

	public static void main(String args[]){
		HexToBase64 hextobase64 = new HexToBase64();
	}
	
	public HexToBase64(){
		Scanner user_input = new Scanner( System.in );
		String input_string;
		System.out.print("Enter hex string: ");
		input_string = user_input.next();
		user_input.close();
		String bin = "";
		String output = "";
		bin = this.HexToBinary(input_string);
		output = this.BinaryToBase64(bin);
		System.out.println(output);
	}
	
	public String HexToBinary(String s) {
		String str = "";
		for(int i=0; i<s.length(); i++)
	    {
			switch(s.charAt(i))
	        {
	        case('0'):
	            str = str.concat("0000");
	            break;
	        case('1'):
	        	str = str.concat("0001");
	            break;
	        case('2'):
	        	str = str.concat("0010");
	            break;
	        case('3'):
	        	str = str.concat("0011");
	            break;
	        case('4'):
	        	str = str.concat("0100");
	            break;
	        case('5'):
	        	str = str.concat("0101");
	            break;
	        case('6'):
	        	str = str.concat("0110");
	            break;
	        case('7'):
	        	str = str.concat("0111");
	            break;
	        case('8'):
	        	str = str.concat("1000");
	            break;
	        case('9'):
	        	str = str.concat("1001");
	            break;
	        case('a'):
	        	str = str.concat("1010");
	            break;
	        case('b'):
	        	str = str.concat("1011");
	            break;
	        case('c'):
	        	str = str.concat("1100");
	            break;
	        case('d'):
	        	str = str.concat("1101");
	            break;
	        case('e'):
	        	str = str.concat("1110");
	            break;
	        case('f'):
	        	str = str.concat("1111");
	            break;
	        default:
	            break;
	        }
	    };
		return str;
	}
	public String BinaryToBase64(String s) {
		String str = "";
		String sub;
		for(int j=0; j<s.length()-5; j=j+6)
		{
			sub = s.substring(j,j+6);
			str = str.concat(BinaryToString(sub));
		}
		return str;
	} 
	
	public String BinaryToString(String sub) {
		String str = "";
		String s;
		int temp;
		s = new BigInteger(sub, 2).toString();
		temp = Integer.parseInt(s);
		if(temp>=0 && temp<=25)
		{
			str = String.valueOf((char)(temp + 65));
		}
		if(temp>=26 && temp<=51)
		{
			str = String.valueOf((char)(temp + 71));
		}
		if(temp>=52 && temp<=61)
		{
			str = String.valueOf((char)(temp-4));
		}
		if(temp==62)
		{
			str = "+";
		}
		if(temp==63)
		{
			str = "/";
		}
		return str;
	}
}
