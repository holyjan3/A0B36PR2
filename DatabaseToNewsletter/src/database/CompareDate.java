/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import databasework.DataElement;
import java.util.Comparator;
import sun.security.util.Cache;


/**
 * Comparator třídy Element podle data a času,  čas musí být hned za datem jinak se porovná pouze podle data porovnání je stabilní
 * @author Jan Holý
 */
public class CompareDate implements Comparator<Element>{
    int compare;

    
    /**
     * 
     * @param compare pořadí porovnávaného stringu v pořadí
     */
    public CompareDate(int compare) {
        this.compare = compare;
    }
    

    @Override
    public int compare(Element o1, Element o2) {
        
        
    
        int year2 = 0; int month2 = 0; int day2= 0; int hour2= 0; int minute2 = 0;
        int year1 = 0; int month1 = 0; int day1= 0; int hour1 = 0; int minute1 = 0;
        
       try{         
        if((o1.strings_of_elements[compare] == null)&&(o2.strings_of_elements[compare] == null)){
            return 0;
        }
        
         if(o1.strings_of_elements[compare] == null){
            return 1;
        }
        
        if(o2.strings_of_elements[compare] == null){
            return -1;
        }
    
        String[] ssD1 = o1.strings_of_elements[compare].split("[.]");
        String[] ssD2 = o2.strings_of_elements[compare].split("[.]");
        
        String[] ssT1;
        String[] ssT2;
       if((ssD1.length != 3)&& (ssD1.length != 3)){
           return 0;
       }
     
        if(ssD1.length == 3){
            day1 = Integer.parseInt(ssD1[0]);
            month1 = Integer.parseInt(ssD1[1]);
            year1 = Integer.parseInt(ssD1[2]);
        } else {
            return 1;
        }
        
        if(ssD2.length == 3){
            day2 = Integer.parseInt(ssD2[0]);
            month2 = Integer.parseInt(ssD2[1]);
            year2 = Integer.parseInt(ssD2[2]);            
        } else {
            return -1;
        }
        
        if(year1 != year2) {
            return year1-year2; 
        } else {
            if(month1 != month2){
                return month1- month2;
            } else {
                if (day1 != day2) {
                    return day1-day2;
                }
            }     
         }           
                 
        
                    
                    
                    
   if(o1.DE[compare+1] == DataElement.TIME){
          if(o1.strings_of_elements[compare+1] == null && o2.strings_of_elements[compare+1] == null ){
                       return  0;
          } 
                    
                    
          if(o1.strings_of_elements[compare+1] == null ){
                       return  1;
            } 
                    
         if(o2.strings_of_elements[compare+1] == null ){
                       return  -1;
         } 
         
         ssT1 = o1.strings_of_elements[compare+1].split("[:]");
         ssT2 = o2.strings_of_elements[compare+1].split("[:]");
                    
        
         if((ssT1.length != 2)&& (ssT2.length != 2)){
           return 0;
          }
      
         
         if(ssT1.length == 2){
          hour1 = Integer.parseInt(ssT1[0]);
          minute1 = Integer.parseInt(ssT1[1]);
         } else {
          return 1;
         }
                   
         if(ssT2.length == 2){
            hour2 = Integer.parseInt(ssT2[0]);
            minute2 = Integer.parseInt(ssT2[1]);        
            } else {
               return -1;
          }
                
        if(hour2!= hour1){
           return hour1- hour2;
          }else {
           return minute1-minute2;
            }   
          
       }else {
                return 0;
                    }
    }catch (NumberFormatException e){
         
        return 0;
 
    }
    

    }
 }