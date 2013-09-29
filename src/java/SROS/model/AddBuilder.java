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
public class AddBuilder {
    
    private final String ADD = "ADD";
    private final String CHANGE = "CHANGE"; 
    private final String DELETE = "DELETE";

//    private String[] xrefRows;
//    private String radiocd;
//    private String dbpkey;
    private String desc;
    private String um;
    private String price;

    public AddBuilder(String desc, String um, String price) {
//        this.xrefRows = xrefRows;        
//        this.radiocd = radiocd;
//        this.dbpkey = dbpkey;
        this.desc = desc;
        this.um = um;
        this.price = price;        
    }

    public void setAdd() {
//        getViewRow();
//        int intSubmitRow = Integer.parseInt(submitrow);
        String colItemDesc = desc;
        System.out.println("colItemDesc " + colItemDesc);
        String colUnitOfMeasure = um;
        System.out.println("colUnitOfMeasure " + colUnitOfMeasure);
        Double colUnitPrice = Double.parseDouble(price);
        System.out.println("colUnitPrice " + colUnitPrice);
        MenuService ms = new MenuService();
        ms.insertOneMenuItem(colItemDesc, colUnitOfMeasure, colUnitPrice);
    }

    
}