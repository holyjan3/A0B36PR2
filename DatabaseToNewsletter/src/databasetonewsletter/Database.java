/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.WorkerDatabase.conection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * třída obsahující záznami jednoho typu
 * @author Majitel
 */
public class Database{
    
    /**
     * všechny typy položek záznamu
     */
    public List<Element> Data;    
    /**
     *  určené typy záznamu
     */
    public DataDatabase database;
    /**
     * ukláda záznami do trvalého úložiště
     */
    public WorkDatabase nowWorkDatabase;  
    
    /**
     * jméno databáze pro uživatele
     */
    public final String name_database;    
    /**
     * typy položek
     */
    public final DataElement[] DE;      
    /**
     * jméno databáze pro ukládání
     */
    protected final String name_file;    
    /**
     * idenitifikáto databáze
     */
    protected int id_database;
    
    
    /**
     *
     * @param database určena typy záznamu
     */
    public Database(DataDatabase database) {        
        this.name_database = database.name;
        this.name_file = database.name();
        this.database = database;
        this.DE = database.dataElemen;
        this.id_database = getKeyDatabases(name_file);        
        this.Data  = new LinkedList<Element>();
        nowWorkDatabase = new WorkDatabaseOffline(this);
        
        
         
    }
    
    
     /**
     *
     * @param name
     * @return
     */
    public final int getKeyDatabases(String name) {
       try {           
           String sRead =  "SELECT APP.NEWSLETTERDATABASES.ID_DATABASES FROM APP.NEWSLETTERDATABASES WHERE NAME_DATABASES ='"+ name +"'";
           Statement stm = conection.createStatement();
           ResultSet rs = stm.executeQuery(sRead);
           rs.next();
           return rs.getInt("ID_DATABASES");
           
           
       } catch (SQLException ex) {
           Logger.getLogger(WorkerDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }
         
       return -1;
    }
   
    
    
    
    /**
     *
     * @param i
     * @param j
     */
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    } 
    
    
    
    /**
     * řadí položky záznamu podle data
     * @param number pořadí stringu podle kterého se porovnává
     */
    public void sortDate(int number){
        
        Collections.sort(Data,new CompareDate(number));
    }
    
    
    /**
     * řadí položky záznamu podle lexikografického pořadí
     * @param number pořadí stringu podle kterého se porovnává
     */
    public void sortString(int number) {
        Collections.sort(Data, new CompareString(number));
    }
    
    
    /**
     * řadí podle toho zdali je prvek určen k vložení do emailu
     */
    public void sortPrint(){
        Collections.sort(Data,new ComparatorPrint());
    }

    
}
