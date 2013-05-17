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
public class GlobalDate extends GlobalDateAb{

         /**
     * globální datum pro výběr záznamů
     */
    private java.util.Date date;
    public Date getDate() {
            return date;
        }
    public Date getDefolteDate(){
    Calendar c = Calendar.getInstance(); 
    c.setTime(new Date());    
    c.add(Calendar.MONTH, -2);
    Date date = c.getTime();  
    date.setHours(0);
    date.setMinutes(0);
    date.setSeconds(0);
    return  date;      
   }

    public void setDate(Date date) {
            this.date = date;
    }
    
}
