/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;


/**
 *
 * @author Majitel
 */
public enum DataElement {
    PRINTED     (0,0),
    HEAD        (70,1),
    DAY         (2,2),
    MONTH       (2,3),
    YEAR        (0,4),
    HOUR        (0,5),
    MINUTE      (0,6),    
    HEAD_LINK   (0,7),
    TOWN        (20,8),
    PLACE       (0,9),
    TEXT        (0,10),
    TEXT_LINK   (0,0),
    LINK1_TEXT  (0,11),
    LINK2_TEXT  (0,12),
    LINK3_TEXT  (0,13),
    LINK1       (0,14),
    LINK2       (0,15),
    LINK3       (0,16),
    NAME        (20,-1),
    MEDIUM      (20,-1),
    TYPE        (10,-1);
    
    final int ELEMENT_FUTURE;
    final int LINE_SIZE;

    private DataElement(int LINE_SIZE,int ELEMENT_FUTURE) {
        this.ELEMENT_FUTURE = ELEMENT_FUTURE;
        this.LINE_SIZE = LINE_SIZE;
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
            case DAY:
            case MONTH:                   
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
    
}
