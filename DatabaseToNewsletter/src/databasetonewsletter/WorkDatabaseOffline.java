/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import StaticClass.WorkerDatabase;
import userinterface.ErrorConectToDatabase;
import userinterface.JPanelElement;
import java.sql.*;
import java.text.SimpleDateFormat;


public class WorkDatabaseOffline extends WorkDatabase{
        
    private Connection conection =null;    
    java.util.Date date;    
    private boolean read;
   
    
   private final String unicateKey = "KEYPRIMARY";
   private final String nameTable = "NEWSLETTERDATAS";
   //private final String DateChanged = "DATECHANGED";
    
    
    public WorkDatabaseOffline(Database database) {
        super(database);       
        conection = WorkerDatabase.conectDatabeses.getConection();
        this.read = true;
        date = null;
    }
    
    
    
    @Override
    public void readFromDatabase(java.util.Date d) {
          
        
       if(!read && equalsDates(date,d)){
           
          return; 
       }
       
       
        if(d!= null){
            date = (java.util.Date) d.clone();
            
        } else {
            date = null;
        }
        
        database.Data.clear();

        read = false;
        
        SimpleDateFormat chooseDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000");
         
        Statement stmt = null;
        StringBuilder sb = new StringBuilder();
        String sRead = "";        
        sb.append(this.unicateKey);
        for (int i = 0; i < database.DE.length; i++) {
            sb.append(database.DE[i]+",");
            
        }
        sb.delete(sb.length()-1, sb.length()-1);
        
        if( date != null){
           sRead = "SELECT APP."+this.nameTable+".* FROM "+ "APP."+this.nameTable+" WHERE ID_DATABASES="
                   +Integer.toString(database.id_database) + " AND TIME_LAST_CHANGED >= '" + chooseDate.format(d).toString()+"'"; 
        }else {
            sRead = "SELECT APP."+this.nameTable+".* FROM "+ "APP."+this.nameTable+" WHERE ID_DATABASES="+Integer.toString(database.id_database); 
        }
        String[] ss;   
        int key = 0;
        boolean printed = false;
         SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
         SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        String s;
         
         while(true){
         try{
            
            stmt = conection.createStatement();
            ResultSet rs = stmt.executeQuery(sRead); 
            
           while(rs.next()){
                key = rs.getInt(this.unicateKey);
                ss = new String[database.DE.length];
                //printed = rs.getBoolean(WorkerDatabase.printed);
   
                for (int i = 0; i < database.DE.length; i++) {
                   
                    switch (database.DE[i].type) {
                        case DATE:
                             if((date = rs.getDate(database.DE[i].name()))!=null)
                            ss[i] = formatDate.format(date);
                             else 
                                ss[i] ="";
                            break;
                        case TIME:
                            if((date = rs.getTime(database.DE[i].name()))!=null)
                            ss[i] = formatTime.format(date);
                            else
                                ss[i] ="";
                            break;         
                        default:
                            if((s=rs.getString(database.DE[i].name()))!=null)
                             ss[i] = s;
                            else 
                                ss[i] = "";
                           
                    }
                   
                    
                }
                
                Element el = new Element(database.DE, ss , key);              
                database.Data.add(el);
                
            }
            return;
       }
     catch(SQLException ex) {
         ErrorConectToDatabase er= new ErrorConectToDatabase();
        if(er.ErrorConectToDatabase()){
             conection = WorkerDatabase.conectDatabeses.getConection();
        } else {
            return;
        }
       
    }
   }
 
  }
    
    
    private boolean equalsDates(java.util.Date d1, java.util.Date  d2){
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
        
         
       
         Statement stmt = null;
        
         StringBuilder sb1 = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();
         sb1.append("\"APP\" . ");
         sb1.append("\""+this.nameTable+"\" ");
         
         sb1.append('(');
         sb2.append('(');
         for (int i = 0; i < element.DE.length; i++) {
            if(!element.strings_of_elements[i].equals("")){
                
                
                
                sb1.append(element.DE[i].name()+", ");                
                sb2.append("'"+element.strings_of_elements[i]+"'"+", ");         
                   
                              
            }
         }
         sb1.append("ID_DATABASES, " + "TIME_LAST_CHANGED");
         sb2.append(Integer.toString(database.id_database) +", CURRENT_TIMESTAMP");
         
         
         sb1.append(")");
         sb2.append(")");
         String sql = "INSERT INTO " + sb1.toString() + " VALUES " + sb2.toString(); 
         
         
         while(true){
         try {  
           stmt = conection.createStatement();
           stmt.execute(sql,Statement.RETURN_GENERATED_KEYS);
          
           ResultSet res = stmt.getGeneratedKeys();
           res.next();
          
           element.setKey(res.getInt(1));
           element.setPrinted(element.isPrinted(), element.getKey());
           database.Data.add(element);
           return;
        } catch (SQLException ex) {
           ErrorConectToDatabase er= new ErrorConectToDatabase();
        if(er.ErrorConectToDatabase()){
             conection = WorkerDatabase.conectDatabeses.getConection();
        } else {
            return;
        }
           
        }
      } 
    }
  



    
    @Override
    public void removeElement(Element element) {
        
        String sql = "DELETE FROM APP."+  this.nameTable + " WHERE "+
                    this.unicateKey + " = " + Integer.toString(element.getKey());
        PreparedStatement statement = null;
        int key = element.getKey();
        while(true){
        try {
            statement = conection.prepareStatement(sql);
            statement.execute(); 
            database.Data.remove(element);
            WorkerDatabase.conectDatabeses.removeKey(key);
            return;
        } catch (SQLException ex) {
             ErrorConectToDatabase er= new ErrorConectToDatabase();
        if(er.ErrorConectToDatabase()){
             conection = WorkerDatabase.conectDatabeses.getConection();
        } else {
            return;
        }
        }
        }
    }

    
    @Override
    public void modifyElement(JPanelElement panelElement) {
        Element element = panelElement.element;
        for (int i = 0; i < panelElement.text.length; i++) {
            element.strings_of_elements[i] = WorkerDatabase.controlElement.contorlDatabaseElementAndReplece(panelElement.element.strings_of_elements[i], panelElement.element.DE[i]);
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
        String sql = "UPDATE APP."+  this.nameTable +" SET "+ sb.toString()+" WHERE "+
                    this.unicateKey + "=" + Integer.toString(element.getKey());
       while(true){
        try {
            PreparedStatement statement = conection.prepareStatement(sql);
            statement.execute();
            return;
        } catch (SQLException ex) {
             ErrorConectToDatabase er= new ErrorConectToDatabase();
        if(er.ErrorConectToDatabase()){
             conection = WorkerDatabase.conectDatabeses.getConection();
        } else {
            return;
        }
        }
       }
    }   
    
    




    
}
