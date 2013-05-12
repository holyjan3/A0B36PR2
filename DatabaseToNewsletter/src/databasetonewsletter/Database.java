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

public class Database{
    protected List<Element> Data;
    protected String name_database;
    protected DataDatabase database;
    protected DataElement[] DE;
    protected WorkDatabase nowWorkDatabase;
    protected final String name_file;
    protected int id_database;
    
    public Database(DataDatabase database) {        
        this.name_database = database.name;
        this.name_file = database.name();
        this.database = database;
        this.DE = database.dataElemen;
        this.id_database = WorkerDatabase.getKeyDatabases(name_file);
        
        this.Data  = new LinkedList<Element>();
        nowWorkDatabase = new WorkDatabaseOnline(this);
        
        
         
    }
   
    
    
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    } 
    
    
    public void sortDate(int i){
        
        Collections.sort(Data,new CompareDate(i));
    }
    
    public void sortString(int number) {
        Collections.sort(Data, new CompareString(number));
    }
    
    public void sortPrint(){
        Collections.sort(Data,new ComparatorPrint());
    }

    
}
