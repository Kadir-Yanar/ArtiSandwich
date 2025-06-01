package com.artisandwich.ui;

import com.artisandwich.service.OrderService;

public class AddChipsScreen {
    public static void display(OrderService orderService) {
        orderService.addChips();
    }
}
