package com.artisandwich.service;

import com.artisandwich.item.*;

import java.util.Scanner;

public class OrderService {
    private Order order = new Order();
    private final Scanner scanner = new Scanner(System.in);

    public void addSandwich() {
        System.out.print("Enter sandwich size (4, 8, 12): ");
        String size = scanner.nextLine();
        System.out.print("Choose bread (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();
        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        while (true) {
            System.out.print("Add topping (or 'done'): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Type (regular, meat, cheese): ");
            String type = scanner.nextLine();
            System.out.print("Extra? (yes/no): ");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

            sandwich.addTopping(new Topping(name, type, isExtra));
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added.");
    }

    public void addDrink() {
        System.out.print("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine();
        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();
        order.addDrink(new Drink(size, flavor));
        System.out.println("Drink added.");
    }

    public void addChips() {
        System.out.print("Enter chip type: ");
        String type = scanner.nextLine();
        order.addChips(new Chip(type));
        System.out.println("Chips added.");
    }

    public void checkout() {
        System.out.println("\n=== Checkout ===");
        System.out.println(order.generateReceiptText());
        System.out.print("Confirm order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            ReceiptWriter.writeReceipt(order.generateReceiptText());
        } else {
            System.out.println("Order not saved.");
        }
    }
}
