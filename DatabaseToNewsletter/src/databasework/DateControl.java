/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jan Holýl
 */
public abstract class DateControl {
  
   
    abstract public Date getDate();

   
    abstract public Date getDefolteDate();

    
    abstract public void setDate(Date date);
}
