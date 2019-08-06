package com.hrishigadkari;

public class Printer {
    private int tonerLevel = 100;
    private int pagesPrinted = 0;
    private boolean isDuplex;

    public Printer(boolean isDuplex){
        this.isDuplex = isDuplex;
    }

    public void printPages(int pagesPrinted){
        this.pagesPrinted += pagesPrinted;
        this.tonerLevel -= (pagesPrinted*2);
        System.out.println("The number of pages printed" + pagesPrinted);
    }
    public void fillToner(int toner){
        this.tonerLevel += toner;
        if(this.tonerLevel > 100)
            this.tonerLevel = 100;
        System.out.println("Toner level is filled to: " + this.tonerLevel);
    }
    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
