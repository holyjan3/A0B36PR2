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
    

    public JFrameMenu(String title, Database database) throws HeadlessException {
        super(title);

        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setSize(1000, 1000);
        BorderLayout bl = new BorderLayout();
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        
        
    }
}
