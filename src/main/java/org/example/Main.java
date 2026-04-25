package org.example;

import org.example.views.CartScreen;
import org.example.views.HomeScreen;
import org.example.views.ViewCartScreen;
import org.example.views.ViewProducts;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

            while (true) {

                String userOption = HomeScreen.getScreen();

                switch (userOption) {
                    case "1":
                        ViewProducts.getScreen();
                        break;
                    case "2":
                        ViewCartScreen.getScreen();
                    break;
                    default:
                        IO.println("Goodbye !");
                        break;
                }
            }
    }
}
