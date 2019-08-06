package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
	    Printer printer = new Printer(false);
        System.out.println(printer.getTonerLevel());
        printer.printPages(20);
        System.out.println(printer.getTonerLevel());
        printer.fillToner(20);
    }
}
