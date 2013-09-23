/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author LPM
 */
public class OrderBuilder {

    private String[] orderItems;
    private double total;

    public OrderBuilder(String[] orderItems) {
        this.orderItems = orderItems;

    }

    public ArrayList<ArrayList> getInvoiceItems() {
        ArrayList<ArrayList> ii = new ArrayList<>();
        for (int i = 0; i < orderItems.length; i++) {

            int id = Integer.parseInt(orderItems[i]);

            MenuService ms = new MenuService();
            ii.add(ms.getOneMenuItem(id));

            incrementOrderTotal((double) ms.getOneMenuItem(id).get(3));

        }

        return ii;
    }

    public void incrementOrderTotal(double unitPrice) {
        total = total + unitPrice;

    }

    public String getOrderTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(total);
        return formattedTotal;
    }
}
