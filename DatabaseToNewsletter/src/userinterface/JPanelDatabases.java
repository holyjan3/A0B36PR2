/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import database.Database;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Panel tlačítek pro vstup do jednotlivých druhů záznamů umíctěn v JFrameMaiMenu
 * @author Jan Holý
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
       
        
        if(frameMainMenu.jpc.cal == null){
            databases.get(jbwn.number).Data.clear();
            databases.get(jbwn.number).nowWorkDatabase.readFromDatabase(null);
        } else {
            databases.get(jbwn.number).Data.clear();
            databases.get(jbwn.number).nowWorkDatabase.readFromDatabase(frameMainMenu.jpc.cal.getDate());
        }
        
        JFrameMenu jf = new JFrameMenu(databases.get(jbwn.number),frameMainMenu);
    }
    
    
    
    
}
