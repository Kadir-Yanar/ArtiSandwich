package com.artisandwich.ui;

import com.artisandwich.interfaces.Bread;
import com.artisandwich.item.RyeBread;
import com.artisandwich.item.Sandwich;
import com.artisandwich.item.Topping;
import com.artisandwich.item.WheatBread;
import com.artisandwich.item.WhiteBread;
import com.artisandwich.item.WrapBread;
import com.artisandwich.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddSandwichScreen {

    public static void display(OrderService orderService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Add Sandwich ===");

        // Miktar seçimi
        System.out.print("Enter quantity: ");
        int quantityChoice = readIntInRange(scanner, 1, 10);

        // Sandwich tipi seçimi
        System.out.println("Select sandwich size:");
        System.out.println("4");
        System.out.println("8");
        System.out.println("12");
        System.out.print("Choice: ");
        int sizeChoice = readIntInRange(scanner, 4, 12);

     // Chose Sandwich bread Type
        System.out.println("Select bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Choice: ");
        int breadChoice = readIntInRange(scanner, 1, 4);

        Bread bread = switch (breadChoice) {
        case 1 -> new WhiteBread(sizeChoice);
        case 2 -> new WheatBread(sizeChoice);
        case 3 -> new RyeBread(sizeChoice);
        case 4 -> new WrapBread(sizeChoice);
        default -> null;
    };

        // Adding Topping
        List<Topping> toppingChoices = new ArrayList();
        boolean addMoreToppings = true;
        while (addMoreToppings) {
            System.out.print("Add topping? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                System.out.println("Available toppings:");
                System.out.println("1) Lettuce");
                System.out.println("2) Tomato");
                System.out.println("3) Onion");
                System.out.println("4) Cheese");
                System.out.println("5) Meat");
                System.out.print("Choose topping number: ");
                int toppingChoice = readIntInRange(scanner, 1, 5);

                Topping topping = switch (toppingChoice) {
                    case 1 -> new Topping("lettuce", false);
                    case 2 -> new Topping("tomato",  false);
                    case 3 -> new Topping("tomato",  false);
                    case 4 -> new Topping("cheese",  false);
                    case 5 -> new Topping("meat",  false);
                    default -> null;
                };



                boolean isAlreadyExist = toppingChoices.contains(topping);
                topping.setExtra(isAlreadyExist);

                if (topping != null) {
                	toppingChoices.add(topping);
                    System.out.println(topping.getName() + " added.");
                }
            } else if (input.equals("N")) {
                addMoreToppings = false;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }

        Sandwich sandwich = new Sandwich(quantityChoice, bread, toppingChoices);

        // Add into Order
        orderService.addSandwich(sandwich);
        System.out.println(quantityChoice + " x " + bread.getName() + " sandwich added to your order.");
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