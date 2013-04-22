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

public abstract class Database {
    protected List<Element> Data;
    protected String name_database;
    protected DataElement[] DE;
    protected WorkDatabase nowWorkDatabase;
    private WorkDatabase workDatabaseOffline;
    private WorkDatabase workDatabaseOnline;
    
    //private int number_of_element;
    
    public Database(String name_database) {        
        this.name_database = name_database;
        this.Data  = new LinkedList<Element>();
        findDataElements();
        workDatabaseOffline = new WorkkDatabaseOffline(this);
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
    
    
    
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    } 
    
    
    public void sortDate() {
        Collections.sort(Data,new CompareDate());
    }
    
    public void sortString(int number) {
        Collections.sort(Data, new CompareString(number));
    }
    
    public void sortPrint(){
        Collections.sort(Data,new ComparatorPrint());
    }

    
    abstract   protected void findDataElements();
    
}
