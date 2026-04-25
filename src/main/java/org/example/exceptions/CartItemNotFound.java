package org.example.exceptions;

public class CartItemNotFound extends RuntimeException {
    public CartItemNotFound(String message) {
        super(message);
    }
}
