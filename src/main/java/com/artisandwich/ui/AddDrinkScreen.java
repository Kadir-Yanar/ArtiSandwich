package com.artisandwich.ui;

import com.artisandwich.item.Drink;
import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class AddDrinkScreen {
    public static void display(OrderService service) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Add Drink ===");

        System.out.println("Choose drink size:");
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large ($3.00)");
        System.out.print("Choice: ");
        String sizeChoice = scanner.nextLine();

        String size;
        switch (sizeChoice) {
            case "1" -> size = "Small";
            case "2" -> size = "Medium";
            case "3" -> size = "Large";
            default -> {
                System.out.println("Invalid size. Returning to order screen.");
                return;
            }
        }

        System.out.println("Choose drink flavor:");
        System.out.println("1) Cola");
        System.out.println("2) Lemonade");
        System.out.println("3) Water");
        System.out.print("Choice: ");
        String flavorChoice = scanner.nextLine();

        String flavor;
        switch (flavorChoice) {
            case "1" -> flavor = "Cola";
            case "2" -> flavor = "Lemonade";
            case "3" -> flavor = "Water";
            default -> {
                System.out.println("Invalid flavor. Returning to order screen.");
                return;
            }
        }

        service.addDrink(new Drink(size, flavor));
        System.out.println(size + " " + flavor + " added to your order.");
    }
}
