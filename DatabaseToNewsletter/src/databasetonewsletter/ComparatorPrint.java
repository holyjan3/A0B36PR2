/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.Comparator;

/**
 *
 * @author Majitel
 */
public class ComparatorPrint implements Comparator<Element>{

    @Override
    public int compare(Element o1, Element o2) {
        boolean b1 = o1.printed;
        boolean b2 = o2.printed;
        if(b1 == b2) {
            return 0;
        } else {
            if(b1){
                return 1;
            } else {
                return -1;
            }
        }
    
    }
    
}
