package com.artisandwich.item;

import com.artisandwich.interfaces.Price;

public class Topping implements Price {
    private String type;      // meat, cheese, regular
    private String variant;   // steak, cheddar, lettuce
    private boolean isExtra;
    private int size;         // 4, 8, 12

    public Topping(String type, String variant, boolean isExtra, int size) {
        this.type = type;
        this.variant = variant;
        this.isExtra = isExtra;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getVariant() {
        return variant;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getName() {
        return variant + (isExtra ? " (extra)" : "");
    }

    @Override
    public double getTotalPrice() {
        switch (type) {
            case "meat" -> {
                return switch (size) {
                    case 4 -> isExtra ? 0.50 : 1.00;
                    case 8 -> isExtra ? 1.00 : 2.00;
                    case 12 -> isExtra ? 1.50 : 3.00;
                    default -> 0.0;
                };
            }
            case "cheese" -> {
                return switch (size) {
                    case 4 -> isExtra ? 0.30 : 0.75;
                    case 8 -> isExtra ? 0.60 : 1.50;
                    case 12 -> isExtra ? 0.90 : 2.25;
                    default -> 0.0;
                };
            }
            default -> { return 0.0; }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Topping other) {
            return this.type.equals(other.type) && this.variant.equals(other.variant) && this.size == other.size;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return type.hashCode() + variant.hashCode() + size;
    }
}