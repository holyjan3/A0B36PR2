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
   public static GlobalDateAb dateControl;
   
   
   public WorkerDatabase(ControlElement controlElement,ConectDatabases conectDatabeses,GlobalDateAb dateControl) {
       WorkerDatabase.controlElement = controlElement;    
       WorkerDatabase.conectDatabeses = conectDatabeses;
       WorkerDatabase.dateControl =  dateControl;
       //WorkerDatabase.dataDatabasesInterface = dataDatabasesInterface;
       
   }  
}
