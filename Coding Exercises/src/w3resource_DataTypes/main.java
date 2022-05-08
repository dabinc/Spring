package w3resource_DataTypes;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("input inch to convert");
		double inches = in.nextDouble();
		final double METER_PER_INCH = 0.0254;
		System.out.println(inches + "inch(s) is " + METER_PER_INCH * inches + " Meters");
		
	}
}
