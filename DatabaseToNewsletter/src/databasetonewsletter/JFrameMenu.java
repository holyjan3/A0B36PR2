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
    JPanelElements jpanel;
    DataElements[] DE;
    JScrollPane scrollPane;
    JPanel jpanelW;
    public JFrameMenu(String title, DataElements[] DE) throws HeadlessException {
        super(title);
        this.DE = DE;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setSize(1000, 1000);
        BorderLayout bl = new BorderLayout();
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        
        
    }
}
