/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticClass;

import databasetonewsletter.ConectDatabasesDerby;
import databasetonewsletter.ConectDatabeses;
import databasetonewsletter.ControlElement;
import databasetonewsletter.ControlElementDerby;
import databasetonewsletter.DateControl;
import databasetonewsletter.DateControlDerby;


/**
 * třída pro nahrání všech druhú záznamů a připojení k databázím
 * @author Jan Holý
 */
public class WorkerDatabase {    
   public static ControlElement controlElement;   
   public static ConectDatabeses conectDatabeses;
   public static DateControl dateControl;
   
   public WorkerDatabase() {
        controlElement = new ControlElementDerby();    
        conectDatabeses = new  ConectDatabasesDerby();
        dateControl = new DateControlDerby();
   }  
}
