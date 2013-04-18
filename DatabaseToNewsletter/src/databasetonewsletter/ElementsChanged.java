/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.*;

/**
 *
 * @author Majitel
 */
public class ElementsChanged {
    private HashSet<String> ElementsChanges = new HashSet<String>();
    private HashSet<String> ElementsDelete = new HashSet<String>();
    private HashSet<String> ElementsInsert = new HashSet<String>();

    public void insertElementsChanges(String head) {
        ElementsChanges.add(head);
    }
    
    public  void insertElementsChanges(String headOld,String headNew) {
        ElementsChanges.remove(headOld);
        ElementsInsert.remove(headOld);
        ElementsDelete.add(headOld);
        ElementsInsert.add(headNew);
    }

    public  void insetrElementsDelete(String head) {
        ElementsChanges.remove(head);
        ElementsInsert.remove(head);
        ElementsDelete.add(head);
    }

    public void insetrElementsInsert(String head) {
        ElementsInsert.add(head);
    }
    
   
    
    
}
