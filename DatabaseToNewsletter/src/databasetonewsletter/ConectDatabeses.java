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
import java.util.HashMap;

/**
 *
 * @author Majitel
 */
abstract public class ConectDatabeses {   
    
    abstract public Connection getConection();

    
    abstract public ArrayList<Database> getDataDatabases();

    
    abstract public void setPrintedHashMap(int i, boolean b);
  
     abstract public void removeKey(int i);

   
    abstract public boolean getPrintedHashMap(Integer i);

  
    abstract public boolean conteinsPrintedHashMap(Integer i);

    
    abstract public void conectWorkerDatabase() throws SQLException;

   
    abstract public boolean changePassword(String newpassword);

    
    abstract public void conectOnlineDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
   
    abstract public void setUrl(String url);

    
    abstract public void setName(String name);

    
    abstract public void setPassword(String password);

 
   abstract public String getDefoulteUrl();

   
    abstract public String getDefoulteName();

    
    abstract public String getDefoultePassword();

    
   abstract public String getUrl();

    
    abstract public String getName();


    abstract public String getPassword();

    
    abstract public void conectionClose() throws SQLException ;
    
}
