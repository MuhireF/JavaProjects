package com.hrishigadkari;

public class Vehicle {
    private String name;
    private int wheels;
    private int doors;
    private int windows;
    private String transmission;

    public Vehicle(String name, int wheels, int doors, int windows, String transmission) {
        this.name = name;
        this.wheels = wheels;
        this.doors = doors;
        this.windows = windows;
        this.transmission = transmission;
    }

    public void move(int speed){
        System.out.println("Vehicle is running at: " + speed);
    }

    public void handSteering(String direction){
        System.out.println("Vehicle is turning: " + direction);
    }

    public void changingGears(int number){
        System.out.println("Vehicle is on gear: " + number);
    }
}
