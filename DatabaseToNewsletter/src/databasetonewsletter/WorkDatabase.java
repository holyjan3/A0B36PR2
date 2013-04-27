/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public interface WorkDatabase {
    void readFromDatabase();
    void removeElement(Element element);
    void addElementt(Element element);    
    void saveDatabese();
    void modifyElement(JPanelElement element);
    Element openElement(int number_element);
}
