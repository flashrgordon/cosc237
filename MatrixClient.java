/******************************************************
COSC 237.001                              Assignment #2
Names:         Victoria Raulin, Ryan Gordon, Ayoob Redi
Due Date:                                    10/20/2020
Program Name:                              MatrixClient
 ******************************************************/

import java.util.Scanner;

public class MatrixClient {
	public static final int MAX = 20;
	public static final int LOW = 1;
	public static final int UP = 10;

	public static void main(String[] args) {
		int counter = 0;
		Scanner input = new Scanner(System.in);
		String go_again = "y";

		int size = getInt(input, "What size matrices? ");
		while (size < 1) {
			System.out.println("Enter a positive integer! ");
			size = getInt(input, "What size matrices? ");
		}

		Matrix m1 = new Matrix(size);
		m1.init();
		Matrix m2= new Matrix(size);
		m2.init();
		Matrix m3 = new Matrix(size);
		m3.init();

		System.out.println("m1 is:");
		m1.print();
		System.out.println("m2 is:");
		m2.print();
		System.out.println("m3 is:");
		m3.print();
		System.out.println();

		while ((go_again.toLowerCase()).equals("y")) {  
			int menu_choice = menu();
			switch (menu_choice) {
			case 1:
				System.out.println("Adding m1 and m2.");
				Matrix sum = m1.add(m2);
				sum.print();
				break;
			case 2:
				System.out.println("Subtracting m2 from m3.");
				Matrix difference = m3.subtract(m2);
				difference.print();
				break;
			case 3:
				System.out.println("Multiplying m1 and m2.");
				Matrix product = m1.multiplyMatrix(m2);
				product.print();
				break;
			case 4:
				int constant = getInt(input, "What is your constant?");
				System.out.println("Multiplying m3 by " + constant + ".");
				m3.multiplyConstant(constant);
				m3.print();
				break;
			case 5:
				System.out.println("Transposing m1.");
				Matrix transpose = m1.transposeMatrix();
				transpose.print();
				break;
			case 6:
				System.out.println("Trace of m2 is: " + m2.traceMatrix());
				break;
			case 7:
				System.out.println("Making a copy of m1.");
				System.out.println("Original m1:");
				m1.print();
				Matrix copy = m1.getCopy();
				System.out.println("Copy of m1:");
				copy.print();
				System.out.println("Testing for equality:");
				System.out.println(m1.equals(copy));
				break;
			case 8:
				System.out.println("Testing for equality between m1 and m2.");
				if (m1.equals(m2)) {
					System.out.println("m1 and m2 are equal!");
				}
				else {
					System.out.println("m1 and m2 are not equal!");
				}
				break;
			default:
				go_again = "n";
				break;
			}
			counter++;
			System.out.println("Operation number " + counter + " completed.");
			System.out.println("Would you like to go again? Enter y/Y for yes: ");
			go_again = input.next();
		}
	}

	public static int menu() {
		Scanner input=new Scanner(System.in);

		System.out.println("Your options are:");
		System.out.println("*****************");
		System.out.println(" 1.) Add 2 matrices");
		System.out.println(" 2.) Subtract 2 matrices");
		System.out.println(" 3.) Multiply 2 matrices");
		System.out.println(" 4.) Multiply a matrix by a constant");
		System.out.println(" 5.) Transpose a matrix");
		System.out.println(" 6.) Matrix trace");
		System.out.println(" 7.) Make a copy");
		System.out.println(" 8.) Test for equality between 2 matrices");
		System.out.println(" 0.) EXIT");

		int choice=getInt(input, "Please enter your option: ");
		while (choice < 0 || choice > 8) {
			choice=getInt(input, "Please enter a valid option: ");
		}

		return choice;
	}

	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		while (!input.hasNextInt()) {
			input.next();
			System.out.println("Not an integer! Try again. ");
		}
		return input.nextInt();
	}
}
