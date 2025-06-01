package com.artisandwich.ui;

import com.artisandwich.service.MenuNavigator;
import com.artisandwich.service.OrderService;

import java.util.Scanner;

public class CheckoutScreen {
    private final OrderService orderService;
    private final MenuNavigator menuNavigator;
    private final Scanner scanner = new Scanner(System.in);

    public CheckoutScreen(OrderService orderService, MenuNavigator menuNavigator) {
        this.orderService = orderService;
        this.menuNavigator = menuNavigator;
    }

    public static void display(OrderService orderService) {
    }

    public void show() {
        System.out.println("\n--- Checkout ---");
        orderService.checkout();
        System.out.println("Press Enter to return to Home...");
        scanner.nextLine();
        menuNavigator.;
    }
}