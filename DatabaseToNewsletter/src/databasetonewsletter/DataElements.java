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
    PRINTED(0),
    HEAD(1),
    DAY(2),
    MONTH(3),
    YEAR(4),
    HOUR(5),
    MINUTE(6),    
    HEAD_LINK(7),
    TOWN(8),
    PLACE(9),
    TEXT(10),
    LINK1_TEXT(11),
    LINK2_TEXT(12),
    LINK3_TEXT(13),
    LINK1(14),
    LINK2(15),
    LINK3(16),
    NAME(-1),
    MEDIUM(-1);
    
    final int ELEMENT_FUTURE;
    

    private DataElements(int ELEMENT_FUTURE) {
        this.ELEMENT_FUTURE = ELEMENT_FUTURE;
    }

    
    
}
