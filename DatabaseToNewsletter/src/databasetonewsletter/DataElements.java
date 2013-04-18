/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;


/**
 *
 * @author Majitel
 */
public enum DataElements {
    DAY(0),
    MONTH(1),
    YEAR(2),
    HOUR(3),
    MINUTE(4),
    HEAD(5),
    HEAD_LINK(6),
    TOWN(7),
    PLACE(8),
    TEXT(9),
    LINK1_TEXT(10),
    LINK2_TEXT(11),
    LINK3_TEXT(12),
    LINK1(13),
    LINK2(14),
    LINK3(15),
    NAME(-1),
    MEDIUM(-1);
    
    final int ELEMENT_FUTURE;
    

    private DataElements(int ELEMENT_FUTURE) {
        this.ELEMENT_FUTURE = ELEMENT_FUTURE;
    }

    
    
}
