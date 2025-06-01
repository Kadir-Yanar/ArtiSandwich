package com.artisandwich.service;

import com.artisandwich.item.*;

import java.util.Scanner;

public class OrderService {
    private Order order = new Order();
    private final Scanner scanner = new Scanner(System.in);

    public void addSandwich(Sandwich sandwich) {
        order.addSandwich(sandwich);
    }

    public void addDrink(Drink drink) {
    	order.addDrink(drink);
    }

    public void addChip(Chip chip) {
       order.addChip(chip);
    }

    public void checkout() {
        System.out.println("\n=== Checkout ===");
        System.out.println(order.generateReceiptText());
        System.out.print("Confirm order? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            ReceiptWriter.writeReceipt(order.generateReceiptText());
        } else {
            System.out.println("Order not saved.");
        }
    }
}
