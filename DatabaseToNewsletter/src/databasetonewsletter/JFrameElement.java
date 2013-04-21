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
    Element element;
    JScrollPane scrollPane;
    JPanel jpanelW;
    public JFrameElement(Element element) throws HeadlessException {
        super("ahoj");
        this.element = element;        
        jpanel = new JPanelElement(element);
        
        jpanelW = new JPanellElementGlobaBottom();
        
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
