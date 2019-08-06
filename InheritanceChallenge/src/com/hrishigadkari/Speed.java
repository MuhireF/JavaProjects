package com.hrishigadkari;

public class Speed {
    private int distance;
    private int time;
    private int length;

    public Speed(int distance, int time, int length) {
        this.distance = distance;
        this.time = time;
        this.length = length;
    }

    public int getSpeed(){
        return (distance/time)*length;
    }
}
