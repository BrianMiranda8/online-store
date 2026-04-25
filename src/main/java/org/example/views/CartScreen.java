package org.example.views;

import org.example.UI;
import org.example.interfaces.ProductRepository;
import org.example.models.CSVProudctRepository;
import org.example.models.Cart;
import org.example.models.Product;

public class CartScreen {

    public static void getScreen(){
        boolean isLooping = true;
        ProductRepository csvProudctRepository = new CSVProudctRepository();

        while (isLooping){
            IO.println("--------- Add Product To Cart ---------");
            IO.println("Enter SKU to add product to cart");
            IO.println("Enter 'Exit' to go back");
            IO.print("Enter #: ");

            String userInput = UI.getUserInput();

            if (userInput.equalsIgnoreCase("exit")) {
                isLooping = false;
                continue;
            }

            IO.print("Enter Quantity: ");
            String userQuantity = UI.getUserInput();

            Product product = csvProudctRepository.getProductBySku(userInput);

            if (product == null){
                System.out.printf("--------------- \n");
                System.out.printf("%-20s\n", "Item Not Found");
                System.out.printf("--------------- \n");

                System.out.println();

                continue;
            }
            try{
                int quantity = Integer.parseInt(userQuantity);
                Cart.addProduct(product.getSKU(), product, quantity);

            } catch (Exception e) {
                if (e instanceof NumberFormatException){
                    IO.println("Enter valid number for quantity");
                    IO.println("ITEM NOT ADDED!");

                }


            }
        }
    }
}
