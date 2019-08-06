package com.hrishigadkari;

public class ViCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public ViCustomer(){
        this("drfault name", 2300.50, "de@gmail.com");
    }
    public ViCustomer(String name, double creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public ViCustomer(String name, double creditLimit){
        this(name, creditLimit, "de@gmail.com");
    }
    public String getName() {
        return this.name;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public String getEmail() {
        return this.email;
    }
}
