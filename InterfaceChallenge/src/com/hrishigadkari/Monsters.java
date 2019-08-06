package com.hrishigadkari;

import java.util.ArrayList;
import java.util.List;

public class Monsters implements Saveable{
    private String name;
    private int health;

    public Monsters(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void read(List<String> readValues){
        if(readValues != null && readValues.size() > 0){
            this.name = readValues.get(0);
            this.health = Integer.parseInt(readValues.get(1));
        }
    }

    @Override
    public List<String> write(){
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.health);
        return values;
    }

    @Override
    public String toString() {
        return "Monsters{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
