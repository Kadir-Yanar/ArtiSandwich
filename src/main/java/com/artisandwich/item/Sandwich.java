package com.artisandwich.item;

import java.util.List;

import com.artisandwich.interfaces.Bread;
import com.artisandwich.interfaces.Customizable;
import com.artisandwich.interfaces.Price;
import com.artisandwich.interfaces.Receiptable;

public class Sandwich implements Customizable, Receiptable, Price {
    private Integer quantity;
    private Bread bread;
    private List<Topping> toppings;

    public Sandwich(Integer quantity, Bread bread, List<Topping> toppings) {
        this.quantity = quantity;
        this.bread = bread;
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public String generateReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append(bread.getSize()).append("\" ").append(bread.getName()).append("\n");
        for (Topping topping : toppings) {
            sb.append("  - ").append(topping.getName()).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        return sb.toString();
    }

	@Override
	public double getTotalPrice() {
		return quantity * (bread.getTotalPrice() + toppings.stream().map(topping -> topping.getTotalPrice()).reduce(0.0, Double::sum));
	}
}
