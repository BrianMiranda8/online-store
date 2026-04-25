package org.example;

import org.example.views.CartScreen;
import org.example.views.HomeScreen;
import org.example.views.ViewCartScreen;
import org.example.views.ViewProducts;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
            boolean isLooping = true;
            while (isLooping) {

                String userOption = HomeScreen.getScreen();

                switch (userOption) {
                    case "1" -> ViewProducts.getScreen();

                    case "2" -> ViewCartScreen.getScreen();

                    case "3" -> isLooping = false;
                    default -> IO.println("Invalid Input !");

                }
            }
    }
}
