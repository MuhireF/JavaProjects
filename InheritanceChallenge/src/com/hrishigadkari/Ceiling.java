package com.hrishigadkari;

public class Ceiling {
    private Dimensions dimension;
    private String color;
    private String type;

    public Ceiling(Dimensions dimension, String color, String type) {
        this.dimension = dimension;
        this.color = color;
        this.type = type;
    }

    public void getPosition(){
        System.out.println("The ceiling is at position:" + dimension.getHeight() + ", " + dimension.getWidth());
    }

    public Dimensions getDimension() {
        return dimension;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
