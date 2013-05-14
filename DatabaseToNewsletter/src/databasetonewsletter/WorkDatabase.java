/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import databasetonewsletter.userinterface.JPanelElement;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public abstract class WorkDatabase {
    
    Database database;
    
    ReadFromDatabase rfd;
    
    
    
    public WorkDatabase(Database database) {
        this.database = database;
        rfd = new ReadFromDatabase();        

    }
    
    
    public class ReadFromDatabase implements Runnable{        
        @Override
        public void run() {
            readFromDatabase(null);
        }
        
    
    }
    
    
    
    public  abstract void readFromDatabase(Date d); 
    
    
    
    
    public abstract void removeElement(Element element);
    
    public abstract void addElementt(Element element);
    
    public abstract void modifyElement(JPanelElement element);
    
    
    public Element openElement(int number_element){
        return database.Data.get(number_element);
    }
    
      
    
}
