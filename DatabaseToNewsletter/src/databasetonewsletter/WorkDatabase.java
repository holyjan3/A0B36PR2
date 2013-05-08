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
import javax.swing.JOptionPane;

/**
 *
 * @author Majitel
 */
public abstract class WorkDatabase {
    Database database;
    ReadFromDatabase rfd;
    SaveDatabese sd;
    public WorkDatabase(Database database) {
        this.database = database;
        rfd = new ReadFromDatabase();
        sd = new SaveDatabese();

    }
    public class ReadFromDatabase implements Runnable{        
        @Override
        public void run() {
            readFromDatabase();
        }
        
    
    }
    
    public class SaveDatabese implements Runnable{

        @Override
        public void run() {
           saveDatabese();
        }
        
    }
    
    abstract void readFromDatabase(); 
    
    
    
    abstract void removeElement(Element element);
    abstract void addElementt(Element element);
    abstract void modifyElement(JPanelElement element);
    
    public Element openElement(int number_element){
        return database.Data.get(number_element);
    }
    
    public boolean  saveDatabese(){
        ObjectOutputStream outputstream = null;
        boolean bb = true;
        String ss = "temp_" + database.name_file + ".txt";
        try {
            
            outputstream = new ObjectOutputStream(new FileOutputStream(ss));            
            outputstream.writeObject(database.Data);
         
        }catch (IOException ex) {
            bb = false;
            
        } finally {
            try {
                outputstream.close();
                tempToDatabase();
            } catch (IOException ex) {
                bb = false;
               
            } finally {
                if (bb) {
                return bb;
                } else {
                    JOptionPane.showMessageDialog(null, "Nepodařilo se uloži soubor, nejspíše je použván jiným pogramem", "", JOptionPane.ERROR_MESSAGE);    
                    return bb;
               }
            }
        }
    }
       
    public  void tempToDatabase() throws FileNotFoundException, IOException{
        
            String s1= "temp_" + database.name_file + ".txt";
            String s2= database.name_file+".txt";
            BufferedInputStream inputStream= null;
            BufferedOutputStream outputStream = null;
       
           inputStream = new BufferedInputStream(new FileInputStream(s1));
           outputStream = new BufferedOutputStream(new FileOutputStream(s2));
            
           
           
            int number = 1024;
            byte[] bitarray = new byte[number];
          
   
            while (inputStream.available()>0) {
                int i = inputStream.read(bitarray);
                outputStream.write(bitarray, 0, number);
                
            }
         
          outputStream.close();
          inputStream.close();
                    
               
                
     }
  
    
}
