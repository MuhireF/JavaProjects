package com.hrishigadkari;

public class Main {

    public static void main(String[] args) {
	    Fan fan = new Fan("ceiling fan", "havells", "black", new Speed(23, 2, 10));
        Ceiling ceiling = new Ceiling(new Dimensions(23,22,43), "white", "concrete");
        Room room = new Room(fan, ceiling);
        room.getCeiling().getPosition();
        room.turnSwitch();
    }
}
