/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

/**
 *
 * @author Majitel
 */
public interface DataDatabaseInteraface {
    public int getMax();
    public String getName();
    public DataElementInterface[] getDataElemen();
    public  DataDatabaseInteraface[] valuesReturn();
    public String name();
}
