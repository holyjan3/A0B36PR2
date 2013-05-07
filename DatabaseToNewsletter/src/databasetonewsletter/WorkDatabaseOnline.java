/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public class WorkDatabaseOnline extends WorkDatabase{

    public WorkDatabaseOnline(Database database) {
        super(database);
        // tady se vytvori string nebo pole stringu na prodavani veci do databaze.. 
    }
    
    @Override
    public void readFromDatabase() {
      
        // zkonroluje jestli je databáze zamklá jesli neni pokračuje, jinak zdělí uživateli že z  databází někdo pracuje
        // koukne se na posledne se na čas poslední úprvi daatabáze,  
        //jestli ne nic nedela jestli ano nahraje databázi a zepta se které prvky si přeje nahradit ... 
        // nahradí prvky
 
    }
   

    @Override
    public void addElementt(Element element) {
        // pridas element do databaze
        //
    }



    @Override
    public void removeElement(Element element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyElement(JPanelElement panelElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
   

    @Override
    Element openElement(int number_element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    void saveDatabese() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
