/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public class ControlInsert {

   
   static final int MAX_TEXT = 0;       
    
    
    public static String controlText(String ss){
            if(ss.length()<=MAX_TEXT){
              return ss;  
            } else {
                return ss.substring(1, MAX_TEXT);
            }
        }
    
   public static String contolVarChar(String ss, int MAX_SIZE){
       if(ss.length()<=MAX_SIZE) {
           return ss;
       }else {
           return ss.substring(0, MAX_SIZE);
       }
   }
   
   public static String controlDay(String day){
       int i_day = Integer.parseInt(day);
        
       if((0<i_day)&&(i_day<32)) {
            return Integer.toString(i_day);
       } else {
           return null;
       }
   }
   
   public static String controlMonth(String month){
       int i_month = Integer.parseInt(month);
        
       if((0<i_month)&&(i_month<13)) {
            return Integer.toString(i_month);
       } else {
           return null;
       }
   }
   
   public static String controlYear(String year){
       int i_year = Integer.parseInt(year);        
       if((2000<i_year)&&(i_year<3000)) {
            return Integer.toString(i_year);
       } else {
           return null;
       }
   }
   
   
   public static String controlHour (String hours){
       int i_hours = Integer.parseInt(hours);
       if ((0<=i_hours)&&(i_hours<=23)){
           return Integer.toString(i_hours);
       } else {
           return null;
       }
   }
   
   public static String controlMinut(String minuts){
       int i_minuts = Integer.parseInt(minuts);
       if ((0<=i_minuts)&&(i_minuts<=59)){
           return Integer.toString(i_minuts);
       } else {
           return null;
       }
   }
}
