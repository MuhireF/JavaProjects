package com.hrishigadkari;

class Hamburger{
    private String name;
    private String breadRollType;
    private double price;
    private String addons;
    private boolean first = true;
    private int count = 0;

    public Hamburger(String name, String breadRollType, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.price = price;
        System.out.println("You can add upto 4 items at an additional price");
    }

    public void setAddOns(String addons){
        if(count < 4) {
            if (first) {
                first = false;
                this.addons = addons;
            }
            else
               this.addons =  this.addons + ", " + addons;
            count++;
            this.price += 2;
            System.out.println("The price of the burger is now " + this.price);
        }
        else{
            System.out.println("You add upto maximum of 4 items");
        }
    }
    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public double getPrice() {
        return this.price;
    }

    public String getAddons() {
        return this.addons;
    }

    public int getCount(){
        return this.count;
    }
}

class HealthyBurger extends Hamburger{
    public HealthyBurger(){
        super("Healthy Burger", "brown rye bread", 14);
    }

    @Override
    public void setAddOns(String addons) {
        if(getCount() < 4)
            super.setAddOns(addons);
            else if(getCount() < 6){
                String addAddons = getAddons();
                addAddons =  addAddons + ", " + addons;
            getCount()++;
            this.price += 2;
            System.out.println("The price of the burger is now " + this.price);
        }
    }
}
public class Main {

    public static void main(String[] args) {
	    Hamburger hamburger = new Hamburger("Cheese", "Whole Wheat", 10);
        hamburger.setAddOns("lettuce");
        hamburger.setAddOns("Tomatoes");
        hamburger.setAddOns("Green peppers");
        hamburger.setAddOns("Jalepenos");
        hamburger.setAddOns("Olives");
        hamburger.setAddOns("pickles");
        System.out.println(hamburger.getAddons());
        System.out.println(hamburger.getPrice());
    }
}
