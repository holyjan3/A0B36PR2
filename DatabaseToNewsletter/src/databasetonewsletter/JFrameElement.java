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
public class JFrameElement extends JFrame{
    JPanelElement jpanel;
    JScrollPane scrollPane;
    JPanel jpanelW;
    int number_of_element;
    Database database;
    public JFrameElement(Database database,int number_of_element) throws HeadlessException {
        super(database.Data.get(number_of_element).DE[1].toString());
        this.database = database;
        this.number_of_element = number_of_element;
        
        jpanel = new JPanelElement(database.Data.get(number_of_element));       
        
        jpanelW = new JPanellElementGlobaBottom(jpanel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
        setSize(1000, 1000);
        BorderLayout bl = new BorderLayout();
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        bl.setHgap(40);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jpanel);
        
        
        con.add(scrollPane, BorderLayout.CENTER);        
        con.add(jpanelW,BorderLayout.EAST);
        
    }      
}
