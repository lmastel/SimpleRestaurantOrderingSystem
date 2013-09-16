/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.text.NumberFormat;
import java.util.TreeMap;

/**
 *
 * @author LPM
 */
public class OrderBuilder {

    //private String[] menuItems = {"Cheese", "Pepperoni", "Sausage", "Chicken"};
    //private String[] menuPrices = {"10.00", "15.00", "20.00"};
    private Double[] menuPrices = {10.00, 15.00, 20.00, 17.00};
    private String pricedItem[] = {" ", " ", " ", " "};
    private String[] orderItems;
    private int results;
    private TreeMap<String, Double> menuItems = new TreeMap<>();
    private TreeMap<String, String> invoiceItems = new TreeMap<>();
    private double total;

    public OrderBuilder(String[] orderItems) {
        this.orderItems = orderItems;
        menuItems.put("01 Cheese Pizza", 10.00);
        menuItems.put("02 Pepperoni Pizza", 12.00);
        menuItems.put("03 Sausage Pizza", 13.00);
        menuItems.put("04 Veggie Pizza", 11.00);
        menuItems.put("05 BBQ Chicken Pizza", 13.00);
        menuItems.put("06 Hawiian Pizza", 14.00);
        menuItems.put("07 Mexican Pizza", 14.00);
        menuItems.put("08 Margherita Pizza", 14.00);
        menuItems.put("09 Extra Cheese", 2.50);
        menuItems.put("10 Extra Pepperoni", 2.50);
        menuItems.put("11 Extra Sausage", 2.75);
        menuItems.put("12 Onions", 1.00);
        menuItems.put("13 Black Olives", 1.50);
        menuItems.put("14 Peppers", 1.75);
        menuItems.put("15 Mushrooms", 1.75);  
        menuItems.put("16 Garlic Bread", 4.00); 
        menuItems.put("17 Soda", 3.50); 
        menuItems.put("18 Beer", 5.25);         
    }

    public TreeMap<String, String> getInvoiceItems() {
        for (int i = 0; i < orderItems.length; i++) {
            double unitPrice = menuItems.get(orderItems[i]);
            
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String formattedUnitPrice = currency.format(unitPrice);

            invoiceItems.put(orderItems[i], formattedUnitPrice);

            incrementOrderTotal(unitPrice);

        }

        return invoiceItems;

    }

    public void incrementOrderTotal(double unitPrice) {
        System.out.println("method incrementOrderTotal " + unitPrice);
        total = total + unitPrice;
        System.out.println("method incrementOrderTotal " + total);

    }

    public String getOrderTotal() {
        System.out.println("method getOrderTotal " + total);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(total);
        return formattedTotal;
    }
}
