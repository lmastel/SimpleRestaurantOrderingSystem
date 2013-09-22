/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LPM
 */
public class MenuDAO implements IMenuDAO {

    private MySQLDBAccessor accessor;

    @Override
   
    public ArrayList<ArrayList> getAllMenuItems() {
        accessor = new MySQLDBAccessor();
        
        return accessor.getResultSetRows();       
        
    }
    
    @Override
    public ArrayList getOneMenuItem(int id) {
        accessor = new MySQLDBAccessor();
        
        return accessor.getResultSetRow(id);
           
    }

    public static void main(String[] args) throws Exception {
        MenuDAO mdao = new MenuDAO();

        ArrayList<ArrayList> rows = mdao.getAllMenuItems();

        System.out.println("xrows = " + rows.get(0).get(0));
        System.out.println("xrows = " + rows.get(0).get(1));
        System.out.println("xrows = " + rows.get(0).get(2));
        
        System.out.println("xrows = " + rows.get(2).get(0));
        System.out.println("xrows = " + rows.get(2).get(1));
        System.out.println("xrows = " + rows.get(2).get(2));

    }

    
}
