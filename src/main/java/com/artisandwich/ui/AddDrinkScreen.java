package com.artisandwich.ui;

import com.artisandwich.service.OrderService;

public class AddDrinkScreen {
    public static void display(OrderService service) {
        service.addDrink();
    }
}