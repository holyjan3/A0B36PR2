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
        menulButtonTop = new JPanelMenulButtonTop(this);
        menuLines = new JPanelMenuLines(database);
        menulButtonBottom = new JPanelMenulButtonBottom(this);
        
        
        
        setVisible(true);
        
        Dimension dim = this.getMaximumSize();
        setSize(dim);
        
        BorderLayout bl = new BorderLayout();        
        Container con = getContentPane();  
        con.setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        
        JPanel pane = new JPanel(new BorderLayout());
       
       
  
        
        pane.add(menulButtonBottom,BorderLayout.WEST);
        pane.add(new JPanelConection(this),BorderLayout.EAST);
       
        
        con.add(menulButtonTop, BorderLayout.NORTH);
        con.add(scrollPane,BorderLayout.CENTER);
        con.add(pane,BorderLayout.SOUTH);        

        
        
    }
}
