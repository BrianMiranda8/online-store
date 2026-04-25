package org.example.models;

import org.example.exceptions.CartItemNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * As I read more about OOP,
 * I’ve come to realize that this class is problematic.
 * If it weren't static, I could reuse it for a wishlist, a save-for-later cart, or other cart types;
 * however, because it uses a static array to hold items, I’m locked into a single instance.
 *
 * A better approach would be to pass the cart instance from screen to screen—a concept known as
 * 'Dependency Injection.' I initially hesitated to do this because
 * I thought it might be difficult to track where the cart object originated,
 * but I’ve realized that a static class isn't any easier to manage in the long run.
 *
 * This approach is easier for this project because static arrays stay in memory until the end of the program which
 * means I can jump from window to window without worrying about the cart
 *
 *
 */

public class Cart {

    // keeping this here as a learning moment
    // while talking to gemini about iterating over a complex list like this
    // I learned that its better to create an object that represents the inner hashmap
    // because keys have meaning and i can add more variables to the class ie
    // discount total quantity
    // class object take less memory than hashmaps and its easier to iterate through
//    private List<HashMap<String,Product>> cart = new ArrayList<>();

    static private List<CartItem> cartItems = new ArrayList<>();


    static public void addProduct(String sku, Product product) {
        if (cartItems.isEmpty()) {
            cartItems.add(new CartItem(sku, product, 1));
            return;
        }

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getSKU().equals(sku)) {
                int cartItemQuantity = cartItem.getQuantity();
                cartItem.setQuantity(cartItemQuantity + 1);
                return;
            }
        }

        cartItems.add(new CartItem(sku, product, 1));


    }

    static public void addProduct(String sku, Product product, int quantity) {
        if (cartItems.isEmpty()) {
            cartItems.add(new CartItem(sku, product, quantity));
            return;
        }

        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getSKU().equals(sku)) {
                int cartItemQuantity = cartItem.getQuantity() + quantity;
                cartItem.setQuantity(cartItemQuantity );
                return;
            }
        }

        cartItems.add(new CartItem(sku, product, quantity));


    }

    static public void removeFromCart(String sku) {
        if (cartItems.isEmpty()) {
            throw new CartItemNotFound(sku + " does not exist in cart");
        }

        // this is gross
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            // we have more than 1 item lets not remove item from list
            // lets just reduce its quantity
            if (cartItem.getSku().equals(sku)) {
                if (cartItem.getQuantity() > 1) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                } else if (cartItem.getQuantity() <= 1) {
                    cartItems.remove(i);
                }
                return;
            }
        }
    }
    static public void removeFromCart(String sku,int quantity) {
        if (cartItems.isEmpty()) {
            throw new CartItemNotFound(sku + " does not exist in cart");
        }

        // this is gross
        //
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            // we have more than 1 item lets not remove item from list
            // lets just reduce its quantity
            if (cartItem.getSku().equalsIgnoreCase(sku)) {
                cartItem.setQuantity(cartItem.getQuantity() - quantity);
               if (cartItem.getQuantity() < 1) {
                    cartItems.remove(i);
                }
                return;
            }
        }
        throw new CartItemNotFound("sku does not exist in cart");
    }
    static public double totalCart() {
        double grandTotal = 0;

        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotal();
        }
        return grandTotal;
    }
    static public void clearCart(){
        cartItems.clear();
    }
    public static List<CartItem> viewCart() {
        return cartItems;
    }
}
