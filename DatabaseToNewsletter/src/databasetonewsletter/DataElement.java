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
    
    PRINTED     (0,0,DataControl.BOOL,1),
    HEAD        (70,1,DataControl.VARCHAR,Constants.MaxVarChar),
    DATE        (2,2,DataControl.DATE, 10),
    TIME        (0,5,DataControl.TIME,  5),   
    HEAD_LINK   (0,7,DataControl.VARCHAR,Constants.MaxVarChar),
    TOWN        (20,8,DataControl.VARCHAR,Constants.MaxVarChar),
    PLACE       (0,9,DataControl.VARCHAR,Constants.MaxVarChar),
    TEXT        (0,10,DataControl.VARCHAR,Constants.MaxVarChar),
    TEXT_LINK   (0,0,DataControl.VARCHAR,Constants.MaxVarChar),
    LINK1_TEXT  (0,11,DataControl.VARCHAR,Constants.MaxVarChar),
    LINK2_TEXT  (0,12,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK3_TEXT  (0,13,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK1       (0,14,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK2       (0,15,DataControl.VARCHAR, Constants.MaxVarChar),
    LINK3       (0,16,DataControl.VARCHAR, Constants.MaxVarChar),
    NAME        (20,-1,DataControl.VARCHAR, Constants.MaxVarChar),
    MEDIUM      (20,-1,DataControl.VARCHAR, Constants.MaxVarChar),
    TYPE        (10,-1,DataControl.VARCHAR, Constants.MaxVarChar);    
    

    final int ELEMENT_FUTURE;
    final int LINE_SIZE;
    final int date_size;
    DataControl type;
    
    private DataElement(int LINE_SIZE,int ELEMENT_FUTURE, DataControl type,int date_size) {
        this.ELEMENT_FUTURE = ELEMENT_FUTURE;
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
        static int MaxVarChar = 2;
        static int MaxText = 2;
        
    }
    
}
