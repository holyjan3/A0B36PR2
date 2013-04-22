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
    Element element;
    
    public JFrameElement(Database database,Element element) throws HeadlessException {
        super(database.Data.get(database.Data.indexOf(element)).DE[1].toString());
        this.database = database;
        this.element = element;
        
        jpanel = new JPanelElement(database,element);       
        
        jpanelW = new JPanelElementGlobaBottom(database);
        
        //setDefaultCloseOperation(EXIT_ON_CLOSE); 
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
    
    public JFrameElement(Database database) throws HeadlessException {
        super("Nový záznam");
        this.database = database;
        element = new Element(database.DE);
        jpanel = new JPanelElement(database,element);       
        
        jpanelW = new JPanelElementGlobaBottom(database);
         
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
