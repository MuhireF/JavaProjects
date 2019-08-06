package com.hrishigadkari;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Players player = new Players("Tim", 50, 98);
        System.out.println(player);

        saveObject(player);
        loadObject(player);
        System.out.println(player);

        Monsters jack = new Monsters("Jack", 20);
        System.out.println(jack);

        jack.setHealth(10);
        saveObject(jack);
        loadObject(jack);

        System.out.println(jack);
    }

        public static ArrayList<String> readValues() {
            ArrayList<String> values = new ArrayList<String>();

            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            int index = 0;
            System.out.println("Choose\n" +
                    "1 to enter a string\n" +
                    "0 to quit");

            while (!quit) {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Enter a string: ");
                        String stringInput = scanner.nextLine();
                        values.add(index, stringInput);
                        index++;
                        break;
                }
            }
            return values;
        }

        public static void saveObject(Saveable objectToSave){
            for(int i = 0; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to the storage medium");
        }
        }

        public static void loadObject(Saveable objectToLoad){
            ArrayList<String> values = readValues();
            objectToLoad.read(values);
        }

}
