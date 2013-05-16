/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import databasedata.DataElement;
import databasedata.DataElement;
import static databasedata.DataControl.URL;



/**
 * kontrola vstupních dat
 * @author Jan Holý
 */
public abstract class ControlElement {
   
    abstract public boolean controlDatabaseElement(DataElement DE, String ss);

   
    abstract public String contorlDatabaseElementAndReplece(String strings_of_element, DataElement DE) ;

    
    abstract public boolean controlDate(String date);

 
    abstract public boolean controlTime(String time);
    
    abstract public boolean contolVarChar(String ss, int MAX_SIZE);
    
    
    
    
    
    
    
    
    
    
}
