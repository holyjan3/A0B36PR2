/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JFrameMainMenu extends JFrame{
ArrayList<Database> dataDatabases;   
    
    
    public JFrameMainMenu() {
       
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        dataDatabases  = new ArrayList<>(10);
        for (DataDatabase dataDatabase : DataDatabase.values()) {
            dataDatabases.add(new Database(dataDatabase));
        }
        
        add(new JPanelDatabases(dataDatabases));
         setVisible(true);
    
    
    }
    
    
}
