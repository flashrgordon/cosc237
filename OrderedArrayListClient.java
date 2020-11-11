/**************************************************************
COSC 237.001                                      Assignment #3
Names:                 Ryan Gordon, Ayoob Redi, Victoria Raulin
Due Date:                                            11/12/2020
Program Name:                                      MatrixClient
**************************************************************/

import java.util.Scanner;
import java.io.*;

public class OrderedArrayListClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner text;
        OrderedArrayList list1 = new OrderedArrayList();
        OrderedArrayList list2 = new OrderedArrayList();
        File file;
        
        //first list population
        System.out.println("Please enter the name of the file to be opened for the first list: ");
        try {
            file = new File(console.next());
            text = new Scanner(file);
            while (text.hasNext()) {
                list1.list[list1.length++] = getInt(text, "");
            }
            System.out.println("List 1 length: " + list1.length);
        }
        catch(Exception fnf) {
            System.out.println("Error! file not found.");
        }
        
        //second list population
        System.out.println("Please enter the name of the file to be opened for the second list: ");
        try {
            file = new File(console.next());
            text = new Scanner(file);
            while (text.hasNext()) {
                list2.list[list2.length++] = getInt(text, "");
            }
            System.out.println("List 2 length: " + list2.length);
        }
        catch(Exception fnf) {
            System.out.println("Error! file not found.");
        }
        
        System.out.println("The first list is: ");
        list1.print();
        System.out.println("The second list is: ");
        list2.print();
        
        System.out.println("Merged list is: ");
        OrderedArrayList merged_list = list1.merge(list2);
        merged_list.print();

        int key = getInt(console,"Enter key for split: ");
        merged_list.split(key);
    }
    
    public static int getInt(Scanner input, String prompt) {
        if (!(prompt.equals(""))) {
            System.out.println(prompt);
        }
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Item not an integer");
        }
        int next = input.nextInt();
        System.out.println("in getInt --- " + next);
        
        return next;
    }
}
