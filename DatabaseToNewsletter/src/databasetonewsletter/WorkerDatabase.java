/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class WorkerDatabase {
   static ArrayList<Database> dataDatabases ;
   public static boolean online = false;
   public static final String unicateKey = "UNICATEKEY";
   public static final String printed = "PRINTED";
   public static Connection conection =null;
   
    public static void WorkerDatabase() {
        dataDatabases  = new ArrayList<>(10);
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            dataDatabases.add(new Database(dataDatabase));
        }
        
    }

  
    
    public static void conectOnlineDatabase(String name, String password){
         try {
            conection=DriverManager.getConnection(
                           "jdbc:mysql://localhost:3306/employee_record","root","");
           
           setOnlineDatabase();
           online = true;
           
       } catch (SQLException ex) {
           Logger.getLogger(WorkerDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }    
    }
    
    public static void conectDatabaseAll() throws InterruptedException {
//            Thread[] th = new Thread[dataDatabases.size()];
        int i = 0;
        boolean bb = true;
//            for (Database database : dataDatabases) {
//                th[i] = new Thread(database.nowWorkDatabase.rfd);
//                th[i].start();
//
//                i++;
//            }
        boolean finshed = false;
        ExecutorService es = Executors.newCachedThreadPool(); 
        for(Database database : dataDatabases) 
            es.execute(database.nowWorkDatabase.rfd); 
            es.shutdown();
       while(!finshed){
           
            finshed = es.awaitTermination(1, TimeUnit.SECONDS);
      
       }
      
        
    }
    
    public static void disconectDatabasesAll() throws InterruptedException{
          boolean finshed = false;
        ExecutorService es = Executors.newCachedThreadPool(); 
        for(Database database : dataDatabases) 
            es.execute(database.nowWorkDatabase.sd); 
            es.shutdown();
       while(!finshed){  
            finshed = es.awaitTermination(1, TimeUnit.SECONDS);
       }
    }
    
    public static void conectOfflineDatabase(){
        setOfflineDatabase();
        //getDateFromDatabase();       
    
    }
    
    
    public static void setOnlineDatabase(){
      for (Database database : dataDatabases) {
            database.setWorkDatabaseOnline();            
      }
      
      
    }
    
   
    
    public static void setOfflineDatabase(){
        for (Database database : dataDatabases) {
            database.setWorkDatabaseOffline();
        }
    }

    
    public static void saveDatabase(){
        for (Database database : dataDatabases) {
            database.saveToFile();
        }
    }
    
    
}
