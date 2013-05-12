/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public final class JFrameMenu extends JFrame{
    Database database;
    JPanelMenulButtonTop menulButtonTop;
    JPanelMenulButtonBottom menulButtonBottom;
    JPanelMenuLines menuLines;
    JScrollPane scrollPane;
    JPanelCalendar conection;
    JFrameMainMenu frameMainMenu;
    protected ArrayList<Integer> array;
       
    public JFrameMenu(Database database,JFrameMainMenu frameMainMenu) throws HeadlessException {        
        super(database.name_database);
        this.database = database;
        this.frameMainMenu = frameMainMenu;
        
        JPanelMenu menu  = new JPanelMenu(database);
        add(menu);
        
        
       
        
        setVisible(true);
        
        

        setSize(1000,1000);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
     

 
    }

}