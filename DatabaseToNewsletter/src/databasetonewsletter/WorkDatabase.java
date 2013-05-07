/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public abstract class WorkDatabase {
    Database database;
    public WorkDatabase(Database database) {
        this.database = database;
    }
    abstract void readFromDatabase();
    abstract void removeElement(Element element);
    abstract void addElementt(Element element);
    abstract void modifyElement(JPanelElement element);
    abstract Element openElement(int number_element);
    abstract void saveDatabese();
  
    
}
