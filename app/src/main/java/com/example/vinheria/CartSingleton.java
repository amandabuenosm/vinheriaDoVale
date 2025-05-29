package com.example.vinheria;

import com.example.vinheria.models.Product;

import java.util.ArrayList;

public class CartSingleton {

    private static CartSingleton instance;
    private ArrayList<Product> items;

    private CartSingleton() {
        items = new ArrayList<>();
    }

    public static CartSingleton getInstance() {
        if (instance == null) {
            instance = new CartSingleton();
        }
        return instance;
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }
}
