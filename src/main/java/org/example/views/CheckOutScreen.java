package org.example.views;

import org.example.UI;
import org.example.models.Cart;
import org.example.models.Receipt;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckOutScreen {
    public static void getScreen() {
        boolean isLooping = true;

//TODO: empty cart dont let them move foward
        while (isLooping){

            IO.println("\n\n\n--------------------- Checkout Cart Screen -----------------------");
            System.out.printf("Your Total is: $%-10.2f %n", Cart.totalCart());
            IO.println("Enter your total with the following format xx.xx ");
            IO.print("Enter Total: ");
            try{
                double userInput = Double.parseDouble(UI.getUserInput());
                if (userInput < Cart.totalCart()){
                    IO.println("INSUFFICIENT FUNDS");
                    continue;
                }
                Receipt receipt = new Receipt(userInput,Cart.totalCart(), Cart.viewCart());
                IO.println(receipt.printReceipt());
                IO.println("\n\n\n\n\n");
                IO.println("Thank You for Shopping With Us!");
                isLooping = false;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
