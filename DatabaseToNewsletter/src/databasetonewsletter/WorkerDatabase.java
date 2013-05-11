/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
   public static final String unicateKey = "KEYPRIMARY";
   public static final String printed = "PRINTED";
   public static String nameTable = "NEWSLETTERDATAS";
   public static String DateChanged = "DATECHANGED";
   public static Connection conection =null;
   public static java.util.Date date;
   public static String head = "";
   public static String foot = "";
   
   
   
   
    public static void WorkerDatabase() {
        dataDatabases  = new ArrayList<>(10);
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            dataDatabases.add(new Database(dataDatabase));
        }
        
    }
    
    public static int getKeyDatabases(String name) {
       try {           
           String sRead =  "SELECT APP.NEWSLETTERDATABASES.ID_DATABASES FROM APP.NEWSLETTERDATABASES WHERE NAME_DATABASES ='"+ name +"'";
           Statement stm = conection.createStatement();
           ResultSet rs = stm.executeQuery(sRead);
           rs.next();
           return rs.getInt("ID_DATABASES");
           
           
       } catch (SQLException ex) {
           Logger.getLogger(WorkerDatabase.class.getName()).log(Level.SEVERE, null, ex);
       }
         
       return -1;
    }

  
    
    public static void conectOnlineDatabase(String name, String password){
        String url = "jdbc:derby://localhost:1527/Newsletters";
        Connection conn = null;
        try {
          
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url,"root","root");
             
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
        }        
       WorkerDatabase.conection = conn;
    }
    
//    public static void conectDatabaseAll() throws InterruptedException {
//            Thread[] th = new Thread[dataDatabases.size()];
//        int i = 0;
//        boolean bb = true;
//            for (Database database : dataDatabases) {
//                th[i] = new Thread(database.nowWorkDatabase.rfd);
//                th[i].start();
//
//                i++;
//            }
//        boolean finshed = false;
//        ExecutorService es = Executors.newCachedThreadPool(); 
//        for(Database database : dataDatabases) 
//            es.execute(database.nowWorkDatabase.rfd); 
//            es.shutdown();
//       while(!finshed){
//           
//            finshed = es.awaitTermination(1, TimeUnit.SECONDS);
//      
//       }
//      
//        
//    }
    
    
    
}
