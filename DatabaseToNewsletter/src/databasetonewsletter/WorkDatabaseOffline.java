/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import databasetonewsletter.userinterface.JPanelElement;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WorkDatabaseOffline extends WorkDatabase{
    
    
    int numberDatabase;
    
    public Connection conection =null;
    
    java.util.Date date;
    
    private boolean read;
   
    
    
    public WorkDatabaseOffline(Database database) {
        super(database);
       
        conection = WorkerDatabase.conection;
        numberDatabase = database.database.ordinal();
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
//        if(date != null) System.out.println(date.toString());
//        else 
//            System.out.println("null");
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
                   +Integer.toString(database.id_database) + " AND TIME_LAST_CHANGED >= '" + chooseDate.format(d).toString()+"'"; 
        }else {
            sRead = "SELECT APP."+WorkerDatabase.nameTable+".* FROM "+ "APP."+WorkerDatabase.nameTable+" WHERE ID_DATABASES="+Integer.toString(database.id_database); 
        }
        String[] ss;   
        int key = 0;
        boolean printed = false;
         SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
         SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
        
         while(true){
         try{
            
            stmt = conection.createStatement();
            ResultSet rs = stmt.executeQuery(sRead); 
            
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
                
                Element el = new Element(database.DE, ss , key);              
                database.Data.add(el);
                
            }
            return;
       }
     catch(SQLException ex) {
        connect();
        conection = WorkerDatabase.conection;
    }
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
        
         
       
         Statement stmt = null;
        
         StringBuilder sb1 = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();
         sb1.append("\"APP\" . ");
         sb1.append("\""+WorkerDatabase.nameTable+"\" ");
         
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
           connect();
           conection = WorkerDatabase.conection;
           
        }
      } 
    }
  



    
    @Override
    public void removeElement(Element element) {
        
        String sql = "DELETE FROM APP."+  WorkerDatabase.nameTable + " WHERE "+
                    WorkerDatabase.unicateKey + " = " + Integer.toString(element.getKey());
        PreparedStatement statement = null;
        int key = element.getKey();
        while(true){
        try {
            statement = conection.prepareStatement(sql);
            statement.execute(); 
            database.Data.remove(element);
            WorkerDatabase.printedHashMap.remove(key);
            return;
        } catch (SQLException ex) {
            connect();
            conection = WorkerDatabase.conection;
        }
        }
    }

    
    @Override
    public void modifyElement(JPanelElement panelElement) {
        Element element = panelElement.element;
        for (int i = 0; i < panelElement.text.length; i++) {
            element.strings_of_elements[i] = ControlElement.contorlDatabaseElementAndReplece(panelElement.element.strings_of_elements[i], panelElement.element.DE[i]);
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
                    WorkerDatabase.unicateKey + "=" + Integer.toString(element.getKey());
       while(true){
        try {
            PreparedStatement statement = conection.prepareStatement(sql);
            statement.execute();
            return;
        } catch (SQLException ex) {
            connect();
            conection = WorkerDatabase.conection;
        }
       }
    }   
    
    
    
    public void connect(){
        JOptionPane  frame = new JOptionPane();
           Object[] options = {"Ukončit program",
                    "Obnovit spojení",};
            int n = JOptionPane.showOptionDialog(frame,
                 "Spadlo připojení s databází",
                    "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
             null,
            options,
            options[1]);
            if (n==0){
                
            try {
            conection.close();
            } catch (SQLException ex) {
            //Logger.getLogger(WorkDatabaseOffline.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
               
               System.exit(1); 
            }
            }         
    }
    



    
}
