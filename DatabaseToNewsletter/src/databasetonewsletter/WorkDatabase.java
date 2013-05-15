/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import databasetonewsletter.userinterface.JPanelElement;
import java.util.Date;


/**
 * třída pro práci s databází
 * @author Jan Holý
 */
public abstract class WorkDatabase {
    
    protected Database database;    
    private ReadFromDatabase rfd;
    
    
    
    /**
     * 
     * @param database dabtabaáze se kterou budu pracovar
     */
    public WorkDatabase(Database database) {
        this.database = database;
        rfd = new ReadFromDatabase();        

    }
    
    
    /**
     *  načteníz databáze pomocí vláken
     */
    public class ReadFromDatabase implements Runnable{        
        @Override
        public void run() {
            readFromDatabase(null);
        }
        
    
    }    
    
    
    /**
     * načtení záznamů od určitého data
     * @param d pokud je null pak se načtou všechny záznamy
     */
    public  abstract void readFromDatabase(Date d);   
    
    /**
     * odstranění záznamu z databáze
     * @param element
     */
    public abstract void removeElement(Element element);
    
    /**
     * přidání záznamu do databáze
     * @param element
     */
    public abstract void addElementt(Element element);
    
    /**
     * upravení záznamu z databáze
     * @param element
     */
    public abstract void modifyElement(JPanelElement element);
    
    
    /**
     * načtení prvku z databáze
     * @param number_element číslo záznamu
     * @return
     */
    public Element openElement(int number_element){
        return database.Data.get(number_element);
    }
    
      
    
}
