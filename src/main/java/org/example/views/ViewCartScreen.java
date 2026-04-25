package org.example.views;

import org.example.UI;
import org.example.models.Cart;
import org.example.models.CartItem;

public class ViewCartScreen {
    public static void getScreen(){
        IO.println("--------------- Display Cart View -------------------");
        boolean isLooping = true;

        while (isLooping ){
            if (Cart.viewCart().isEmpty()){
                IO.println("No items in cart");
                IO.println("buy something to continue");

                isLooping = false;
                continue;


            }
            displayCartContent();
            IO.println("1) Check Out \n" +
                    "2) Remove Product \n" +
                    "3) Go Back \n");
            IO.print("Enter Selection: ");

            String userInput = UI.getUserInput();

            switch (userInput){
                case "1" -> CheckOutScreen.getScreen();
                case "2" -> RemoveProdcutScreen.getScreen();
                case "3" -> isLooping = false;

            }
        }
    }

    private static void displayCartContent(){
        for (CartItem cartItem : Cart.viewCart()) {
            IO.println(cartItem);
        }
        System.out.printf("Total $%-20.2f \n",Cart.totalCart());
    }
}
