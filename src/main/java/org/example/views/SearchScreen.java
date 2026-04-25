package org.example.views;

import org.example.UI;
import org.example.models.CSVProudctRepository;
import org.example.models.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchScreen {
    static ArrayList<Product> searchedProducts = new ArrayList<>();
   public static void getScreen(){
       CSVProudctRepository csvProudctRepository = new CSVProudctRepository();

       boolean onFlag = true;
       while (onFlag) {
           IO.println("-------------------------");
           IO.println("Type Exit to go back");
           IO.print("Search For Product By \n" +
                   "1) Name \n"+
                   "2) Department \n" +
                   "3) Price \n");
           IO.print("Make Selection: ");
           String userInput = UI.getUserInput();

           if (userInput.equals("exit")){
               onFlag = false;
           }else{
            switch (userInput){
                case "1" -> searchViaName( csvProudctRepository.listProducts());
                case "2" -> searchViaDepartment( csvProudctRepository.listProducts());
                case "3" -> searchViaPrice(csvProudctRepository.listProducts());
            }
           }

       }
    }

    private static void searchViaPrice( List<Product> products) {
        IO.println("-------------- Price Search ----------------");
        IO.println();
        IO.print("Type Your Search: ");
        String userInput = UI.getUserInput();

        try{

        for (Product product : products) {
            if (product.getPrice() <= Double.parseDouble(userInput)) {
                searchedProducts.add(product);
            }
        }


        if (searchedProducts.isEmpty())
            IO.println("No items found");
        else
            for (Product product : searchedProducts){
                IO.println(product);
            }


        IO.println(searchedProducts.size()+" Items Found @ or less than \"$"+ userInput + "\" ");
        IO.println("Press enter to continue");
        searchedProducts.clear();
        UI.getUserInput();
        } catch (NumberFormatException e) {
            IO.println("Enter valid number");
        }

    }

    // this is gross ik
    private static void searchViaDepartment( List<Product> products) {
        IO.println();
        IO.println();
        IO.println("=================== Search Via Department =======================");

        HashSet<String> departments = new HashSet<>();

       for (Product product : products){
           if (!departments.contains(product.getDepartment().toLowerCase())){
               departments.add(product.getDepartment().toLowerCase());
           }
       }


       for (String department: departments){
           IO.print(department.toUpperCase() +  ", ");
       }
        IO.println("Available Departments: ");
        IO.print("Enter Search: ");
        String userInput = UI.getUserInput();

        for (Product product : products) {
            if (product.getDepartment().toLowerCase().contains(userInput)) {
                searchedProducts.add(product);
            }
        }


        if (searchedProducts.isEmpty())
            IO.println("No items found");
        else
            for (Product product : searchedProducts){
                IO.println(product);
            }


        IO.println(searchedProducts.size()+" Items Found With \""+ userInput + "\" ");

        searchedProducts.clear();

        IO.println();
        IO.println("Press Enter To Continue: ");
        UI.getUserInput();
    }

    private static void searchViaName( List<Product> products ) {
        IO.println("-------------- Name Search ----------------");
        IO.println();
        IO.print("Type Your Search: ");
        String userInput = UI.getUserInput();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(userInput)) {
                searchedProducts.add(product);
            }
        }


        if (searchedProducts.isEmpty())
            IO.println("No items found");
        else
            for (Product product : searchedProducts){
                IO.println(product);
            }


        IO.println(searchedProducts.size()+" Items Found With \""+ userInput + "\" ");
        IO.println("Press enter to continue");
        searchedProducts.clear();
        UI.getUserInput();
    }

    private static void displayProduct(){
       for (Product product : searchedProducts){
           IO.println(product.toString());
       }
    }
}
