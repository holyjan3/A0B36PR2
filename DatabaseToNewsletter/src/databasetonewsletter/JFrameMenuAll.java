/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;

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
            panel.setBackground(Color.black);
            l.setForeground(Color.white);
            panel.setOpaque(true);
            
            panel.add(menus[i],c);
            Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            menus[i].setBorder(BorderFactory.createCompoundBorder(border,paddingBorder)); 
        
        
        }  
    scrollPane.setViewportView(panel);
    
    jp.add(scrollPane,BorderLayout.CENTER);
    jp.add(new JPanelMenulRight(this),BorderLayout.EAST);
    add(jp);
    
       setSize(1000,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        this.setVisible(true);
    }
    
    
}
