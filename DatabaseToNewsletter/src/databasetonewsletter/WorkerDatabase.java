/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class WorkerDatabase {
   static ArrayList<Database> dataDatabases = WorkerDatabase() ;
   public static boolean online = false;

   private static ArrayList<Database> WorkerDatabase() {
        dataDatabases  = new ArrayList<>(10);
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            dataDatabases.add(new Database(dataDatabase));
        }
        return(dataDatabases);
    }

  
    
    public static void conectOnlineDatabase(String name, String password){
         try {
           Connection con = DriverManager.getConnection(
                           "jdbc:mysql://localhost:3306/employee_record","root","");
           
           setOnlineDatabase();
           online = true;
           
       } catch (SQLException ex) {
           Logger.getLogger(WorkerDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }
    
    public static void conectOfflineDatabase(){
        setOfflineDatabase();
        getDateFromDatabase();       
    
    }
    
    
    public static void setOnlineDatabase(){
           online = true;      
    }
    
    public static void setOfflineDatabase(){
        for (Database database : dataDatabases) {
            database.setWorkDatabaseOffline();
        }
    }
    
    public static void getDateFromDatabase(){        
          for (Database database : dataDatabases) {
            database.nowWorkDatabase.readFromDatabase();
        }
    }
    
    public static void saveDatabase(){
        for (Database database : dataDatabases) {
            database.nowWorkDatabase.saveDatabese();
        }
    }
    
    
}
