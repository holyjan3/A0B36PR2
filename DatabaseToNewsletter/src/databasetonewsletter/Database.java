/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsletterdatabase;

import java.util.*;

/**
 *
 * @author Majitel
 */

public abstract class Database {
    protected List<Element> Data;
    protected String name_database;
    protected DataElements[] DE;
    
    public Database(String name_database) {
        
        this.name_database = name_database;
        this.Data  = new LinkedList<Element>();
        this.DE = findDataElements();
        
    }
    
    public Object getElement(int i){
        return Data.get(i);
    }  
    
    public void removeElement(int i) {
        Data.remove(i);
    }
    public void addElement(String ss){
        Data.add(new Element(DE, ss));
    }
    
    public void addVoidElement(){
        Data.add(new Element(DE, new String[DE.length]));
    }
    public void changeElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    }
    
    public void removeElemets(int[] ar){
        for(int i : ar){
            removeElement(i);
        }
    }
    
    
    public  void readFromDatabase(){
        
    }
    public void writeToTemp(){
               
    }    
    public  void tempToDatabase(){
        
    }
    
    abstract   public DataElements[] findDataElements();
    
}
