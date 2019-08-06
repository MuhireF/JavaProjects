package com.hrishigadkari;

public class Car extends Vehicle {
    private String modelType;
    private int mirrors;
    private int size;

    public Car(String name, int doors, int windows, String modelType, int mirrors, int size){
       super(name, 4, doors, windows, "manual");
       this.modelType = modelType;
       this.mirrors = mirrors;
       this.size = size;
    }


}
