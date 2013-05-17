/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;



/**
 * kontrola vstupních dat
 * @author Jan Holý
 */
public abstract class ControlElement {
   
    abstract public boolean controlDatabaseElement(DataElementInterface DE, String ss);

   
    abstract public String contorlDatabaseElementAndReplece(String strings_of_element,DataElementInterface DE) ;

    
    abstract public boolean controlDate(String date);

 
    abstract public boolean controlTime(String time);
    
    abstract public boolean contolVarChar(String ss, int MAX_SIZE);
    
    
    abstract public int dataSize(DataElementInterface de);
    
    
    
    
    
    
    
}
