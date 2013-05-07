/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.DataControl.URL;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author Majitel
 */
public class ControlElement {

   
       public static boolean controlDatabaseElement(DataElement DE, String ss) {
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
           case URL:
                b = controlURL(ss, DE.date_size);
               break;
           case TEXT:
                    b = contolVarChar(ss, DE.date_size);
               break;
           default:
               throw new AssertionError((DE.type).name());

        }
        return b;           
    }
       

    public static String contorlDatabaseElementAndReplece(String strings_of_element,DataElement DE) {
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
           case TEXT:               
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
    
   public static boolean contolVarChar(String ss, int MAX_SIZE){
       if(ss.length()<=MAX_SIZE) {
           return true;
       }else {
           return false;
       }
   }
   
   public static boolean controlDate(String date){
      if (date.length()==10){
       // odd2lovaccarkou
       String ss[] = date.split("[.]");
       int day = Integer.parseInt(ss[0]);
       int month = Integer.parseInt(ss[1]);
       int year = Integer.parseInt(ss[2]);
       if((0<day)&&(day<32)&&(0<month)&&(month<13)&&(2000<year)&&(year<3000)){
           return true;
       } else {
           return false;
       }
      } else {
          return false;
      }
   }
   
   public static boolean controlURL(String URLString , int MAX_SIZE){
       if (!contolVarChar(URLString, MAX_SIZE))
           return false;
  
    try {
      HttpURLConnection.setFollowRedirects(false);
      // note : you may also need
      
      HttpURLConnection con =
         (HttpURLConnection) new URL(URLString).openConnection();
      con.setRequestMethod("HEAD");
      return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
    }
    catch (Exception e) {
       //e.printStackTrace();
       return false;
    
  }  
  }
       
 

   
   public static boolean controlTime (String time){
       if (time.length()==5){
       String ss[] = time.split("[:]");
       int hour = Integer.parseInt(ss[0]);
       int minute = Integer.parseInt(ss[1]);
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
