/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author LPM
 */
public class OrderBuilder {

    private String[] orderItems;
    private ArrayList<ArrayList> invoiceItems;
    private double total;

    public OrderBuilder(String[] orderItems) {
        this.invoiceItems = new ArrayList<>();
        this.orderItems = orderItems;
        System.out.println("OrderBuilder orderItems =" + this.orderItems[0]);
    }

    public ArrayList<ArrayList> getInvoiceItems() {
        ArrayList<ArrayList> ii = new ArrayList<>();
        for (int i = 0; i < orderItems.length; i++) {

            int id = Integer.parseInt(orderItems[i]);
            System.out.println("OrderBuilder getInvoiceItems int id=" + id);

            MenuService ms = new MenuService();      
            
            //ii = ms.getOneMenuItem(id);
            ii.add(ms.getOneMenuItem(id));
            
            incrementOrderTotal((double) ms.getOneMenuItem(id).get(3));
            
        }

        return ii;
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
    
    public static void main(String[] args) {
        String[] oi = new String[1];
        oi[0] = "1";
        OrderBuilder ob = new OrderBuilder(oi);
        System.out.println("ob.getInvoiceItems()" + ob.getInvoiceItems());
    }
}
