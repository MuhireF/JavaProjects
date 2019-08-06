package com.hrishigadkari;

public class Room {
    private Fan fan;
    private Ceiling ceiling;

    public Room(Fan fan, Ceiling ceiling) {
        this.fan = fan;
        this.ceiling = ceiling;
    }

    private void powerOnFan(){
        fan.turnOn();
    }

    public void turnSwitch(){
        powerOnFan();
    }

    public Ceiling getCeiling() {
        return ceiling;
    }
}
