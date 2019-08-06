package com.hrishigadkari;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the count of numbers:");
        int count = scanner.nextInt();
        System.out.println(findMin(readIntegers(count)));
    }

    private static int findMin(int[] arrayMin){
        int tempmin = arrayMin[0];
        for(int i = 1; i < arrayMin.length; i++){
            if(arrayMin[i] < tempmin)
                tempmin = arrayMin[i];
        }
        return tempmin;
    }

    private static int[] readIntegers(int numbers){
        int[] array = new int[numbers];
        System.out.println("Enter " + numbers + " numbers\r");
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
