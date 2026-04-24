package org.example;

import java.util.Scanner;

public class UI {
    static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(){
        String userInput = scanner.nextLine().strip().toLowerCase();
        return userInput;
    }

}
