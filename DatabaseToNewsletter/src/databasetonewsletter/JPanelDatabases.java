/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JPanelDatabases extends JPanel implements ActionListener{
    ArrayList<Database> databases;
    JFrameMainMenu frameMainMenu;
    
    
    public JPanelDatabases(ArrayList<Database> databases,JFrameMainMenu frameMainMenu) {
        this.databases = databases;
        this.frameMainMenu = frameMainMenu;
        
        setLayout(new GridLayout(3, 4));
        for (int i = 0; i < databases.size(); i++) {
            JButton jb  = new JButtonWithNumber(i,databases.get(i).name_database);
            jb.addActionListener(this);
            add(jb);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonWithNumber jbwn = (JButtonWithNumber) e.getSource();
        databases.get(jbwn.number).nowWorkDatabase.readFromDatabase();
        JFrameMenu jf = new JFrameMenu(databases.get(jbwn.number),frameMainMenu);
        frameMainMenu.setVisible(false);
    }
    
    
    
    
}
