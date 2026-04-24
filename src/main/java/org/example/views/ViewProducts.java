package org.example.views;

import org.example.UI;
import org.example.models.CSVProudctRepository;
import org.example.models.Product;

import java.util.List;

public class ViewProducts {
    public static void getScreen(){
        boolean loopFlag = true;
        IO.println();
        IO.println();

        IO.println("==================== Display Products Window ====================");
        while (loopFlag){
            IO.println("1) Search Products \n" +
                    "2) Add Product To Cart \n" +
                    "3) Home Screen \n");

            IO.print("Select Your Option: ");
            String userInput = UI.getUserInput();

            switch (userInput){

                case "1" -> SearchScreen.getScreen();
                case "2"-> CartScreen.getScreen();

                default -> loopFlag = false;
            }

        }
    }

}
