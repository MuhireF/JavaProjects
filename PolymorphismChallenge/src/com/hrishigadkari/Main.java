package com.hrishigadkari;

class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private boolean engine;

    public Car(String name, int cylinders){
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName(){
        return name;
    }
    public void startEngine(){
        System.out.println("The Car engine has started");
    }

    public void accelerate(){
        System.out.println("The car has accelerated");
    }

    public void brake(){
        System.out.println("The car has slowed down");
    }
}

class Buggati extends Car{
    public Buggati(){
        super("Buggati", 16);
    }

    @Override
    public void startEngine() {
        System.out.println("The " + getName() + " engine has started" );
    }

    @Override
    public void accelerate() {
        System.out.println(" and accelerated at 60mph");
    }
}

class Mercedez extends Car{
    public Mercedez(){
        super("Mercedez", 16);
    }

    @Override
    public void startEngine() {
        System.out.println("The " + getName() + " engine has started" );
    }

    @Override
    public void accelerate() {
        System.out.println(" and accelerated at 40mph");
    }
}

public class Main {

    public static void main(String[] args) {
	Car car1 = new Buggati();
	Car car2 = new Mercedez();

	car1.startEngine();
	car1.accelerate();
	car2.startEngine();
	car2.accelerate();


    }
}
