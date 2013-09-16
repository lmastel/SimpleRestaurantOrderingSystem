/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

/**
 *
 * @author LPM
 */
public class SearchArray {
    public static int sequentialSearch(String[] array, String value){
        int index;
        int element;
        boolean found;
        
        index = 0;
        
        element = -1;
        found = false;
        
        while (!found && index < array.length){
            if(array[index].equals(value)){
                found = true;
                element = index;
            }
            index++;
        }
        return element;
    }
}
