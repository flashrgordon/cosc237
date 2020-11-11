/******************************************************
COSC 237.001                              Assignment #2
Names:         Victoria Raulin, Ryan Gordon, Ayoob Redi
Due Date:                                    10/20/2020
Program Name:                       ComplexNumberClient
 ******************************************************/
import java.util.Scanner;

public class ComplexNumberClient {

	public static int getInt(Scanner input, String prompt) {
		System.out.println(prompt);
		while (!input.hasNextInt()) {
			input.next();
			System.out.println("Not an integer try again");
		}
		return input.nextInt();
	}

	public static int menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Your options for complex arithmetic are:");
		System.out.println("1) add 2 complex numbers");
		System.out.println("2) subtract 2 complex numbers");
		System.out.println("3) multiply 2 complex numbers");
		System.out.println("4) divide 2 complex numbers");
		System.out.println("5) absolute value of a complex number");
		System.out.println("6) compare 2 complex numbers");
		System.out.println("0) EXIT");
		int x = getInt(input, "please enter your option");
		return x;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean cont = true;
		int i = 0;


		while(cont) {
			ComplexNumber x = new ComplexNumber();
			ComplexNumber y = new ComplexNumber();
			int option = menu();
			switch(option) {
			default: System.out.println("enter valid option");
			         break;
			case 0: cont = false;
					break;
			case 1: x.read(input);
					y.read(input);
					System.out.println("Result: " + x.add(y));
					break;
			//FIX
			case 2: x.read(input);
					y.read(input);
					System.out.println("Result: " + x.subtract(y));
					break;
			case 3: x.read(input);
					y.read(input);
					System.out.println("Result: " + x.multiply(y));
					break;
			case 4: x.read(input);
					y.read(input);
					System.out.println("Result: " + x.divide(y));
					break;
			case 5: x.read(input);
					System.out.println("absolute value of " + x.toString() + ": " + x.cAbs());
					break;
			case 6: x.read(input);
					y.read(input);
					if(x.equals(y)) {
						System.out.println("equal");
					} else {
						System.out.println("not equal");
					}
					break;		
			}
			i++;
			System.out.printf("Command number %d completed\n", i);
		}



	}

}
