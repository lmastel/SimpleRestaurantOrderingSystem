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

    public static void main(String[] args) {
        ArrayList ij = new ArrayList<>();
        MenuService ms = new MenuService();
        ArrayList al = ms.getOneMenuItem(1);
        System.out.println("al =" + al.toString());
         
        
        ij.add(0, al);
        System.out.println("ij =" + ij.toString());
        




    }
}
