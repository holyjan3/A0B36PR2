/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.DataControl.DATE;
import static databasetonewsletter.DataControl.TIME;
import static databasetonewsletter.DataControl.URL;
import static databasetonewsletter.DataControl.VARCHAR;

/**
 *
 * @author Majitel
 */
public class ControlElementDerby extends ControlElement{

   
    
    
    
    
    
    /**
     * metoda konrolující vstupní data
     * @param DE pro určení typu kontroly
     * @param ss vstupní řetezec
     * @return vrátí hodonu dle toho jestli vstupní řetězec odpovídá požadfovanému typu
     */
    public boolean controlDatabaseElement(DataElement DE, String ss) {
        int i = 0;
        boolean b = false;
           switch ((DE.type)) {
           case DATE:
                    b = controlDate(ss);
               break;
           case TIME:
                    b = controlTime(ss);
               break;
           case VARCHAR:
                    b = contolVarChar(ss, DE.date_size);
               break;
//           case TEXT:
//                    b = contolVarChar(ss, DE.date_size);
//               break;
           default:
               throw new AssertionError((DE.type).name());

        }
        return b;           
    }
       

    
    /**
     * metoda konrolující vstupní data
     * @param strings_of_element vstupní řetezec
     * @param DE pro určení typu kontroly
     * @return vrátí řetězec který zamezí strátě dat
     */
    public String contorlDatabaseElementAndReplece(String strings_of_element,DataElement DE) {
        int i = 0;
        String parse ="";
        switch (DE.type) {
           case DATE:
               if(controlDate(strings_of_element))
                    return strings_of_element;
                        else
                    return "";
           case TIME:
               if(controlTime(strings_of_element))
                    return strings_of_element;
                        else
               return "";
           case VARCHAR:
                         
                if(contolVarChar(strings_of_element,DE.date_size))
                    return strings_of_element;
                        else
                return strings_of_element.substring(0, DE.date_size);
           case URL:
               if(contolVarChar(strings_of_element,DE.date_size))
                    return strings_of_element;
                        else
                    return "";
           default:
               throw new AssertionError(DE.type.name());
        }
    }
    
    
    /**
     * metoda kontrolující maximálí déku řetězce
     * @param ss řetězec
     * @param MAX_SIZE maximální délka řetězce
     * @return
     */
  public boolean contolVarChar(String ss, int MAX_SIZE){
       if(ss.length()<=MAX_SIZE) {
           return true;
       }else {
           return false;
       }
   }
   
    
    /**
     * metoda kontrolující datum 
     * @param date datum ve formátu dd.mm.yyyy
     * @return
     */
    public boolean controlDate(String date){
       
      if (date.length()==10){
       String ss[] = date.split("[.]");
       int day = 0; 
       int month = 0;
       int year = 0;
       if(ss.length != 3)
           return false;
       try{
       day = Integer.parseInt(ss[0]);
       month = Integer.parseInt(ss[1]);
       year = Integer.parseInt(ss[2]);
       } catch (NumberFormatException e){
            return false;
       }
       if((0<day)&&(day<32)&&(0<month)&&(month<13)&&(2000<year)&&(year<3000)){
           return true;
       } else {
           return false;
       }
      } else {
          return false;
      }
   }
  
   
   
       
 

   
    
    /**
     * metoda konrolující čas
     * @param time čas ve formátu hh:mi
     * @return
     */
    public  boolean controlTime (String time){
       if (time.length()==5){
       String ss[] = time.split("[:]");
       int hour = 0;
       int minute = 0;
       if(ss.length != 2)
           return false;
       try{
       hour = Integer.parseInt(ss[0]);
       minute = Integer.parseInt(ss[1]);
       } catch (NumberFormatException e){
            return false;
       }
       if((0<=hour)&&(hour<=24)&&(0<=minute)&&(minute<60)){
           return true;
       } else {
           return false;
       }
      } else {
          return false;
      }
   }
    
}
