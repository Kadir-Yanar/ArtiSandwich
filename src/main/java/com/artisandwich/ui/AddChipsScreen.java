package com.artisandwich.ui;

import com.artisandwich.item.Chip;
import com.artisandwich.service.OrderService;

import java.util.Scanner;



import com.artisandwich.item.Chip;
import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class AddChipsScreen {
    public static void display(OrderService orderService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Add Chips ===");
        System.out.println("Choose chip type:");
        System.out.println("1) Doritos");
        System.out.println("2) Lays");
        System.out.println("3) Tortilla");
        System.out.println("4) Cheetos");
        System.out.print("Choice: ");

        String type;
        switch (scanner.nextLine()) {
            case "1" -> type = "Doritos";
            case "2" -> type = "Lays";
            case "3" -> type = "Tortilla";
            case "4" -> type = "Cheetos";
            default -> {
                System.out.println("Invalid option. Returning to order screen.");
                return;
            }
        }

        orderService.addChip(new Chip(type));
        System.out.println(type + " chips added to your order.");
    }
}

