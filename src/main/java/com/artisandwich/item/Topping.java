package com.artisandwich.item;

public class Topping {
    private String name;
    private String type; // regular, meat, cheese
    private boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type.toLowerCase();
        this.isExtra = isExtra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public double getPrice(String size) {
        return switch (type) {
            case "meat" -> switch (size) {
                case "4" -> 1.00 + (isExtra ? 0.50 : 0);
                case "8" -> 2.00 + (isExtra ? 1.00 : 0);
                case "12" -> 3.00 + (isExtra ? 1.50 : 0);
                default -> 0.0;
            };
            case "cheese" -> switch (size) {
                case "4" -> 0.75 + (isExtra ? 0.30 : 0);
                case "8" -> 1.50 + (isExtra ? 0.60 : 0);
                case "12" -> 2.25 + (isExtra ? 0.90 : 0);
                default -> 0.0;
            };
            default -> 0.0;
        };
    }

    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }
}
