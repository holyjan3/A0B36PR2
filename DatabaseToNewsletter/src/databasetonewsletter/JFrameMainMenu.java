/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public class JFrameMainMenu extends JFrame {
     JPanelConection jpc;
    public JFrameMainMenu() {      
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        BorderLayout bl = new BorderLayout();
        jpc = new JPanelConection(this);
        
        
        add(new JPanelMainMenuTop(),BorderLayout.NORTH);
        add(new JPanelDatabases(WorkerDatabase.dataDatabases),BorderLayout.CENTER);
        
        add(jpc,BorderLayout.SOUTH);
        setSize(700,500);
        setVisible(true); 
        
    
    
    }
    @Override
        public void revalidate(){
        jpc.revalidate();

    
    
     }
}