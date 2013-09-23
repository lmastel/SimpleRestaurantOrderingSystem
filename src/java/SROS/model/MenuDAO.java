/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

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

    
}
