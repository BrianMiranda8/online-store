package org.example.models;

public class Product {
    private String SKU;
    private String name;
    private double price;
    private String Department;


    public Product(String SKU, String name, double price, String department) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        Department = department;
    }



    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return  String.format("%-10s | %-35s | %-20s | %-10.2f  \n",this.getSKU(), this .getName(),this .getDepartment(),this.getPrice());
    }
}
