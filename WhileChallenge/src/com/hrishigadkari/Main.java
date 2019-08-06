package com.hrishigadkari;

public class Main {

    public static int sumDigits(int number){
       if(number < 10)
           return -1;
       int sum = 0;
       while(number != 0){
           sum += number%10;
           number = number/10;

       }
       return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(-125));
        System.out.println(sumDigits(4));
        System.out.println(sumDigits(32123));
    }
}
