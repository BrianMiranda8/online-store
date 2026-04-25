package org.example.views;

import org.example.UI;
import org.example.exceptions.CartItemNotFound;
import org.example.models.Cart;
import org.example.models.CartItem;

public class RemoveProdcutScreen {
    public static void getScreen() {
        boolean isLooping = true;

        while (isLooping) {

            IO.println("================== Remove Product ===============");
            IO.println("Remove by entering sku and amount to remove");
            IO.println("Enter 'exit' to go back");

            for (CartItem cartItem: Cart.viewCart()){
                IO.println(cartItem);
            }

            IO.print("Enter SKU: ");
            String userInput = UI.getUserInput();
            if (userInput.equalsIgnoreCase("exit")){
                isLooping = false;
            }
            IO.println();
            IO.print("Enter Quantity: ");
            String quantityToRemove = UI.getUserInput();

            try {
                Cart.removeFromCart(userInput, Integer.parseInt(quantityToRemove));
                IO.println("Item Removed");
            } catch (NumberFormatException e) {
                IO.println("Item not delete enter valid quantity digit");
            } catch (CartItemNotFound e) {
                IO.println("Invalid sku number try again. Item not deleted");
            }
        }
    }
}
