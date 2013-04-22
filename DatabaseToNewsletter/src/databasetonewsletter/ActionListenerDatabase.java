/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Majitel
 */
public class ActionListenerDatabase implements ActionListener{
    Database database;

    public ActionListenerDatabase(Database database) {
        this.database = database;        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
