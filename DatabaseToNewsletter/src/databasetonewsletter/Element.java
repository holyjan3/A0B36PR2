/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.Date;




/**
 * reprezentace jednotlivých záznamů v programu
 * @author Jan Holý
 */
final public class Element{
    
    
    public DataElement[] DE;    
    public String[] strings_of_elements;
    private boolean printed;
    private int key;   


  
    
   
    
    /**
     * Vytvoří a vyplní nový záznam
     * @param DE určení typu položek záznamu
     * @param strings_of_elements pole všech typů záznamů
     * @param key unikátní klíč
     */
    public Element(DataElement[] DE,String[] strings_of_elements , int key) {
        this.DE = DE;
        printed = false;
        this.key = key;
        
        this.strings_of_elements = strings_of_elements;
        
        if(WorkerDatabase.printedHashMap.containsKey(this.key)){
            printed = WorkerDatabase.printedHashMap.get(this.key);
        }else {
            WorkerDatabase.printedHashMap.put(this.key, false);
            
        }
    }
    
    
    
    /**
     * Vytvoří prázdný nový záznam
     * @param DE určení typu položek záznamu
     */
    public Element(DataElement[] DE) {
        this.DE = DE;        
        printed = false;
        this.key = -1;
        strings_of_elements = new String[DE.length];
        for (int i = 0; i < DE.length; i++) {
            strings_of_elements[i] = "";
        }
        
    }
    
     
    
    
    /**
     *  nastaví zda se má záznam vložit do emailu
     * @param b true - vložit / false nevložit
     */
    public void setPrinted(boolean b){
    this.printed = b;
    }
    
    
    /**
     * nastaví zda se má záznam vložit do emailu a uloží identifikační key číslo s hodonout(false / true ) podle parametru b do WorkerDatabase.printedHashMap 
     * @param b true - vložit / false nevložit
     * @param key unikátní klíč
     */
    public void setPrinted(boolean b,int key){
        this.printed = b;
        WorkerDatabase.printedHashMap.put(key, b);        
    }

    
    /**
     * vrátí true jestli je záznam určen k vložení jinak vrátí false
     * @return
     */
    public boolean isPrinted() {        
        return printed;
        
    }
    
    /**
     * nastaví položku záznamu
     * @param ss řetězec záznamu
     * @param i pořadí v  {@link #strings_of_elements} 
     */
    public void setString_of_element(String ss,int i) {
           this.strings_of_elements[i] = ss;
    }
    

      /**
     * nastavý unikátní klíč záznamu
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /** 
     * zjistí unikátní klíč záznamu
     * @return
     */
    public int getKey() {
        return key;
    }
}
