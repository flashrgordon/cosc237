/*************************************
COSC 237.001             Assignment #1
Names:         Ryan Gordon, Ayoob Redi
Due Date:                   09/24/2020
Program Name:          ModularityShift
*************************************/

import java.util.*;
import java.io.*;

public class ModularityShift {
    public static final int MIN_RAND=1;
    public static final int MAX_RAND=100;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char go_again='y';
        
        while (go_again =='y' || go_again == 'Y') {
            int menu_answer=menu(input, "Please enter your option:\n");

            if (menu_answer != 0) {
                System.out.println("How many elements?");
                int num_elements=input.nextInt();
                int[] array = new int[num_elements];
                initRand(array);

                System.out.println("The original list is:");
                print(array);
 
                switch(menu_answer) {
                    case 1:
                        System.out.println("The list after left rotation is:");
                        shiftLeft(array);
                        print(array);
                        break;
                    case 2:
                        System.out.println("Input k steps:");
                        int left_in_place_steps=input.nextInt();
                        shiftLeft(array,left_in_place_steps);
                        System.out.println("The list after left rotation by "+ left_in_place_steps + " steps in place is:");
                        print(array);
                        break;
                    case 3:
                        System.out.println("Input k steps:");
                        int left_copy_steps=input.nextInt();
                        int[] left_copy = shiftLeftK(array,left_copy_steps);
                        System.out.println("The second list after left rotation by " + left_copy_steps + " steps is:");
                        print(left_copy);
                        break;
                    case 4:
                        System.out.println("The list after right rotation is:");
                        shiftRight(array);
                        print(array);
                        break;
                    case 5:
                        System.out.println("Input k steps:");
                        int right_in_place_steps = input.nextInt();
                        shiftRight(array,right_in_place_steps);
                        System.out.println("The list after right rotation by " + right_in_place_steps + " steps in place is:");
                        print(array);
                        break;
                    case 6:
                        System.out.println("Input k steps:");
                        int right_copy_steps=input.nextInt();
                        int[] right_copy= shiftRightK(array,right_copy_steps);
                        System.out.println("The second list after right rotation by " + right_copy_steps + "steps is:");
                        print(right_copy);
                        break;
                    default:
                        go_again='n';
                        break;
                }
            }
            else {
                go_again='n';
            }
        }
    }
    
    public static void shiftLeft(int[] array) {
        int dummy=array[0];
        for (int i=0; i<array.length-1; i++) {
            array[i]=array[i+1];
        }
        
        array[array.length-1]=dummy;
    }
    
    public static void shiftLeft(int[] array, int k) {
        for (int num_shifts=0; num_shifts<k; num_shifts++) {
            int dummy=array[0];
            for (int i=0; i<array.length-1; i++) {
                array[i]=array[i+1];
            }

            array[array.length-1]=dummy;
        }
    }
    
    public static int[] shiftLeftK(int[] array, int k) {
        int[] copy= copyArray(array);
        for (int num_shifts=0; num_shifts<k; num_shifts++) {
            int dummy=copy[0];
            for (int i=0; i<copy.length-1; i++) {
                copy[i]=copy[i+1];
            }

            copy[copy.length-1]=dummy;
        }
        
        for (int i=0; i <copy.length;i++) {
            System.out.print(" " + copy[i]);
        }
        
        return copy;
    }
    
    
    public static void shiftRight(int[] array) {
        int dummy = array[array.length-1];
        for (int i=array.length-1; i>0; i--) {
            array[i]=array[i-1];
        }
        
        array[0]=dummy;
    }
    
    public static void shiftRight(int[] array, int k) {
        for (int num_shifts=0; num_shifts < k; num_shifts++) {
            int dummy = array[array.length-1];
        for (int i=array.length-1; i>0; i--) {
            array[i]=array[i-1];
        }
        
        array[0]=dummy;
        }
    }
    
    public static int[] shiftRightK(int[] array, int k) {
        int[] copy=copyArray(array);
        for (int num_shifts=0; num_shifts < k; num_shifts++) {
            int dummy = copy[copy.length-1];
            for (int i=copy.length-1; i>0; i--) {
                copy[i]=copy[i-1];
            }

            copy[0]=dummy;
            }
        
        for (int i=0; i<copy.length; i++) {
            System.out.print(" " + copy[i]);
        }
        
        return copy;
    }
    
    
    public static int[] copyArray(int[] array) {
        int[] copy= new int[array.length];
        for (int i=0; i<array.length; i++) {
            copy[i]=array[i];
        }
        
        return copy;
    }
    
    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Not an integer! Try again. ");
        }
        return input.nextInt();
    }
     
    public static void initRand(int[] array) {
        Random rand = new Random();
        
        for (int i=0; i < array.length; i++) {
            array[i]=(rand.nextInt(MAX_RAND-MIN_RAND))+MIN_RAND;
        }
    }
    
    public static void print(int[] array) {
        for (int i =0; i < array.length; i++) {
            System.out.printf("%-3d", array[i]);
        }
        System.out.println();
    }
    
    public static int menu(Scanner input, String prompt) {   
        System.out.println("Your options are:");
        System.out.println("-----------------");
        System.out.println(" 1) Shift left");
        System.out.println(" 2) Shift left (k steps) in place");
        System.out.println(" 3) Shift left (k steps) in second array");
        System.out.println(" 4) Shift right");
        System.out.println(" 5) Shift right (k steps) in place");
        System.out.println(" 6) Shift right (k steps) in second array");
        System.out.println(" 0) EXIT");
        
        int answer = getInt(input, prompt);
        
        if (answer > 0 && answer < 6) {
            return answer;
        }
        
        else {
            while (answer < 0 || answer > 6) {
                System.out.println("Enter an integer between 0-6.");
                answer=getInt(input, prompt);
                System.out.println("**********");
            }
            
            return answer;
        }
    }
    
}