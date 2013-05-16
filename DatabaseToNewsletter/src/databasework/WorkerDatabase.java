/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;


/**
 * třída pro nahrání všech druhú záznamů a připojení k databázím
 * @author Jan Holý
 */
public class WorkerDatabase {    
   public static ControlElement controlElement;   
   public static ConectDatabases conectDatabeses;
   public static DateControl dateControl;
   
   public WorkerDatabase(ControlElement controlElement,ConectDatabases conectDatabeses,DateControl dateControl) {
       WorkerDatabase.controlElement = controlElement;    
       WorkerDatabase.conectDatabeses = conectDatabeses;
       WorkerDatabase.dateControl =  dateControl;
   }  
}
