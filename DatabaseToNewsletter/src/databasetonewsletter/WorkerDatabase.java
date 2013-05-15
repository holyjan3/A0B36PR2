/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * metoda pro nahrání všech druhú záznamů a připojení k databázím
 * @author Jan Holý
 */
public class WorkerDatabase {
    
    /**
     * pole všech databází
     */
    public static ArrayList<Database> dataDatabases ;      
    /**
     * globální připojení
     */
    public static Connection conection =null;    
    /**
     * globální datum pro výběr záznamů
     */
    public static java.util.Date date;    
    /**
     *  správce záznamů k vložení do emailu
     */
    public static java.util.HashMap<Integer,Boolean> printedHashMap = new HashMap<>();    
    /**
     * adresa pro přihlášení do databáze
     */
    private static String url;    
    /**
     * jméno pro přihlášení do databáze
     */
    private static String name;    
    /**
     * heslo pro pčihlášení do databáze
     */
    private static String password;  
   
    
 
    /**
     * metoda nastavuje výchozí datum
     * @return
     */
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
   
    
  
    /**
     * metoda pro nahrání všech druhů záznamů
     * @throws SQLException
     */
    public static void WorkerDatabase() throws SQLException {
        dataDatabases  = new ArrayList<>(10);
        int id = -1;
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            id = getIdDatabases(dataDatabase.name());
            if(id != -1){                
                dataDatabases.add(new Database(dataDatabase,id));
            }
        }
        
    }
    
        
    

    /**
     * metoda pro získání identifikátoru záznamů
     * @param name
     * @return
     * @throws SQLException
     */
    private static int getIdDatabases(String name) throws SQLException {
       
        int i = -1;
        try {           
           String sRead =  "SELECT APP.NEWSLETTERDATABASES.ID_DATABASES FROM APP.NEWSLETTERDATABASES WHERE NAME_DATABASES ='"+ name +"'";
           Statement stm = conection.createStatement();
           ResultSet rs = stm.executeQuery(sRead);
           rs.next();
           i=  rs.getInt("ID_DATABASES");
           
           
       } catch (SQLException ex) {           
           throw ex;           
       } finally {
           return i;
       }
         
       
    }
    
    /**
     *
     * @param newpassword
     * @return
     */
    public static boolean changePassword(String newpassword){
       PreparedStatement st1 = null;
       try {
           
            String ss = "CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user."+name+"','"+newpassword+"')";
            st1 = conection.prepareStatement(ss);
            st1.execute(); 
            return true;
        } catch (SQLException ex) {
            return false;
        }
   } 
   

    /**
     * metoda pro připojení k databázi
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void conectOnlineDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
       
            Connection conn = null;
            String url2 = "jdbc:derby:"+ url+ ";create=true; user="+name + ";password="+password; 
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url2,name,password);
            
//            String url = "jdbc:derby://localhost:1527/Newsletters";
//            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//            conn = DriverManager.getConnection(url,name,password);
            
            WorkerDatabase.conection = conn;
            
    }

    /**
     * nastaví adresu databáze
     * @param url
     */
    public static void setUrl(String url) {
        WorkerDatabase.url = url;
    }

    /**
     * nastaví přihlašovací jméno
     * @param name
     */
    public static void setName(String name) {
        WorkerDatabase.name = name;
    }

    /**
     * nastaví heslo
     * @param password
     */
    public static void setPassword(String password) {
        WorkerDatabase.password = password;
    }

     /**
     * vrátí výchozí adresu
     * @return
     */
    public static String getDefoulteUrl() {         
        File f = new File("Newsletters");             
        return f.getAbsolutePath().replace(File.separatorChar, '/');
    }

    /**
     * vrátí výchozí jméno
     * @return
     */
    public static String getDefoulteName() {
        return "root";
    }

    /**
     * vrátí výchzí heslo
     * @return
     */
    public static String getDefoultePassword() {
        return "root";
    }

    /**
     * získá adressu
     * @return
     */
    public static String getUrl() {
        return url;
    }

    /**
     * získá jméno
     * @return
     */
    public static String getName() {
        return name;
    }

    /**
     * získá heslo
     * @return
     */
    public static String getPassword() {
        return password;
    }
    
    
    
}
