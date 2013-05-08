/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public abstract class WorkDatabase {
    Database database;
    public WorkDatabase(Database database) {
        this.database = database;
    }
    abstract void readFromDatabase();
    abstract void removeElement(Element element);
    abstract void addElementt(Element element);
    abstract void modifyElement(JPanelElement element);
    
    public Element openElement(int number_element){
        return database.Data.get(number_element);
    }
    
    public void saveDatabese(){
        ObjectOutputStream outputstream = null;
        String ss = "temp_" + database.name_file + ".txt";
        try {
            
            outputstream = new ObjectOutputStream(new FileOutputStream(ss));            
            outputstream.writeObject(database.Data);
         
        }catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputstream.close();
                tempToDatabase();
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       
    public  void tempToDatabase(){
        
            String s1= "temp_" + database.name_file + ".txt";
            String s2= database.name_file+".txt";
            BufferedInputStream inputStream= null;
            BufferedOutputStream outputStream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(s1));
            } catch (FileNotFoundException ex) { 
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(s2));
            } catch (FileNotFoundException ex) { 
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            int number = 1024;
            byte[] bitarray = new byte[number];
          
            try {
            while (inputStream.available()>0) {
                int i = inputStream.read(bitarray);
                outputStream.write(bitarray, 0, number);
                
            }
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    outputStream.close();
                    inputStream.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(WorkDatabaseOffline.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
  
    
}

}