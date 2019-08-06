package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
        ViCustomer customer1 = new ViCustomer();
        System.out.println(customer1.getName());

        ViCustomer customer2 = new ViCustomer("John Doe", 5000);
        System.out.println(customer2.getName());

        ViCustomer customer3 = new ViCustomer("Gary May", 3000, "gm@gmail.com");
        System.out.println(customer3.getName());
    }
}
