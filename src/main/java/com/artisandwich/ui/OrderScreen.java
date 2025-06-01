package com.artisandwich.ui;

import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class OrderScreen {
    public static void display() {
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== New Order ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> AddSandwichScreen.display(orderService);
                case "2" -> AddDrinkScreen.display(orderService);
                case "3" -> AddChipsScreen.display(orderService);
                case "4" -> {
                    CheckoutScreen.display(orderService);
                    return;
                }
                case "0" -> {
                    System.out.println("Order cancelled. Returning to home.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}