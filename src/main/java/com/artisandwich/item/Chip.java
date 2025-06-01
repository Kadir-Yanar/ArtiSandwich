package com.artisandwich.item;

public class Chip {
    private String type;

    public Chip(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getDescription() {
        return "Chips - " + type;
    }
}

