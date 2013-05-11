/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Majitel
 */
public class WorkDatabaseOnline extends WorkDatabase{
    
    int numberDatabase;
    public Connection conection =null;
    java.util.Date date;
    private boolean read;
   
    
    public WorkDatabaseOnline(Database database) {
        super(database);
       
        conection = WorkerDatabase.conection;
        numberDatabase = database.database.ordinal();
        this.read = true;
        date = null;
    }
    
    
    @Override
    public void readFromDatabase() {
          
        
       if(!read && equalsDates(date,WorkerDatabase.date )){
           
          return; 
       }
       
       
        if(WorkerDatabase.date != null){
            date = (java.util.Date) WorkerDatabase.date.clone();
            
        } else {
            date = null;
        }
        
        database.Data.clear();
        if(date != null) System.out.println(date.toString());
        else 
            System.out.println("null");
        read = false;
        
        SimpleDateFormat chooseDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000");
         
        Statement stmt = null;
        StringBuilder sb = new StringBuilder();
        String sRead = "";        
        sb.append(WorkerDatabase.unicateKey);
        for (int i = 0; i < database.DE.length; i++) {
            sb.append(database.DE[i]+",");
            
        }
        sb.delete(sb.length()-1, sb.length()-1);
        
        if( date != null){
           sRead = "SELECT APP."+WorkerDatabase.nameTable+".* FROM "+ "APP."+WorkerDatabase.nameTable+" WHERE ID_DATABASES="
                   +Integer.toString(database.id_database) + " AND TIME_LAST_CHANGED >= '" + chooseDate.format(WorkerDatabase.date).toString()+"'"; 
        }else {
            sRead = "SELECT APP."+WorkerDatabase.nameTable+".* FROM "+ "APP."+WorkerDatabase.nameTable+" WHERE ID_DATABASES="+Integer.toString(database.id_database); 
        }
        String[] ss;   
        int key = 0;
        boolean printed = false;
        try{
            stmt = conection.createStatement();
            ResultSet rs = stmt.executeQuery(sRead);
            
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
           
            java.util.Date date = null;
    
            

       
            
            
           while(rs.next()){
                key = rs.getInt(WorkerDatabase.unicateKey);
                ss = new String[database.DE.length];
                //printed = rs.getBoolean(WorkerDatabase.printed);
   
                for (int i = 0; i < database.DE.length; i++) {
                    
                    switch (database.DE[i].type) {
                        case DATE:
                             if((date = rs.getDate(database.DE[i].name()))!=null)
                            ss[i] = formatDate.format(date);
                            break;
                        case TIME:
                            if((date = rs.getTime(database.DE[i].name()))!=null)
                            ss[i] = formatTime.format(date);
                            break;         
                        default:
                             ss[i] = rs.getString(database.DE[i].name());
                           
                    }
                   
                    
                }
                
                Element el = new Element(database.DE, ss);
              
                el.setStringPrinted(printed);
                el.key = key;
                database.Data.add(el);
                
            }
           
       }
        catch(SQLException ex) {
        System.out.println("SQL Exception caught + ex.getMessage()");
       
        }
 
    }
    public boolean equalsDates(java.util.Date d1, java.util.Date  d2){
        if((d1 == null && d2 == null )){
            return true;            
        }else {
            if(d1==null ^ d2 == null) {
               return false; 
            } else {
                return d1.equals(d2);
            }
        }
     
        
    }

    @Override
    public void addElementt(Element element) {
        
         Element el = element;
         database.Data.add(el);
         Boolean bb = false;
       
         Statement stmt = null;
        
         StringBuilder sb1 = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();
         sb1.append("\"APP\" . ");
         sb1.append("\""+WorkerDatabase.nameTable+"\" ");
         
         sb1.append('(');
         sb2.append('(');
         for (int i = 0; i < element.DE.length; i++) {
            if(!element.strings_of_elements[i].equals("")){
                
                
                bb = true;
                sb1.append(element.DE[i].name()+", ");                
                sb2.append("'"+element.strings_of_elements[i]+"'"+", ");         
                   
                              
            }
         }
         sb1.append("ID_DATABASES, " + "TIME_LAST_CHANGED");
         sb2.append(Integer.toString(database.id_database) +", CURRENT_TIMESTAMP");
         
         
         sb1.append(")");
         sb2.append(")");
         
         
         try {            
            
           String sql = "INSERT INTO " + sb1.toString() + " VALUES " + sb2.toString();
           stmt = conection.createStatement();
           stmt.execute(sql,Statement.RETURN_GENERATED_KEYS);
          
           ResultSet res = stmt.getGeneratedKeys();
           res.next();
         
           
           element.key = res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(WorkDatabaseOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  



    @Override
    public void removeElement(Element element) {
        
        String sql = "DELETE FROM APP."+  WorkerDatabase.nameTable + " WHERE "+
                    WorkerDatabase.unicateKey + " = " + Integer.toString(element.key);
        PreparedStatement statement = null;
        try {
            statement = conection.prepareStatement(sql);
            database.Data.remove(element);
            statement.execute(); 
        } catch (SQLException ex) {
            Logger.getLogger(WorkDatabaseOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifyElement(JPanelElement panelElement) {
        Element element = panelElement.element;
        
        panelElement.element.changed = true;
        for (int i = 0; i < panelElement.text.length; i++) {
            panelElement.element.strings_of_elements[i] = ControlElement.contorlDatabaseElementAndReplece(panelElement.element.strings_of_elements[i], panelElement.element.DE[i]);
        }      
        
        
        StringBuilder sb = new StringBuilder();
        boolean bb = false;
        //sb.append(WorkerDatabase.printed +"="+ Boolean.toString(element.printed)+",");
        for (int i = 0; i < database.DE.length; i++) {
            if(!element.strings_of_elements[i].equals("")){

            bb = true;
            sb.append(database.DE[i].name()+"='"+element.strings_of_elements[i]+"', ");
            }
        }      
        sb.append("TIME_LAST_CHANGED=CURRENT_TIMESTAMP");
        String sql = "UPDATE APP."+  WorkerDatabase.nameTable +" SET "+ sb.toString()+" WHERE "+
                    WorkerDatabase.unicateKey + "=" + Integer.toString(element.key);
        try {
            PreparedStatement statement = conection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WorkDatabaseOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    



    
}
