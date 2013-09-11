//Written by David Hausner, 9/11/13

import java.text.DecimalFormat;
import java.util.Scanner;

public class DistanceOnGlobe {
	public static void main(String[] args) {
		new DistanceOnGlobe();
	}
	public DistanceOnGlobe() {
		//double values of latitude and longitude for two points
		double latA, latB, lonA, lonB, distance, angle;
		final double radius_of_the_earth = 3959.0;
		//string values of latitude and longitude for two points
		String str_latA, str_latB, str_lonA, str_lonB;
		
		//prompts the user for the lat. and long. of two points
		Scanner userScan = new Scanner(System.in);
		System.out.println("Welcome to Distance-on-a-Globe Calculator!");
		System.out.print("Enter the first point's latitude in decimal degrees: ");
		str_latA = userScan.next();
		System.out.print("Enter the first point's longitude in decimal degrees: ");
		str_lonA = userScan.next();
		System.out.print("Enter the second point's latitude in decimal degrees: ");
		str_latB = userScan.next();
		System.out.print("Enter the second point's longitude in decimal degrees: ");
		str_lonB = userScan.next();
		userScan.close();
		
		//attempts to parse user's values to double variables
		try{
			latA = Double.parseDouble(str_latA);
			lonA = Double.parseDouble(str_lonA);
			latB = Double.parseDouble(str_latB);
			lonB = Double.parseDouble(str_lonB);
		}
		catch(NumberFormatException nfe){
			//notifies the user that they input their data incorrectly
			//and replaces their data with valid numbers
			System.out.println("You entered the points incorrectly.");
			latA = 0;
			lonA = 0;
			latB = 0;
			lonB = 0;
		}
		
		//Spherical Law of Cosines method for distance 
		//between two points on the surface of a sphere
		angle = Math.acos(Math.sin(Math.toRadians(latA))*Math.sin(Math.toRadians(latB)) 
				+ Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))
				*Math.cos(Math.toRadians(lonA-lonB)));
		distance = radius_of_the_earth * angle;
		
		//formats the precision of the double output
		DecimalFormat df = new DecimalFormat("#.##");
		distance = Double.valueOf(df.format(distance));
		System.out.format("The distance between those two points is " + distance + " miles.");
	}

}
