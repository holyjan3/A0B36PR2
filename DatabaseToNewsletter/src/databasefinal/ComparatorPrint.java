/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefinal;

import java.util.Comparator;


/**
 * Comparator tříy Element podle toho zda má být záznam vloženy do emailu porovnání je stabilní
 * @author Jan Holý
 */
public class ComparatorPrint implements Comparator<Element>{

    @Override
    public int compare(Element o1, Element o2) {
        boolean b1 = o1.isPrinted();
        boolean b2 = o2.isPrinted();
        if(b1 == b2) {
            return 0;
        } else {
            if(b1){
                return -1;
            } else {
                return 1;
            }
        }
    
    }
    
}
