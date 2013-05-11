/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JFrameMenuAll extends JFrame{
JPanelMenuPrinted[] menus;
JPanel panel;
JScrollPane scrollPane;
    public JFrameMenuAll() {
        JPanel jp = new JPanel(new BorderLayout());
        menus = new JPanelMenuPrinted[WorkerDatabase.dataDatabases.size()];
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         panel =new JPanel(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.HORIZONTAL;
         
         c.gridx = 0;
      
        scrollPane = new JScrollPane();
        
        
        
        
        for (int i = 0; i < WorkerDatabase.dataDatabases.size(); i++) {
      
            JLabel l= new JLabel(WorkerDatabase.dataDatabases.get(i).name_database);
            panel.add(l,c);
            
            WorkerDatabase.dataDatabases.get(i).nowWorkDatabase.readFromDatabase();
            menus[i]= new JPanelMenuPrinted(WorkerDatabase.dataDatabases.get(i));
            
            panel.add(menus[i],c);
        
        
        }  
    scrollPane.setViewportView(panel);
    
    jp.add(scrollPane,BorderLayout.CENTER);
    jp.add(new JPanelMenlRight(),BorderLayout.EAST);
    add(jp);
    
       setSize(1000,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        this.setVisible(true);
    }
    
    
}
