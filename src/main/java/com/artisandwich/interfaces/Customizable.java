package com.artisandwich.interfaces;

import com.artisandwich.item.Topping;


public interface Customizable {
    void addTopping(Topping topping);
    void removeTopping(Topping topping);
}