package com.artisandwich.ui;

import java.util.Scanner;

public class HomeScreen {
    public static void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== DELI-cious - Home ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> OrderScreen.display();
                case "0" -> {
                    System.out.println("Exiting application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}