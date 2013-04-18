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
    protected HashMap<String,Element>DataHash;
    protected String name_database;
    protected DataElements[] DE;
    private ElementsChanged elememtChan = new ElementsChanged();
    
    public Database(String name_database) {
        
        this.name_database = name_database;
        this.Data  = new LinkedList<Element>();
        this.DataHash = new HashMap<String,Element>();
        this.DE = findDataElements();
        
    }
    
     public void contensHead(String head){
        if(DataHash.containsKey(head)) {
            
        }
    }
    
    public void removeElement(String head) {
        DataHash.remove(head);
        for (int i=0; i<Data.size();i++) {
            if(Data.get(i).strings_of_elements[1].compareTo(head) == 0) {
               Data.remove(i);
               break;
            }
        }
        this.elememtChan.insetrElementsDelete(head);
    }
    
   
    
    public void addElement(String[] ss){
        Element el = new Element(DE, ss);
        contensHead(el.strings_of_elements[1]);
        Data.add(el);        
        DataHash.put(el.strings_of_elements[1], el);
        this.elememtChan.insertElementsChanges(name_database);
        
    }
    
    public void changeElements(String head,String ss,int position_string ){
        Element el = DataHash.get(head);
        if (position_string != 1) {            
            el.strings_of_elements[position_string] = ss;
            this.elememtChan.insertElementsChanges(head);
        } else {
           contensHead(ss);
           for (int i=0; i<Data.size();i++) {
            if(Data.get(i).strings_of_elements[1].compareTo(head) == 0) {
                Data.get(i).strings_of_elements[1] = ss;
                DataHash.remove(ss);
                DataHash.put(ss, el);
                break;
            }
           this.elememtChan.insertElementsChanges(head,ss);
        }                      
        }
        
    } 
    
    public void replaceElements(int i, int j){
        Element ob = Data.get(i);
        Data.add(i, Data.get(j));
        Data.add(j, ob);
    }
    
    
    
    public  void readFromDatabase(){
        
    }
    
    public void writeToTemp(){
        FileWriter fw = null;
        try {
            String ss = "temp_" + name_database + ".txt";
            fw = new FileWriter(ss);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < this.Data.size(); i++) {
                fw.write(Data.get(i).toString());
                fw.write(System.lineSeparator());
            }
            fw.close();
            tempToDatabase();
        }catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    public  void tempToDatabase(){
        String s1= "temp_" + name_database + ".txt";
        String s2= name_database+".txt";
        File f1 = new File(s1);
        File f2 = new File(s2);
        if(f2.delete()) {
            f1.renameTo(f2);
        }
    }
    
    abstract   public DataElements[] findDataElements();
    
}
