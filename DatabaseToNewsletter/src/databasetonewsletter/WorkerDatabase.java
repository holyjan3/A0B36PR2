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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WorkerDatabase {
    
    public static ArrayList<Database> dataDatabases ;
    
    public static boolean online = false;
    
    public static final String unicateKey = "KEYPRIMARY";
    
    public static final String printed = "PRINTED";
    
    public static String nameTable = "NEWSLETTERDATAS";
    
    public static String DateChanged = "DATECHANGED";
    
    public static Connection conection =null;
    
    public static java.util.Date date;
    
    //public static String head = "";
    
    //public static String foot = "";
    
    public static java.util.HashMap<Integer,Boolean> printedHashMap = new HashMap<>();
    
    public static String url;
    
    public static String name;
    
    public static String password;
  
   
    
    public static Date setDate(){
    Calendar c = Calendar.getInstance(); 
    c.setTime(new Date());
    
    c.add(Calendar.MONTH, -2);
    Date date = c.getTime();  
    date.setHours(0);
    date.setMinutes(0);
    date.setSeconds(0);
    return  date;
       
   }
   
    
    public static void WorkerDatabase() {
        dataDatabases  = new ArrayList<>(10);
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            dataDatabases.add(new Database(dataDatabase));
        }
        
    }
    
    
   

  
    
    
    public static boolean conectOnlineDatabase(){
       
        
      
 

        Connection conn = null;
        try {
           
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url,name,password);    
//            String url = "jdbc:derby://localhost:1527/Newsletters";
//            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//            conn = DriverManager.getConnection(url,"root","root");
            WorkerDatabase.conection = conn;
            return true;
             
        } catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            return false;
        }        
      
    }

    
    
    
}
