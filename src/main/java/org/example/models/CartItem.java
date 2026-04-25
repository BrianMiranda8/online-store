package org.example.models;
// AI gav
public class CartItem {
    private String sku;
    private Product product;
    private int Quantity;

    public CartItem(String sku, Product product, int quantity) {
        this.sku = sku;
        this.product = product;
        Quantity = quantity;

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotal(){
            return  getQuantity() * this.product.getPrice();

    }

    @Override
    public String toString() {
//todo turn into string formatter
        return "SKU #: " + this.getSku() + " Product: " + this.getProduct().getName() +" $"+this.getProduct().getPrice()+ " X" + this.getQuantity();
    }
}
