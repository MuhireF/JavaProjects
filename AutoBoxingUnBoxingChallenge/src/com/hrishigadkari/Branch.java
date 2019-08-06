package com.hrishigadkari;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customerList;
    private String name;

    public Branch(String name){
        this.name = name;
        this.customerList = new ArrayList<Customer>();
        System.out.println("Branch with name " + this.name + " has been successfully created!");
    }

    public void addTransaction(Customer customer, double amount){
            customer.setTransactionList(amount);
            System.out.println("A transaction has been added to the customer name " + customer.getName() + "of amount "+ amount);
    }

    public void printCustomers(){
        System.out.println("Here is a list of customers at branch ");
        for (int i = 0; i < this.customerList.size(); i++){
            System.out.println((i+1) + ". " + this.customerList.get(i).getName());
        }
    }

    public Customer findCustomer(String name){
        for (int i =0; i < this.customerList.size(); i++){
            if(this.customerList.get(i).getName().equals(name)){
                System.out.println("Customer is present on file");
                return this.customerList.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Customer createCustomer(String name, double amount) {
        Customer customer = new Customer(name, amount);
        this.customerList.add(customer);
        return customer;
    }
}
