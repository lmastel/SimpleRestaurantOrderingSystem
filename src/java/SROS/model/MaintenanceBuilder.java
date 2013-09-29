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
public class MaintenanceBuilder {
    
    private final String ADD = "ADD";
    private final String CHANGE = "CHANGE"; 
    private final String DELETE = "DELETE";

    private String[] xrefRows;
    private String radiocd;
    private String dbpkey;
    private String[] descs;
    private String[] ums;
    private String[] prices;

    public MaintenanceBuilder(String[] xrefRows, String radiocd, String dbpkey,
            String[] descs, String[] ums, String[] prices) {
        this.xrefRows = xrefRows;        
        this.radiocd = radiocd;
        this.dbpkey = dbpkey;
        this.descs = descs;
        this.ums = ums;
        this.prices = prices;
        setChangeOrDelete();
    }

    public String setChangeOrDelete() {
        if (radiocd.equals(CHANGE)) {
            setChange();
        } else if (radiocd.equals(DELETE)) {
            setDelete();
        }
        return null;
    }

    public void setChange() {
        getViewRow();
//        int intSubmitRow = Integer.parseInt(submitrow);
        String colItemDesc = descs[getViewRow()];
        System.out.println("colItemDesc " + colItemDesc);
        String colUnitOfMeasure = ums[getViewRow()];
        System.out.println("colUnitOfMeasure " + colUnitOfMeasure);
        Double colUnitPrice = Double.parseDouble(prices[getViewRow()]);
        System.out.println("colUnitPrice " + colUnitPrice);
        MenuService ms = new MenuService();
        ms.updateOneMenuItem(Integer.parseInt(dbpkey), colItemDesc, 
                colUnitOfMeasure, colUnitPrice);
    }

    public void setDelete() {
//        int intSubmitRow = Integer.parseInt(submitrow);
        MenuService ms = new MenuService();
        ms.deleteOneMenuItem(Integer.parseInt(dbpkey));

    }
    
    public int getViewRow(){
        int viewRow = 0;
        for (int i =0; i < xrefRows.length; i++){
            if (xrefRows[i].equals(dbpkey)){
                viewRow = i;
                break;
            }
        }
        return viewRow;
    }
}