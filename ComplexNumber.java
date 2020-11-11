/******************************************************
COSC 237.001                              Assignment #2
Names:         Victoria Raulin, Ryan Gordon, Ayoob Redi
Due Date:                                    10/20/2020
Program Name:                              ComplexNumber
 ******************************************************/
import java.util.Scanner;

public class ComplexNumber {
	//initialize variables
	private double a;
	private double b;
	//default constructor
	public ComplexNumber() {
		a = 0;
		b = 0;
	}
	//explicit constructor
	public ComplexNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public void read(Scanner input) {
		this.a = getDouble(input, "enter the real number");
		this.b = getDouble(input, "enter the imaginary number");
	}
	
	public static double getDouble(Scanner input, String prompt) {
		System.out.println(prompt);
		while (!input.hasNextDouble()) {
			input.next();
			System.out.println("Not a double try again");
		}
		return input.nextDouble();
	}
	
	public void print() {
		System.out.printf("(%.2f, %.2f)", a, b);
	}
	public double getReal() {
		return a;
	}
	public double getImaginary() {
		return b;
	}
	
	public boolean equals(ComplexNumber x) {
		return x.a == a && x.b == b;
	}
	
	public void copy(ComplexNumber x) {
		a = x.a;
		b = x.b;
	}
	
	public ComplexNumber getCopy(ComplexNumber x) {
		return new ComplexNumber(a, b);
	}
	
	public String toString() {
		return "(" + a + ", " + b + ")";
	}
	
	public ComplexNumber add(ComplexNumber x) {
		double y, z;
		y = a + x.a;
		z = b + x.b;
		return new ComplexNumber(y, z);
	}
	
	public ComplexNumber subtract(ComplexNumber x) {
		double y, z;
		y = a - x.a;
		z = b - x.b;
		return new ComplexNumber(y, z);
	}
	
	public ComplexNumber multiply(ComplexNumber x) {
		double y, z;
		y = a * x.a - b * x.b;
		z = a * x.b + b * x.a;
		return new ComplexNumber(y, z);
	}
	
	public ComplexNumber divide(ComplexNumber x) {
		double y, z;
		y = (a * x.a + b * x.b)/(Math.pow(x.a, 2) + Math.pow(x.b, 2));
		z = (b * x.a - a * x.b)/(Math.pow(x.a, 2) + Math.pow(x.b, 2));
		return new ComplexNumber(y, z);
	}
	
	public double cAbs() {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
}
