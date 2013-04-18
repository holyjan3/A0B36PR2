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
final public class DatabaseEventFuture extends Database{
    
 
    public DatabaseEventFuture(String name_database) {
        super(name_database);      
    }
    
    /**
     *
     */
    @Override
    public DataElements[] findDataElements(){
        
        int i = 0;
        for (DataElements de : DataElements.values()) {
            if(de.ELEMENT_FUTURE != -1){
                i++;
            }
        }
        this.DE = new DataElements[i];
        for (DataElements de : DataElements.values()) {
            if(de.ELEMENT_FUTURE != -1){
                DE[de.ELEMENT_FUTURE] = de;
            }
        }      
           
        return DE;
    }
      
    public void sortDate() {
        Collections.sort(Data,new CompareDate());
    }
    
    public void sortHead() {
        Collections.sort(Data, new CompareName(DataElements.HEAD.ELEMENT_FUTURE));
    }
    
    public void sortTown() {
        Collections.sort(Data,new CompareName(DataElements.TOWN.ELEMENT_FUTURE));
    }

    
}
