package com.hrishigadkari;

public class BankAccount {
    private int accountNumber;
    private int balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getEmail(){
        return this.email;
    }

    public int phoneNumber(){
        return this.phoneNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(int deposit){
        this.balance += deposit;
        System.out.println("Your balance after deposition is " + this.balance);
    }

    public void withdrawFunds(int withdrawal){
        if(this.balance - withdrawal < 0)
            System.out.println("Insufficient Funds");
        else{
            this.balance -= withdrawal;
            System.out.println("Ypur balance after withdrawal is " + this.balance);
        }
    }
}

