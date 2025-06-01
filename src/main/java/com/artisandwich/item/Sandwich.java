package com.artisandwich.item;

import com.artisandwich.interfaces.Customizable;
import com.artisandwich.interfaces.Receiptable;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Customizable, Receiptable {
    protected String size;
    protected String bread;
    protected boolean toasted;
    protected List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public double getBasePrice() {
        return switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0.0;
        };
    }

    public double getTotalPrice() {
        return getBasePrice() + toppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
    }

    public String generateReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(bread).append(toasted ? " (Toasted)\n" : "\n");
        for (Topping topping : toppings) {
            sb.append("  - ").append(topping.getName()).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        return sb.toString();
    }
}
