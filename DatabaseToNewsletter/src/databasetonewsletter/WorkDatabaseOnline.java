/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.*;
import java.util.*;
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
        String sLock= "LOCK TABLES" + database.name_file + "READ";
        String sRead="SELECT * FROM "+database.name_file; 
        String ss[] = new String[database.DE.length];
        LinkedList <Element> list= new LinkedList<>();
       
        int key = 0;
        boolean printed = false;
        try{
            stmt = conection.createStatement();
            
            stmt.execute(sLock);
            ResultSet rs = stmt.executeQuery(sRead);
            
            while(rs.next()){
                key = rs.getInt(WorkerDatabase.unicateKey);
                printed = rs.getBoolean(WorkerDatabase.printed);
                for (int i = 0; i < 0; i++) {
                    ss[i] = rs.getNString(database.DE[i].name());                    
                }
                
                Element el = new Element(database.DE, ss);
                el.setStringPrinted(printed);
                el.key = key;
                list.add(el);
               
            }
            Database d1 = new Database(database.database);
            Database d2 = new Database(database.database);
            
            
            
            /// porovnaní
           
             
           
        
        
        
        
     
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
    public boolean saveDatabese() {
        super.saveDatabese();
        // odpojí se od databáze
        // odemknout databázi        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        
    }

    
}
