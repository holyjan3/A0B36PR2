/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.*;
import javax.swing.*;

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
    
    public JFrameElement(JPanelMenuLines panelMenuLines,Element element) throws HeadlessException {        
        super(panelMenuLines.database.Data.get(panelMenuLines.database.Data.indexOf(element)).DE[1].toString());
        database = panelMenuLines.database;
        this.element = element;
        
        
        
        jpanel = new JPanelElement(database,element);    
        
        jpanelW = new JPanelElementGlobaBottom(this,panelMenuLines);
        
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
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
    
    public JFrameElement(JPanelMenuLines panelMenuLines) throws HeadlessException {
        super("Nový záznam");
        this.database = panelMenuLines.database;
        element = new Element(database.DE);
        jpanel = new JPanelElement(database,element);       
        
        jpanelW = new JPanelElementGlobaBottom(this,panelMenuLines);
         
        setVisible(true);
        setSize(1000, 1000);
        BorderLayout bl = new BorderLayout();
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jpanel);
        
        
        con.add(scrollPane, BorderLayout.CENTER);        
        con.add(jpanelW,BorderLayout.EAST);
        
    }  
}
