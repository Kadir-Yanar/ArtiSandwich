package com.artisandwich.ui;

import com.artisandwich.type.Bread;
import com.artisandwich.item.RyeBread;
import com.artisandwich.item.Sandwich;
import com.artisandwich.item.Topping;
import com.artisandwich.item.WheatBread;
import com.artisandwich.item.WhiteBread;
import com.artisandwich.item.WrapBread;
import com.artisandwich.service.OrderService;

import java.util.*;

public class AddSandwichScreen {
    public static void display(OrderService orderService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Add Sandwich ===");

        System.out.print("Enter quantity: ");
        int quantity = readIntInRange(scanner, 1, 10);

        System.out.println("Select sandwich size:\n4\n8\n12");
        System.out.print("Choice: ");
        int size = readIntInRange(scanner, 4, 12);

        System.out.println("Select bread type:\n1) White\n2) Wheat\n3) Rye\n4) Wrap");
        System.out.print("Choice: ");
        int breadChoice = readIntInRange(scanner, 1, 4);

        Bread bread = switch (breadChoice) {
            case 1 -> new WhiteBread(size);
            case 2 -> new WheatBread(size);
            case 3 -> new RyeBread(size);
            case 4 -> new WrapBread(size);
            default -> null;
        };

        List<Topping> toppings = new ArrayList<>();

        boolean adding = true;
        while (adding) {
            System.out.print("Add topping? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                System.out.println("Available toppings:\n1) Lettuce\n2) Tomato\n3) Onion\n4) Cheese\n5) Meat");
                System.out.print("Choose topping number: ");
                int choice = readIntInRange(scanner, 1, 5);

                Topping topping = null;
                switch (choice) {
                    case 1 -> topping = new Topping("regular", "lettuce", false, size);
                    case 2 -> topping = new Topping("regular", "tomato", false, size);
                    case 3 -> topping = new Topping("regular", "onion", false, size);
                    case 4 -> {
                        String cheese = selectVariant(scanner, "cheese", List.of("american", "provolone", "cheddar", "swiss"));
                        topping = new Topping("cheese", cheese, false, size);
                    }
                    case 5 -> {
                        String meat = selectVariant(scanner, "meat", List.of("steak", "ham", "salami", "roast beef", "chicken", "bacon"));
                        topping = new Topping("meat", meat, false, size);
                    }
                }

                if (topping != null) {
                    boolean exists = toppings.contains(topping);
                    topping.setExtra(exists);
                    toppings.add(topping);
                    System.out.println(topping.getName() + " added.");
                }

            } else if (input.equals("N")) {
                adding = false;
            } else {
                System.out.println("Please enter Y or N.");
            }
        }

        Sandwich sandwich = new Sandwich(quantity, bread, toppings);
        orderService.addSandwich(sandwich);
        System.out.println(quantity + " x " + bread.getName() + " sandwich added to your order.");
    }

    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
                System.out.print("Enter between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    private static String selectVariant(Scanner scanner, String type, List<String> options) {
        System.out.println("Select " + type + " type:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        System.out.print("Choice: ");
        int index = readIntInRange(scanner, 1, options.size());
        return options.get(index - 1);
    }
}
