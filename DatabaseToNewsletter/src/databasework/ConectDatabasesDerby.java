/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import databasedata.DataDatabase;
import databasedata.Database;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jan Holýl
 */        
public class ConectDatabasesDerby extends ConectDatabases{
/**
     * pole všech databází
     */
    public ArrayList<Database> dataDatabases ;      
    /**
     * globální připojení
     */
    public Connection conection =null;    
    
    /**
     *  správce záznamů k vložení do emailu
     */
    public  java.util.HashMap<Integer,Boolean> printedHashMap = new HashMap<>();    
    /**
     * adresa pro přihlášení do databáze
     */
    private String url;    
    /**
     * jméno pro přihlášení do databáze
     */
    private  String name;    
    /**
     * heslo pro pčihlášení do databáze
     */
    private String password;

        /**
         * metoda nastavuje výchozí datum
         * @return
         */
    
        public Connection getConection() {
            return conection;
        }

        public ArrayList<Database> getDataDatabases() {
            return dataDatabases;
        }

        

        public void setPrintedHashMap(int i, boolean b) {
            this.printedHashMap.put(i, b);
        }
        
        public void removeKey(int i){
            printedHashMap.remove(i);
        }

        public boolean getPrintedHashMap(Integer i) {
            return printedHashMap.containsKey(i);
        }
        
        public boolean conteinsPrintedHashMap(Integer i){
            return this.printedHashMap.containsKey(i);
        }

    
    
    
   
    
  
    /**
     * metoda pro nahrání všech druhů záznamů
     * @throws SQLException
     */
    public void conectWorkerDatabases() throws SQLException {
        dataDatabases  = new ArrayList<>(10);
        int id = -1;
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            id = getIdDatabases(dataDatabase.name());
            if(id != -1){
                WorkDatabaseDerby workDatabaseOffline = new WorkDatabaseDerby();
                Database db = new Database(dataDatabase,id,workDatabaseOffline);
                workDatabaseOffline.readDatabase(db);
                dataDatabases.add(db);
               
            }
        }
        
    }
      
    

    /**
     * metoda pro získání identifikátoru záznamů
     * @param name
     * @return
     * @throws SQLException
     */
    private int getIdDatabases(String name) throws SQLException {
       
        int i = -1;
        try {           
           String sRead =  "SELECT APP.NEWSLETTERDATABASES.ID_DATABASES FROM APP.NEWSLETTERDATABASES WHERE NAME_DATABASES ='"+ name +"'";
           PreparedStatement stm = conection.prepareStatement(sRead);
           ResultSet rs = stm.executeQuery();
           rs.next();
           i=  rs.getInt("ID_DATABASES");
           
           
       } catch (SQLException ex) {           
           throw ex;           
       } finally {
           return i;
       }
         
       
    }
    
    /**
     * metoda pro změnu hesla
     * @param newpassword
     * @return
     */
    public boolean changePassword(String newpassword){
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
    public  void conectOnlineDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{       
            Connection conn = null;
            String url2 = "jdbc:derby:"+ url+ ";create=true; user="+name + ";password="+password; 
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(url2,name,password);            
            conection = conn;
            
    }

    /**
     * nastaví adresu databáze
     * @param url
     */
    public  void setUrl(String url) {
        this.url = url;
    }

    /**
     * nastaví přihlašovací jméno
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * nastaví heslo
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

     /**
     * vrátí výchozí adresu
     * @return
     */
    public String getDefoulteUrl() {         
        File f = new File("Newsletters");             
        return f.getAbsolutePath().replace(File.separatorChar, '/');
    }

    /**
     * vrátí výchozí jméno
     * @return
     */
    public String getDefoulteName() {
        return "root";
    }

    /**
     * vrátí výchozí heslo
     * @return
     */
    public  String getDefoultePassword() {
        return "root";
    }

    /**
     * získá adressu
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * získá jméno
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * získá heslo
     * @return
     */
    public  String getPassword() {
        return password;
    }

        public void conectionClose() throws SQLException {
            conection.close();
        }
   
    
   
  
    
}
