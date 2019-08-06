package com.hrishigadkari;

public class Fan {
    private String type;
    private String manufacturer;
    private String color;
    private Speed speed;

    public Fan(String type, String manufacturer, String color, Speed speed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.color = color;
        this.speed = speed;
    }

    public void turnOn(){
        System.out.println("The fan is been moving at speed " + speed.getSpeed());
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

}
