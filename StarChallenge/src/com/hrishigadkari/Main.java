package com.hrishigadkari;

public class Main {
    public static void printSquareStar(int number){
        int rowCount = 1;
        int colNumber = number;
        for(int i = 1; i <= number; i++){
            System.out.println("*");
            for(int j = rowCount + 1; j <= colNumber; j++ ){
                System.out.print("*");
            }
            rowCount++;
        }
    }
    public static void main(String[] args) {
	// write your code here
    }
}
