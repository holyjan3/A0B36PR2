/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public class JFrameMainMenu extends JFrame {
     JPanelConection jpc;
     JPanelMainMenuTop menuTop;
    public JFrameMainMenu() {      
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        BorderLayout bl = new BorderLayout();
        menuTop = new JPanelMainMenuTop();
        jpc = new JPanelConection(this);
        
        this.addWindowListener(new Action());
        
        add(menuTop,BorderLayout.NORTH);
        add(new JPanelDatabases(WorkerDatabase.dataDatabases,this),BorderLayout.CENTER);
        
        add(jpc,BorderLayout.SOUTH);
        setSize(700,500);
        setVisible(true); 
        
    
    
    }
    @Override
        public void revalidate(){
        this.
        jpc.revalidate();
        super.revalidate();

    
    
     }
    
    class Action implements WindowListener {
        JPanelMainMenuTop menuTop1 = menuTop;
        
        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            GlobalSave.FOOTER = menuTop1.getFooter();
            GlobalSave.HEADING = menuTop1.getHeading();
            GlobalSave.saveText();
        }

        @Override
        public void windowClosed(WindowEvent e) {
           
        }

        @Override
        public void windowIconified(WindowEvent e) {
           
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
            
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
        }
        
    }
    
    
}