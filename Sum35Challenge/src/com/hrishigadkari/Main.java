package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
	    for(int i = 1; i <= 1000; i++){
	        if(i%15==0){
	            sum += i;
                System.out.println("The number: " + i);
	            count++;
	            if(count == 5){
	                break;
                }
            }
        }
        System.out.println("The sum is: " + sum);
    }
}
