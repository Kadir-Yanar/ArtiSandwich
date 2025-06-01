package com.artisandwich.item;

import com.artisandwich.interfaces.Receiptable;

import java.util.ArrayList;
import java.util.List;

public class Order implements Receiptable {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public double getTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getTotalPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chip c : chips) total += c.getPrice();
        return total;
    }

    public String generateReceiptText() {
        StringBuilder sb = new StringBuilder("Order Details:\n");
        for (Sandwich s : sandwiches) sb.append(s.generateReceiptText()).append("\n");
        for (Drink d : drinks) sb.append("Drink: ").append(d.getDescription()).append(" - $").append(String.format("%.2f", d.getPrice())).append("\n");
        for (Chip c : chips) sb.append("Chips: ").append(c.getDescription()).append(" - $").append(String.format("%.2f", c.getPrice())).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return sb.toString();
    }
}
