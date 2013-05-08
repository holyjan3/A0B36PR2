/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.Serializable;



/**
 *
 * @author Majitel
 */
final public class Element implements  Serializable{
    
    protected DataElement[] DE;    
    protected String[] strings_of_elements;
    protected boolean printed; // nastavi jestli se bude tisknout
    protected boolean changed;
    protected int key = 0;
    
    public Element(DataElement[] DE,String[] strings_of_elements) {
        this.DE = DE;
        //this.strings_of_elements = ControlElement.contorlStringElement(strings_of_elements, DE);
        changed = false;
        printed = Boolean.parseBoolean(strings_of_elements[0]);
    }
    
    
    
    public Element(DataElement[] DE) {
        this.DE = DE;        
        changed = false;
        strings_of_elements = new String[DE.length];
        printed = Boolean.parseBoolean(strings_of_elements[0]);
        for (int i = 1; i < DE.length; i++) {
            strings_of_elements[i] = "";
        }
        
    }
    
    public void setStringPrinted(boolean b){
        strings_of_elements[0] = Boolean.toString(b);
        this.printed = b;
    }
    
    

    public boolean isPrinted() {
        return printed;
    }

    
    
    
    /*
    public Element(DataElement[] DE, String strin_of_elements){
        this.DE = DE;
        this.strings_of_elements  = parseString(strin_of_elements);
    }

    
    
    */
     

    
    public void setString_of_element(String ss,int i) {
           this.strings_of_elements[i] = ss;
    }
    
    /*
    public String[] parseString(String string_to_parse){
        String[] ss = string_to_parse.split("[#]");
        for (int i = 0; i < this.DE.length; i++) {
            if(ss.length < i) {
            this.strings_of_elements[i] = controlDatabaseElement(DE[i], ss[i]);
            } else {
            this.strings_of_elements[i] = "";    
            }
        }
        return ss;
    }
    */
    
   
    
    /*
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.strings_of_elements.length-1; i++) {
            sb.append(this.strings_of_elements[i]);
            sb.append("#");
        }
        sb.append(this.strings_of_elements[this.strings_of_elements.length-1]);
        return sb.toString();
    }
    * 
    */
    
}
