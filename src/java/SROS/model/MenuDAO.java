/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    public boolean updateOneMenuItem(int id, String desc, String um, double price)
            throws SQLException {
        accessor = new MySQLDBAccessor();
        
        return accessor.updateRow(id, desc, um, price);
    }

    @Override
    public boolean deleteOneMenuItem(int id) {
        accessor = new MySQLDBAccessor();
        
        return accessor.deleteRow(id);
    }

    @Override
    public boolean insertOneMenuItem(String desc, String um, double price) {
        accessor = new MySQLDBAccessor();
        
        return accessor.insertRow(desc, um, price);
    }

    
}
