/*
Written by David Hausner
03-28-2016
*/
import java.util.Scanner;
public class VectorMath
{
	private String vectorA;
	private String vectorB;
	private double AX, AY, AZ, BX, BY, BZ;
	public double DotProduct()
	{
		System.out.println();
		return ((AX*BX)+(AY*BY)+(AZ*BZ));
	}
	public String CrossProduct()
	{
		double X = (AY*BZ)-(BY*AZ);
		double Y = (AZ*BX)-(BZ*AX);
		double Z = (AX*BY)-(BX*AY);
		String answer = ""+X+"i+"+Y+"j+"+Z+"k";
		return answer; 
	}
	public void SetVectors()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first vector in Mi+Nj+Pk form.");
		vectorA = scanner.nextLine();
		System.out.println("Enter the second vector in Mi+Nj+Pk form.");
		vectorB = scanner.nextLine();
		scanner.close();
	}
	public void ParseVectors()
	{
		//parse the user's input and store it in vector component variables
		//Vector A
		AX = Double.parseDouble(vectorA.substring(0,vectorA.indexOf('i')));
		//if the jth term is positive, ignore the "+" character
		if(vectorA.charAt(vectorA.indexOf('i'))==('+'))
			AY = Double.parseDouble(vectorA.substring(vectorA.indexOf('i')+2,vectorA.indexOf('j')));
		//if the jth term is negative, include the "-" character
		else
			AY = Double.parseDouble(vectorA.substring(vectorA.indexOf('i')+1,vectorA.indexOf('j')));
		//if the kth term is positive, ignore the "+" character
		if(vectorA.charAt(vectorA.indexOf('j'))=='+')
			AZ = Double.parseDouble(vectorA.substring(vectorA.indexOf('i')+2,vectorA.indexOf('k')));
		//if the kth term is negative, include the "-" character
		else
			AZ = Double.parseDouble(vectorA.substring(vectorA.indexOf('j')+1,vectorA.indexOf('k')));
		//Vector B
		BX = Double.parseDouble(vectorB.substring(0,vectorB.indexOf('i')));
		//if the jth term is positive, ignore the "+" character
		if(vectorB.charAt(vectorB.indexOf('i'))=='+')
			BY = Double.parseDouble(vectorB.substring(vectorB.indexOf('i')+2,vectorB.indexOf('j')));
		//if the jth term is negative, include the "-" character
		else
			BY = Double.parseDouble(vectorB.substring(vectorB.indexOf('i')+1,vectorB.indexOf('j')));
		//if the kth term is positive, ignore the "+" character
		if(vectorB.charAt(vectorB.indexOf('j'))=='+')
			BZ = Double.parseDouble(vectorB.substring(vectorB.indexOf('i')+2,vectorB.indexOf('k')));
		//if the kth term is negative, include the "-" character
		else
			BZ = Double.parseDouble(vectorB.substring(this.vectorB.indexOf('j')+1,this.vectorB.indexOf('k')));
	}
}
