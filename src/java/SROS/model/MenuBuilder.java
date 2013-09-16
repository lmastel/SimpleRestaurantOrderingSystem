/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

/**
 *
 * @author LPM
 */
public class MenuBuilder {
    private String[] menuitems;

    public MenuBuilder() {
        this.menuitems = new String[]{" ", " "};
    }
     public String[] getMenuItems(){
         
         menuitems[0] = "Cheese Pizza";
         menuitems[1] = "Pepperoni Pizza";
         
         return menuitems;
     }
}
