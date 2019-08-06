package com.hrishigadkari;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = {1, 2, 3, 4, 5};
	    reverseArray(array);
    }

    private static void reverseArray(int[] array){
        int[] reversedArray = new int[array.length];
        int j = 0;
        for(int i = array.length - 1; i >=0; i--){
            reversedArray[j] = array[i];
            j++;
        }

        System.out.println("The reversed array is " + Arrays.toString(reversedArray));
    }
}
