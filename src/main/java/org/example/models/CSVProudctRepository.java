package org.example.models;

import org.example.interfaces.ProductRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVProudctRepository implements ProductRepository{
    private static List<Product> products = new ArrayList<>();

    public CSVProudctRepository(){
        try(BufferedReader reader = new BufferedReader(new FileReader("products.csv"))){
            String header = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null){
                String[] lineContent = line.split("\\|");
                products.add(new Product(lineContent[0],lineContent[1], Double.parseDouble(lineContent[2]), lineContent[3]));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : products){
            if (product.getName().contains(name)){
                return product;
            }
        }
        return  null;
    }



    @Override
    public Product getProductBySku(String sku) {
        return null;
    }

    @Override
    public Product getProductByDepartment(String name) {
        return null;
    }

    @Override
    public Product getProductByPrice(double price) {
        return null;
    }

    @Override
    public void updateProduct(String isbn, Product book) {

    }

    @Override
    public List<Product> listProducts() {
        return products;
    }
}
