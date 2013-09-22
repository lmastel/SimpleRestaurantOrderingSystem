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
public interface IMenuDAO {
    public abstract ArrayList<ArrayList> getAllMenuItems();
    
    public abstract ArrayList getOneMenuItem(int id);
}
