/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefinal;

import java.util.Comparator;


/**
 * Comparator třídy Element v lexikografickém pořadí, porovnávání je stabilí
 * @author Jan Holý
 */
public class CompareString implements  Comparator<Element>{

    int order;

    
    /**
     * 
     * @param order pořadí v poli pole stringů 
     */
    public CompareString(int order) {
        super();
        this.order = order;
    }   

    @Override
    public int compare(Element o1, Element o2) {
        if(o1.strings_of_elements[order]!= null && !o1.strings_of_elements[order].equals("")){
            if(o2.strings_of_elements[order]!= null && !o2.strings_of_elements[order].equals("")) {
                return o1.strings_of_elements[order].compareTo(o2.strings_of_elements[order]);
            } else {
                return -1;
            }
        } else {
            if(o2.strings_of_elements[order]== null || o2.strings_of_elements[order].equals(""))
                return 0;
                        else
                return 1;
        }
    }
    
}
