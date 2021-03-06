package com.boot.simpledb.service;

import com.boot.simpledb.model.ShoppingCart;
import com.boot.simpledb.model.ShoppingCartItem;

public interface ShoppingCartService {
    ShoppingCart fetchShoppingCartItemsByUserId(Long userId);
    ShoppingCartItem addItem(ShoppingCartItem shoppingCartItem);
}
