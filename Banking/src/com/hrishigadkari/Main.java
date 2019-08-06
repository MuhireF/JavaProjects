package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
	BankAccount account = new BankAccount();
	account.setAccountNumber(121233);
	account.setBalance(20000);
	account.setCustomerName("John Doe");
	account.setEmail("jd@gmail.com");
	account.setPhoneNumber(808786778);
        System.out.println(account.getAccountNumber());
        System.out.println(account.getCustomerName());
        System.out.println(account.getBalance());
        account.depositFunds(300);
        account.withdrawFunds(3400);
    }
}
