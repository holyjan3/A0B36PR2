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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class WorkkDatabaseOffline implements WorkDatabase{
    Database database;

    public WorkkDatabaseOffline(Database database) {
        this.database = database;
    }
    
    @Override
    public void readFromDatabase() {
        ObjectInputStream inputstream = null;
        String ss = database.name_file + ".txt";
        
        try {
            inputstream = new ObjectInputStream(new FileInputStream(ss));
            database.Data = (List<Element>)inputstream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeElement(Element element) {
        database.Data.remove(element);
    }

    @Override
    public void addElementt(Element element) {
        Element el = element;
        database.Data.add(el);
    }

    @Override
    public void saveDatabese() {
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
            BufferedOutputStream outputstream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(s1));
            } catch (FileNotFoundException ex) { 
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                outputstream = new BufferedOutputStream(new FileOutputStream(s2));
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
                outputstream.write(bitarray, 0, number);
            }
            } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
            
                    
    }

    @Override
    public void setStringElement(int numberElement, int numberString, String ss) {
        database.Data.get(numberElement).setString_of_element(ss, numberString);
    }


    
}
