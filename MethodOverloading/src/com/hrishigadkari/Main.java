package com.hrishigadkari;

public class Main {
    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if(feet >= 0 && (inches >= 0 && inches <= 12))
            return (2.54*inches) + (12*2.54*feet);
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if(inches >= 0)
           return calcFeetAndInchesToCentimeters((int) inches/12, (int) inches%12);
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(-10));
    }
}
