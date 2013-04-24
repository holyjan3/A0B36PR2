/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.Comparator;
import javax.lang.model.util.Elements;

/**
 *
 * @author Majitel
 */
public class ComparatorPrint implements Comparator<Element>{

    @Override
    public int compare(Element o1, Element o2) {
        boolean b1 = Boolean.parseBoolean(o1.strings_of_elements[0]);
        boolean b2 = Boolean.parseBoolean(o2.strings_of_elements[0]);
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
