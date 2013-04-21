/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public class JFrameMenu extends JFrame{
    Database database;
    JPanelMenulButtonTop menulButtonTop;
    JPanelMenulButtonBottom menulButtonBottom;
    JPanelMenuLines menuLines;
    JScrollPane scrollPane;
       
    public JFrameMenu(Database database) throws HeadlessException {        
        super(database.name_database);
        this.database = database;
        menulButtonTop = new JPanelMenulButtonTop(database.DE);
        menuLines = new JPanelMenuLines(database);
        menulButtonBottom = new JPanelMenulButtonBottom();
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setSize(1000, 1000);
        BorderLayout bl = new BorderLayout();        
        Container con = getContentPane();  
        con.setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        con.add(menulButtonTop, BorderLayout.NORTH);
        con.add(scrollPane,BorderLayout.CENTER);
        con.add(menulButtonBottom,BorderLayout.SOUTH);        
        
        
        
    }
}
