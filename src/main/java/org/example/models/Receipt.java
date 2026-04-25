package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Receipt {
    private double amountGiven;
    private List<CartItem> cartItems;
    private double total ;
    public Receipt(double amountGiven,double total, List<CartItem> cartItems) {
        this.amountGiven = amountGiven;
        this.cartItems = cartItems;
        this.total = total;
    }

    public double getAmountGiven() {
        return amountGiven;
    }

    public void setAmountGiven(double amountGiven) {
        this.amountGiven = amountGiven;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    //todo: military time or add am / pm
    public String printReceipt(){

        StringBuilder receipt = new StringBuilder();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        String timeOfCheckout = String.format("%d:%d", now.getHour(), now.getMinute());
        String dateOfCheckout = String.format("%d/%d/%d",today.getMonth().getValue(),today.getDayOfMonth(),today.getYear());
        String header = String.format("%-10s Date:%-10s %-5s \n", "Receipt", dateOfCheckout, timeOfCheckout);
        receipt.append(header);
        receipt.append("--------------------");
        receipt.append("-------------------- \n");

        for (CartItem cartItem : cartItems){
            receipt.append(cartItem).append("\n");
        }

        receipt.append(String.format("%-10s %-20.2f\n", "Total Amount", total));
        receipt.append("\n");
        receipt.append("\n");
        receipt.append("\n");
        receipt.append("\n");

        receipt.append(String.format("%-10s %-20.2f\n","Paid", amountGiven ));
        receipt.append(String.format("%-10s %-20.2f\n","Change", amountGiven - total ));

        return  receipt.toString();
    }
}
