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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Majitel
 */
public class WorkDatabaseOffline extends WorkDatabase{    

    public WorkDatabaseOffline(Database database) {
        super(database);
    }
    
    
    
    @Override
    public void readFromDatabase(Date d) {
        ObjectInputStream inputstream = null;
        String ss = database.name_file + ".txt";
        
        try {
            inputstream = new ObjectInputStream(new FileInputStream(ss));
            database.Data = (List<Element>)inputstream.readObject();
            
        } catch (IOException ex) {
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeElement(Element element) {
        database.Data.remove(element);
    }

    @Override
    public void addElementt(Element element) {
        element.changed = true;
        Element el = element;
        database.Data.add(el);
    }

   
    
 

    @Override
    public void modifyElement(JPanelElement panelElement) {
        panelElement.element.changed = true;
        for (int i = 0; i < panelElement.text.length; i++) {
            panelElement.element.strings_of_elements[i] = ControlElement.contorlDatabaseElementAndReplece(panelElement.element.strings_of_elements[i], panelElement.element.DE[i]);
        }
    }

   

 
}
