/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import javax.swing.JFrame;

/**
 *
 * @author Majitel
 */
public class DatabaseToNewsletter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new DatabaseEventFuture("ahoj");
        JFrame jf = new JFrameMenu(database);
        
    }
}
