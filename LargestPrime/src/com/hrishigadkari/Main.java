package com.hrishigadkari;

public class Main {
    public static int getLargestPrime(int number){
        if(number < 2 ){
            return -1;
        }
        int theLargest = number;
        for (int i = 2; i < number ; i++){
            if ( number % i == 0 ) {
                number = number / i;
                theLargest = number;
                i = 1;
            }

        }
        return theLargest;
    }
    public static void main(String[] args) {
        System.out.println(getLargestPrime(215));
    }
}
