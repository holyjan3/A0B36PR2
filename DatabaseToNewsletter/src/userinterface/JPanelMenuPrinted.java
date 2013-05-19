/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import databasefinal.Database;
import databasework.WorkerDatabase;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * třída odvozená od JpanelMenu nemá horní panel s tlačíty
 * @author Jan Holý
 */
public class JPanelMenuPrinted extends JPanelMenu{


    public JPanelMenuPrinted(Database database) {
        super(database);  
    
    
    }    

    @Override
    public void AddPanel() {
        JLabel l= new JLabel(database.name_database);
        l.setForeground(Color.white);
           
        add(l,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        add(pane,BorderLayout.SOUTH);  //To change body of generated methods, choose Tools | Templates.
        setBackground(Color.black);
        setOpaque(true);
    
    }

 
   
    
}
