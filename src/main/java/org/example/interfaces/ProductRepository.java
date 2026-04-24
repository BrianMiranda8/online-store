package org.example.interfaces;

import org.example.models.Product;

import java.util.List;

public interface ProductRepository {


    void addProduct(Product product);
    Product getProductByName (String name);
    Product getProductBySku(String sku);
    Product getProductByDepartment(String name);
    Product getProductByPrice(double price);
    void updateProduct(String isbn, Product book);
    List<Product> listProducts();
}
