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
public class MenuService {

    private MenuDAO menuDAO;

    /**
     * Constructor. Instantiates DAO component.
     */
    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public final ArrayList<ArrayList> getAllMenuItems() {
        return menuDAO.getAllMenuItems();
    }

    public final ArrayList getOneMenuItem(int id) {
        return menuDAO.getOneMenuItem(id);       
        
    }
    
    public final boolean insertOneMenuItem(String desc, String um, double price) {
        return menuDAO.insertOneMenuItem(desc, um, price);
        //return true;        
    }
    
    public final boolean updateOneMenuItem(int id, String desc, String um, double price) {
        return menuDAO.updateOneMenuItem(id, desc, um, price);
        //return true;        
    }
    
    public final boolean deleteOneMenuItem(int id) {
        return menuDAO.deleteOneMenuItem(id);
        //return true;        
    }

    
}
