package com.artisandwich.ui;

import com.artisandwich.item.Sandwich;
import com.artisandwich.item.Topping;
import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class AddSandwichScreen {

    public static void display(OrderService orderService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Add Sandwich ===");

        // Sandwich tipi seçimi
        System.out.println("Select sandwich type:");
        System.out.println("1) Classic Ham");
        System.out.println("2) Turkey");
        System.out.println("3) Veggie");
        System.out.print("Choice: ");
        int typeChoice = readIntInRange(scanner, 1, 3);

        String sandwichType = switch (typeChoice) {
            case 1 -> "";
            case 2 -> "Meat";
            case 3 -> "Cheese";
            default -> "Regular";
        };

        // Miktar seçimi
        System.out.print("Enter quantity: ");
        int quantity = readIntInRange(scanner, 1, 10);

        // Sandwich oluştur
        Sandwich sandwich = new Sandwich()

        // Topping ekleme
        boolean addMoreToppings = true;
        while (addMoreToppings) {
            System.out.print("Add topping? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                System.out.println("Available toppings:");
                System.out.println("1) Lettuce");
                System.out.println("2) Tomato");
                System.out.println("3) Cheese");
                System.out.println("4) Onion");
                System.out.print("Choose topping number: ");
                int toppingChoice = readIntInRange(scanner, 1, 4);

                Topping topping = switch (toppingChoice) {
                    case 1 -> new topping("Lettuce");
                    case 2 -> new topping("Tomato");
                    case 3 -> new Topping("Cheese");
                    case 4 -> new Topping("Onion");
                    default -> null;
                };

                if (topping != null) {
                    sandwich.addTopping(topping);
                    System.out.println(topping.getName() + " added.");
                }
            } else if (input.equals("N")) {
                addMoreToppings = false;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }

        // Siparişe ekle
        orderService.addSandwich(sandwich, quantity);
        System.out.println(quantity + " x " + sandwichType + " sandwich added to your order.");
    }

    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            try {
                String line = scanner.nextLine();
                int input = Integer.parseInt(line);
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}