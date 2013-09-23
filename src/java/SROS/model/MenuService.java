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
        //return menuDAO.getOneMenuItem(id);
    }

    
}
