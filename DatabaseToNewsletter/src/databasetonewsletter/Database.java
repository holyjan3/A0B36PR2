/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private WorkDatabase workDatabaseOffline;
    private WorkDatabase workDatabaseOnline;
    protected final String name_file;
    
    //private int number_of_element;
    
    public Database(DataDatabase database) {        
        this.name_database = database.name;
        this.name_file = database.name();
        this.database = database;
        this.DE = database.dataElemen;
        
        this.Data  = new LinkedList<Element>();
        
        workDatabaseOffline = new WorkDatabaseOffline(this);
        workDatabaseOnline = new WorkDatabaseOnline(this);
        nowWorkDatabase= workDatabaseOffline;
    }

    public void setWorkDatabaseOffline() {
        this.nowWorkDatabase = workDatabaseOffline;
    }

    public void setWorkDatabaseOnline() {
        this.nowWorkDatabase = workDatabaseOnline;
    }
    
    public boolean isOnline(){
        if(nowWorkDatabase.getClass() == workDatabaseOnline.getClass()){
            return true;
        } else {
            return false;
        }
    }
    
    public void saveToFile(){
        workDatabaseOffline.saveDatabese();
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
