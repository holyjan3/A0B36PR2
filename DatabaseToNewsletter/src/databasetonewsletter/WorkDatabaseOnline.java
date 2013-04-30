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
        // koukne se jestli se lisi od databaze .. jestli ne nic nedela jestli ano yept8 se jestl ma ptrehrat databazi nebo nahrat vlastni databazi
        // jestli ma prehrad prvky ... 
        // ne to bude delat worker database... 
        // tady poze se nahrajes databazi... 
    }
   

    @Override
    public void addElementt(Element element) {
        // pridas element do databaze
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
    void saveDatabese() {
        // tady posze ukoncis spravu tabulky.. 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

    @Override
    Element openElement(int number_element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void rewriteDatabase(boolean All){
        
    }

    
}
