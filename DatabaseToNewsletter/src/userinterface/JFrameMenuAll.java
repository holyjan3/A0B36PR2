/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import createemail.CreateEmail;
import databasework.WorkerDatabase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 * okno se záznamy všech druhů
 * @author Jan Holý
 */
public class JFrameMenuAll extends JFrame{

    JPanelMenuPrinted[] menus;

    JPanel panel;

    JScrollPane scrollPane;

    Date date;
    

    public JFrameMenuAll(Date date) {
        this.date = date;
        JPanel jp = new JPanel(new BorderLayout());
        menus = new JPanelMenuPrinted[WorkerDatabase.conectDatabeses.getDataDatabases().size()];
        
       
        
         panel =new JPanel(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.HORIZONTAL;
         
         c.gridx = 0;
      
        scrollPane = new JScrollPane();
        
        
        
        
        for (int i = 0; i < WorkerDatabase.conectDatabeses.getDataDatabases().size(); i++) {
      
            
            
            WorkerDatabase.conectDatabeses.getDataDatabases().get(i).Data.clear();
            WorkerDatabase.conectDatabeses.getDataDatabases().get(i).nowWorkDatabase.readFromDatabase(date);
            menus[i]= new JPanelMenuPrinted(WorkerDatabase.conectDatabeses.getDataDatabases().get(i));
            menus[i].AddPanel();
            
            
            
            panel.add(menus[i],c);
            Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            menus[i].setBorder(BorderFactory.createCompoundBorder(border,paddingBorder)); 
        
        
        }  
    scrollPane.setViewportView(panel);
    scrollPane.setBackground(Color.black);
    scrollPane.setOpaque(true);
    jp.add(scrollPane,BorderLayout.CENTER);
    jp.add(new JPanelMenuAllRight(this),BorderLayout.EAST);
    add(jp);
    
       setSize(1000,1000);
       
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       
        this.setVisible(true);
    }
    
    
}
