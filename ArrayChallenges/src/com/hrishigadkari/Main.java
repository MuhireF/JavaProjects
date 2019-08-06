package com.hrishigadkari;


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    int[] integers = getarrayIntegers(5);
	    printArray(integers);
        System.out.println("\nThe sorted array is\n");
        printArray(sortArrray(integers));
    }

    public static int[] sortArrray(int[] arraySort){
        for(int i = 0; i < arraySort.length; i++){
            for(int j = i+1; j < arraySort.length; j++){
                if(arraySort[i] < arraySort[j]){
                    int temp = arraySort[i];
                    arraySort[i] = arraySort[j];
                    arraySort[j] = temp;
                }

            }
        }
        return arraySort;
    }

    public static void printArray(int[] integersArray){
        for(int i = 0; i<integersArray.length; i++){
            System.out.println("Index: " + i + ", Number: " + integersArray[i]);
        }
    }

    public static int[] getarrayIntegers(int numbers){
        int[] arrayNumbers = new int[numbers];
        System.out.println("Enter " + numbers + " numbers:\r");
        for(int i = 0; i < arrayNumbers.length; i++){
            arrayNumbers[i] = scanner.nextInt();
        }

        return arrayNumbers;
    }
}
