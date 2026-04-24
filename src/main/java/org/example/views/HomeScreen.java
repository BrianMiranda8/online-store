package org.example.views;

import org.example.UI;

public class HomeScreen {

    public static String getScreen(){
        IO.println("------------------------------------");
        IO.println("----------- Welcome To Sears -------");
        IO.println("1) Display Product \n" +
                "2) Display Cart");
        IO.print("Select Your Option: ");
        return UI.getUserInput();
    }
}
