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
    protected void findDataElements(){
        
        int i = 0;
        for (DataElement de : DataElement.values()) {
            if(de.ELEMENT_FUTURE != -1){
                i++;
            }
        }
        this.DE = new DataElement[i];
        for (DataElement de : DataElement.values()) {
            if(de.ELEMENT_FUTURE != -1){
                DE[de.ELEMENT_FUTURE] = de;
            }
        }      
    }    
}
