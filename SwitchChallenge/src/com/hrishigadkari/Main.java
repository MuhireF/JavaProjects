package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
	char charVariable = 'D';
	switch (charVariable){
        case 'A': case 'B': case 'C': case 'D': case 'E':
            System.out.println("The character " + charVariable + " was found!");
            break;
         default:
             System.out.println("Not found");
             break;
    }
    }
}
