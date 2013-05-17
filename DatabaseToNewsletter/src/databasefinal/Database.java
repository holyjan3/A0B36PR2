/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasefinal;

import databasework.DataElementInterface;
import databasework.DataDatabaseInteraface;
import databasework.WorkDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;





/**
 * třída obsahující záznami jednoho typu
 * @author Jan Holý
 */
public class Database  {
    /**
     *  záznamy
     */
    public List<Element> Data;    
    /**
     *  typ záznamu
     */
    public final DataDatabaseInteraface datadatabase;
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
    public final DataElementInterface[] DE;      
    /**
     * jméno druhu záznamů pro ukládání
     */
    protected final String name_file;    
    /**
     * idenitifikáto druhu záznamu
     */
    public final int id_database;
    
    
    /**
     *  nahrání správce záznamů {@link #nowWorkDatabase} třídy WorkDatabase
     * @param database určena typy záznamu
     * @param id_database přiřazje identtifikátor druhu záznamu
     */
    public Database(DataDatabaseInteraface database,int id_database, Class <? extends WorkDatabase> workdatabase) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{        
        this.name_database = database.getName();
        this.name_file = database.name();
        this.datadatabase = database;
        this.DE = database.getDataElemen();
        this.id_database = id_database;        
        this.Data  = new LinkedList<>();
        nowWorkDatabase = workdatabase.getConstructor(Database.class).newInstance(this);
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
