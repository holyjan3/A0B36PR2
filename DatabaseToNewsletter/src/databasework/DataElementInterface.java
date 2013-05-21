/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import database.DataControl;

/**
 *
 * @author Majitel
 */
public interface DataElementInterface {
    public String toStringSort();
    public String name();
    public boolean sort();
    public DataControl getType();
    public int getLINE_SIZE();
    public int dataSize();
    public int numberLine();
}
