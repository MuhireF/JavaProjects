package com.hrishigadkari;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        boolean flag = false;
        int count = 0;
        printInstructions();
        while(!flag){

            System.out.println("Enter your choice: ");
            count = scanner.nextInt();
            scanner.nextLine();

            switch (count){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    System.out.println("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the number: ");
                    String number = scanner.nextLine();
                    mobilePhone.storeContact(Contacts.createContact(name, number));
                    break;
                case 2:
                    System.out.println("Enter the name of the contact to modify ");
                    String oldName = scanner.nextLine();
                    mobilePhone.findContact(oldName);
                    System.out.println("Enter the new name");
                    String newName = scanner.nextLine();
                    mobilePhone.modifyContact(oldName, newName);
                    break;
                case 3:
                    System.out.println("Enter the name you want to query");
                    String queryName = scanner.nextLine();
                    mobilePhone.findContact(queryName);
                    break;
                case 4:
                    System.out.println("Enter the name of the contact you want to delete");
                    String delName = scanner.nextLine();
                    mobilePhone.removeContact(delName);
                    break;
                case 5:
                    mobilePhone.printContactList();
                    break;
                case 6:
                    flag = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.print("Enter 0 for accessing instructions.\n " +
                "Enter 1 to store a contact.\n" +
                "Enter 2 to modify contact name.\n" +
                "Enter 3 to query a contact name. \n" +
                "Enter 4 to delete a contacr.\n" +
                "Enter 5 to print contact list.\n" +
                "Enter 6 to exit.\n");
    }
}
