package com.hrishigadkari;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactionList;
    private String name;

    public Customer(String name, double amount){
        this.name = name;
        this.transactionList = new ArrayList<Double>();
        this.transactionList.add(amount);
        System.out.println("A new customer has been created with name as " + this.name + " and initial amount of " + amount);
    }

    public void printTransactions(){
        System.out.println("Here is a list of transactions for customer ");
        for (int i = 0; i < transactionList.size(); i++){
            System.out.println((i+1) + ". ->" + transactionList.get(i));
        }
    }

    public void setTransactionList(double amount){
        this.transactionList.add(amount);
        System.out.println("The transaction is been successfully done");
    }


    public String getName() {
        return name;
    }
}
