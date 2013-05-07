/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.Serializable;


/**
 *
 * @author Majitel
 */
public enum DataElement{
    
    PRINTED     (0,DataControl.BOOL,1),
    HEAD        (700,DataControl.VARCHAR,Constants.MaxVarChar),
    DATE        (100,DataControl.DATE, 10),
    TIME        (0,DataControl.TIME,  5),   
    HEAD_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    TOWN        (200,DataControl.VARCHAR,Constants.MaxVarChar),
    PLACE       (0,DataControl.VARCHAR,Constants.MaxVarChar),
    TEXT        (800,DataControl.VARCHAR,Constants.MaxVarChar),
    TEXT_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    LINK1_TEXT  (0,DataControl.VARCHAR,Constants.MaxVarChar),
    LINK2_TEXT  (0,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK3_TEXT  (0,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK1       (0,DataControl.URL, Constants.MaxVarChar),
    LINK2       (0,DataControl.URL, Constants.MaxVarChar),
    LINK3       (0,DataControl.URL, Constants.MaxVarChar),
    NAME        (200,DataControl.VARCHAR, Constants.MaxVarChar),
    MEDIUM      (200,DataControl.VARCHAR, Constants.MaxVarChar),
    TYPE        (80,DataControl.VARCHAR, Constants.MaxVarChar);    
    


    final int LINE_SIZE;
    final int date_size;
    DataControl type;
    
    private DataElement(int LINE_SIZE, DataControl type,int date_size) {
  
        this.LINE_SIZE = LINE_SIZE;
        this.type = type;
        this.date_size = date_size;
    }
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toStringSort() {
        return super.toString();
    }
    
    public boolean sort(){
        switch (this) {
            //case PRINTED:   
            case DATE:           
            case TOWN:
            case NAME:
            case MEDIUM:
                return true;               
            default:
                return false;
            }
    }
    
    public boolean controlLinks(){
        switch (this) {
            case LINK1:
            case LINK2:
            case LINK3:
            case HEAD_LINK: 
                return true;
            default:
                return false;
        }
    }
    static class  Constants {
        static int MaxVarChar = 65535;
        static int MaxText = 65535;
        
    }
    
}
