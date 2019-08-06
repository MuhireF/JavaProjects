package com.hrishigadkari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int number;
        int sum = 0;
        while (count < 11) {
            System.out.println("Enter number " + count + ":");
            boolean isInt = scanner.hasNextInt();
            if(isInt){
                number = scanner.nextInt();
                sum += number;
                count++;
            }
            else{
                System.out.println("Invalid Number:");
            }
            scanner.nextLine();
        }
        System.out.println("The sum is: " + sum);
        scanner.close();
    }
}
