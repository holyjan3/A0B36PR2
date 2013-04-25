/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.Comparator;

/**
 *
 * @author Majitel
 */
public class CompareDate implements Comparator<Element>{

    @Override
    public int compare(Element o1, Element o2) {
        int i = 0;
        int year2 = 0; int month2 = 0; int day2= 0; //int hour2= 0; int minute2 = 0;
        int year1 = 0; int month1 = 0; int day1= 0;//int hour1 = 0; int minute1 = 0;
        
        try{
        year1 = Integer.parseInt(o1.strings_of_elements[DataElement.YEAR.ordinal()]);
        month1 = Integer.parseInt(o1.strings_of_elements[DataElement.MONTH.ordinal()]);
        day1 = Integer.parseInt(o1.strings_of_elements[DataElement.DAY.ordinal()]);        
        //hour1 = Integer.getInteger(o1.strings_of_elements[DataElement.HOUR.ordinal()]);       
        //minute1 = Integer.getInteger(o1.strings_of_elements[DataElement.MINUTE.ordinal()]);
        } catch(NumberFormatException ne){
            return 1;
        }
        
        try{
        year2 = Integer.parseInt(o2.strings_of_elements[DataElement.YEAR.ordinal()]);
        month2 = Integer.parseInt(o2.strings_of_elements[DataElement.MONTH.ordinal()]);
        day2 = Integer.parseInt(o2.strings_of_elements[DataElement.DAY.ordinal()]);
        //hour2 = Integer.getInteger(o2.strings_of_elements[DataElement.HOUR.ordinal()]);
        //minute2 = Integer.getInteger(o2.strings_of_elements[DataElement.MINUTE.ordinal()]);
        } catch (NumberFormatException ne) {
            return -1;
        }
        
        if(year1 != year2) {
            i = year1-year2; 
        } else {
            if(month1 != month2){
                i = month1- month2;
            } else {
                if (day1 != day2) {
                    i = day1-day2;
                } /*else {
                    if(hour1 != hour2){
                        i = hour1-hour2;
                    }else {
                        i = minute1 - minute2;
                    }
                }*/
            }
        }
        return i;
    }
    
}
