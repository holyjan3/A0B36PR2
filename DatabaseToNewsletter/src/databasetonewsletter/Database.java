/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */

public abstract class Database {
    protected List<Element> Data;
    protected String name_database;
    protected DataElement[] DE;
    private int number_of_element;
    
    public Database(String name_database) {
        
        this.name_database = name_database;
        this.Data  = new LinkedList<Element>();
        this.DE = findDataElements();
        
    }
    
    public void removeElement(String head) {
       
        for (int i=0; i<Data.size();i++) {
            if(Data.get(i).strings_of_elements[1].compareTo(head) == 0) {
               number_of_element--;
               Data.remove(i);
               break;
            }
        }
    }
    
   
    
    public void addElement(String[] ss){
        Element el = new Element(DE, ss);
        Data.add(el);                
    }
    
    
    public void changeElements(String head,String ss,int position_string ){
      
        
    } 
    
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    }
    
    
    
    public  void readFromDatabase(){
       ObjectInputStream inputstream = null;
        String ss = name_database + ".txt";
        
        try {
            inputstream = new ObjectInputStream(new FileInputStream(ss));
            Data = (List<Element>)inputstream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeToTemp(){
        ObjectOutputStream outputstream = null;
        String ss = "temp_" + name_database + ".txt";
        try {
            
            outputstream = new ObjectOutputStream(new FileOutputStream(ss));            
            outputstream.writeObject(Data);
         
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
        
            String s1= "temp_" + name_database + ".txt";
            String s2= name_database+".txt";
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
    
    public void sortDate() {
        Collections.sort(Data,new CompareDate());
    }
    
    public void sortString(int number) {
        Collections.sort(Data, new CompareString(number));
    }
    
    public void sortPrint(){
        Collections.sort(Data,new ComparatorPrint());
    }

    
    abstract   public DataElement[] findDataElements();
    
}
