/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;





/**
 * třída obsahující záznami jednoho typu
 * @author Jan Holý
 */
public class Database{
    
    /**
     *  záznamy
     */
    public List<Element> Data;    
    /**
     *  typ záznamu
     */
    public DataDatabase database;
    /**práce se záznamy v trvalém úložiští
     */
    public WorkDatabase nowWorkDatabase;  
    
    /**
     * jméno druhu záznamů pro uživatele
     */
    public final String name_database;    
    /**
     * typy položek
     */
    public final DataElement[] DE;      
    /**
     * jméno druhu záznamů pro ukládání
     */
    protected final String name_file;    
    /**
     * idenitifikáto druhu záznamu
     */
    protected int id_database;
    
    
    /**
     *  nahrání správce záznamů {@link #nowWorkDatabase} třídy WorkDatabase
     * @param database určena typy záznamu
     * @param id_database přiřazje identtifikátor druhu záznamu
     */
    public Database(DataDatabase database,int id_database) {        
        this.name_database = database.name;
        this.name_file = database.name();
        this.database = database;
        this.DE = database.dataElemen;
        this.id_database = id_database;        
        this.Data  = new LinkedList<Element>();
        nowWorkDatabase = new WorkDatabaseOffline(this);
        
        
         
    }

   
    
    
    
    /**
     * prohodí prvky 
     * @param i a 
     * @param j, zatím nepoužito
     */
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    } 
    
    
    
    /**
     * řadí záznamy podle data
     * @param number pořadí stringu podle kterého se porovnává
     */
    public void sortDate(int number){
        
        Collections.sort(Data,new CompareDate(number));
    }
    
    
    /**
     * řadí záznamy lexikograficky
     * @param number pořadí stringu podle kterého se porovnává
     */
    public void sortString(int number) {
        Collections.sort(Data, new CompareString(number));
    }
    
    
    /**
     * řadí záznami podle toho zdali je záznam určen k vložení do emailu
     */
    public void sortPrint(){
        Collections.sort(Data,new ComparatorPrint());
    }

    
}
