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
public class CompareString implements  Comparator<Element>{

    int order;

    public CompareString(int order) {
        super();
        this.order = order;
    }   

    @Override
    public int compare(Element o1, Element o2) {
        return o1.strings_of_elements[order].compareTo(o2.strings_of_elements[order]);
    }
    
}
