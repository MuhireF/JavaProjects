package com.hrishigadkari;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Bank of America");
    public static void main(String[] args) {
        printMessage();
        boolean outerFlag = false;
        int count;
        while(!outerFlag) {
            boolean bankFlag = false;
            System.out.println("Enter your choice: ");
            count = scanner.nextInt();
            scanner.nextLine();
            switch (count) {
                case 1:
                    printBankMessage();
                    while (!bankFlag) {
                        System.out.println("Enter your choice: ");
                        count = scanner.nextInt();
                        scanner.nextLine();
                        switch (count) {
                            case 0:
                                addBranch();
                                break;
                            case 1:
                                addCustomer();
                                break;
                            case 2:
                                addTransactions();
                                break;
                            case 3:
                                showCustomerList();
                                break;
                            case 4:
                                showTransactionList();
                                break;
                            case 5:
                                bank.printBranches();
                                break;
                            case 6:
                                bankFlag = true;
                                break;

                        }
                    }
                    break;
                case 2:
                    printBranchMessage();
                    while (!bankFlag) {
                        System.out.println("Enter your choice: ");
                        count = scanner.nextInt();
                        scanner.nextLine();
                        switch (count) {
                            case 0:
                                bankFlag = true;
                                break;
                            case 1:
                                addCustomer();
                                break;
                            case 2:
                                addTransactions();
                                break;
                        }
                    }
                    break;
                case 3:
                    outerFlag = true;
                    break;
            }
        }

    }

    private static void printBankMessage(){
        System.out.println("Welcome to the bank section");
    }

    private static void printBranchMessage(){
        System.out.println("Welcome to the branch section");
    }

    private static void showCustomerList(){
        System.out.println("Enter the name of the branch: ");
        String branchName = scanner.nextLine();
        Branch branch = bank.findBranch(branchName);
        if(branch != null) {
            branch.printCustomers();
        }
    }

    private static void showTransactionList(){
        System.out.println("Enter the name of the branch: ");
        String branchName = scanner.nextLine();
        Branch branch = bank.findBranch(branchName);
        if(branch != null) {
            System.out.println("Enter the name of the customer: ");
            String customerName = scanner.nextLine();
            if (branch.findCustomer(customerName) != null) {
                branch.findCustomer(customerName).printTransactions();
            }
        }
    }
    private static void addBranch(){
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();

        if(bank.findBranch(branchName) == null){
            bank.createBranch(branchName);
        }

    }

    private static void addTransactions(){
        System.out.println("Enter the name of the branch: ");
        String branchName = scanner.nextLine();
        Branch branch = bank.findBranch(branchName);
        if(branch != null) {
            System.out.println("Enter the name of the customer: ");
            String customerName = scanner.nextLine();
            if(branch.findCustomer(customerName) != null) {
                System.out.println("Enter the transaction amount to be added:");
                double transactionAmount = scanner.nextDouble();
                scanner.nextLine();
                branch.findCustomer(customerName).setTransactionList(transactionAmount);
            }
        }
    }

    private static void addCustomer(){
        System.out.println("Enter the name of the branch where the customer needs to be added: ");
        String branchName = scanner.nextLine();
        if(bank.findBranch(branchName) != null){
            System.out.println("Enter the name of the customer: ");
            String customerName = scanner.nextLine();
            if(bank.findBranch(branchName).findCustomer(customerName) == null) {
                System.out.println("Enter the initial amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                bank.findBranch(branchName).createCustomer(customerName, amount);
            }
        }

    }

    private static void printMessage(){
        System.out.println("Welcome to the " + bank.getName());
    }
}
