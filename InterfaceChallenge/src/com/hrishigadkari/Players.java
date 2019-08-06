package com.hrishigadkari;

import java.util.ArrayList;
import java.util.List;

public class Players implements Saveable{
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Players(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Arrows";
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0){
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }

    @Override
    public List<String> write() {
        List<String> savedValues = new ArrayList<String>();
        savedValues.add(0, this.name);
        savedValues.add(1, "" + this.hitPoints);
        savedValues.add(2, "" + this.strength);
        savedValues.add(3, this.weapon);
        return savedValues;
    }
}
