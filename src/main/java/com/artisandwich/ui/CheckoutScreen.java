package com.artisandwich.ui;

import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class CheckoutScreen {

    public static void display(OrderService orderService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Checkout ---");
        orderService.checkout();
        System.out.println("Press Enter to return to Home...");
        scanner.nextLine();
    }
}