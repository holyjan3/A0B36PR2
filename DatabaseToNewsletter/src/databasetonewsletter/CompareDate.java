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
        int year1 = Integer.getInteger(o1.strings_of_elements[DataElements.YEAR.ordinal()]);
        int year2 = Integer.getInteger(o2.strings_of_elements[DataElements.YEAR.ordinal()]);
        int month1 = Integer.getInteger(o1.strings_of_elements[DataElements.MONTH.ordinal()]);
        int month2 = Integer.getInteger(o2.strings_of_elements[DataElements.MONTH.ordinal()]);
        int day1 = Integer.getInteger(o1.strings_of_elements[DataElements.DAY.ordinal()]);
        int day2 = Integer.getInteger(o2.strings_of_elements[DataElements.DAY.ordinal()]);
        int hour1 = Integer.getInteger(o1.strings_of_elements[DataElements.HOUR.ordinal()]);
        int hour2 = Integer.getInteger(o2.strings_of_elements[DataElements.HOUR.ordinal()]);
        int minute1 = Integer.getInteger(o1.strings_of_elements[DataElements.MINUTE.ordinal()]);
        int minute2 = Integer.getInteger(o2.strings_of_elements[DataElements.MINUTE.ordinal()]);
        
        if(year1 != year2) {
            i = year1-year2; 
        } else {
            if(month1 != month2){
                i = month1- month2;
            } else {
                if (day1 != day2) {
                    i = day1-day2;
                } else {
                    if(hour1 != hour2){
                        i = hour1-hour2;
                    }else {
                        i = minute1 - minute2;
                    }
                }
            }
        }
        return i;
    }
    
}
