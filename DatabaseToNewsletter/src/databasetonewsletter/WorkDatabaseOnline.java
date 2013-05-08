/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.*;
/**
 *
 * @author Majitel
 */
public class WorkDatabaseOnline extends WorkDatabase{
    

    public Connection conection =null;
    
    public WorkDatabaseOnline(Database database) {
        super(database);
        conection = WorkerDatabase.conection;
        // tady se vytvori string nebo pole stringu na prodavani veci do databaze.. 
    }
    
    
    public void readFromRow(){
        String ss[] = new String[database.DE.length];
        // nacte identifikacni cislo
        int key = 0;
        for (int i = 0; i < database.DE.length; i++) {
            
        }
        Element el = new Element(database.DE, ss);
        el.key = key;
        database.Data.add(el);
        
        
    }
    
    
    @Override
    public void readFromDatabase() {
        Statement stmt = null;
        String ss = "LOCK TABLES" + database.name_file + "READ";
        try{
            stmt = conection.createStatement();
            stmt.execute(ss);
           
        
        
        
        
     
       }
        catch(SQLException ex) {
        System.out.println("SQL Exception caught + ex.getMessage()");
        
       }
        
        
      
        // zkonroluje jestli je databáze zamklá jesli neni pokračuje, jinak zdělí uživateli že z  databází někdo pracuje
        // koukne se na posledne se na čas poslední úprvi daatabáze,  
        //jestli ne nic nedela jestli ano nahraje databázi a zepta se které prvky si přeje nahradit ... 
        // nahradí prvky
 
    }
   

    @Override
    public void addElementt(Element element) {
        // zažádá o unikátní číslo ...
        // přidá prvek do datbaze
    }



    @Override
    public void removeElement(Element element) {
        // smaže prvek
    }

    @Override
    public void modifyElement(JPanelElement panelElement) {
        // modifikuje prvek
    }   
    
    

    @Override
    public void saveDatabese() {
        super.saveDatabese();
        // odpojí se od databáze
        // odemknout databázi
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
