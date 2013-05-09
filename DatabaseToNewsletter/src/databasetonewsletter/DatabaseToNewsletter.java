/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Majitel
 */
public class DatabaseToNewsletter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        
        WorkerDatabase.WorkerDatabase();     
        
        try {
            
           Thread th= null;
           th= new Thread(new ControlConection(th));
           th.start();
            
           new JFrameMainMenu();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
