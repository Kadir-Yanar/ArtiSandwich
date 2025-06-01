package com.artisandwich.service;


import com.artisandwich.ui.HomeScreen;

public class MenuNavigator {
    private final OrderService orderService;

    public MenuNavigator(OrderService orderService) {
        this.orderService = orderService;
    }

    public void goToHome() {

        HomeScreen.display();
    }
}
