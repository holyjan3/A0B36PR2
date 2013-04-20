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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class ElementsChanged {
    private HashSet<String> ElementsChanges = new HashSet<String>();
    private HashSet<String> ElementsDelete = new HashSet<String>();
    private HashSet<String> ElementsInsert = new HashSet<String>();
    private String name_database;

    public ElementsChanged(String name_database) {
        this.name_database = name_database;
    }
    
    

    public void insertElementsChanges(String head) {
        ElementsChanges.add(head);
    }
    
    public  void insertElementsChanges(String headOld,String headNew) {
        ElementsChanges.remove(headOld);
        ElementsInsert.remove(headOld);
        ElementsDelete.add(headOld);
        ElementsInsert.add(headNew);
    }

    public  void insetrElementsDelete(String head) {
        ElementsChanges.remove(head);
        ElementsInsert.remove(head);
        ElementsDelete.add(head);
    }

    public void insetrElementsInsert(String head) {
        ElementsInsert.add(head);
    }
    
   public  void readFromDatabase(){
       ObjectInputStream inputstream = null;
        String ss ="changed_"+ name_database + ".txt";
        
        try {
            inputstream = new ObjectInputStream(new FileInputStream(ss));
            this.ElementsChanges= (HashSet<String>) inputstream.readObject();
            this.ElementsDelete= (HashSet<String>) inputstream.readObject();
            this.ElementsInsert=(HashSet<String>) inputstream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeToTemp(){
        ObjectOutputStream outputstream = null;
        String ss = "temp_"+"_changed_" + name_database + ".txt";
        try {
            
            outputstream = new ObjectOutputStream(new FileOutputStream(ss));            
            outputstream.writeObject(ElementsChanges);
            outputstream.writeObject(ElementsDelete);
            outputstream.writeObject(ElementsInsert);
            
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
        
            String s1= "temp_"+"_changed_"+ name_database + ".txt";
            String s2= "changed_"+name_database+".txt";
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
    
    
}
