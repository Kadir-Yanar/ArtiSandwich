package com.artisandwich.item;

import com.artisandwich.interfaces.Price;

public class Topping implements Price {
    private String name;
    private boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

	@Override
	public double getTotalPrice() {
		return switch (name) {

            case "cheese" -> 1.00 + (isExtra ? 0.50 : 0);
            case "meat" -> 2.00 + (isExtra ? 1.00 : 0);
            default -> 0.0;
    };
	}
}
