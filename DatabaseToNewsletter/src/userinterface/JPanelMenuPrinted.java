/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import databasedata.Database;
import java.awt.BorderLayout;

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
        add(scrollPane,BorderLayout.CENTER);
        add(pane,BorderLayout.SOUTH);  //To change body of generated methods, choose Tools | Templates.
    }

 
   
    
}
