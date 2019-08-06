package com.hrishigadkari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minimum=0, maximum=0;
        boolean first = true;
        while(true){
            System.out.println("Enter the number: ");
            boolean isInt = scanner.hasNextInt();
            if(isInt){

                int number = scanner.nextInt();
                if(first){
                    first = false;
                    minimum = number;
                    maximum = number;
                }
                if(number <= minimum){
                    minimum = number;
                }else if(number >= maximum){
                    maximum = number;
                }
                scanner.nextLine();
            }else {
                System.out.println("Invalid Number");
                break;
            }
        }
        System.out.println("Minimum: " + minimum + " Maximum: " + maximum);
        scanner.close();
    }
}
