/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.DataElements.*;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import sun.awt.VariableGridLayout;

/**
 *
 * @author Majitel
 */    
    
        
        
   
public class JFrameElements extends JFrame{
    
    JTextArea[] text;
    JButton[] save;
    protected int jtext_height;
    protected int jtext_width;    
    protected Insets Ins = new Insets(10, 10, 20, 10);
    
    
        
        
   

    JFrameElements(DataElements[] DE) {
         //Ins.set(1, 1, 1, 1);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Container kon = getContentPane();
        text = new JTextArea[DE.length];        
        save = new JButton[DE.length];
        
        setSize(1000, 1000);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel mainPanel = new JPanel();
             
        add(mainPanel);
   
        
        
        JScrollPane  scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(mainPanel);

        getContentPane().add(scrollPane);
        
        mainPanel.add(panel);
        
        
        for (int i = 1; i < DE.length; i++) {
            switch (DE[i]) {
                case DAY:
                   jtext_height = 1;                             
                    break;
                case MONTH:
                    jtext_height = 1;
                    break;
                case YEAR:
                    jtext_height = 1;
                    break;
                case HOUR:
                    jtext_height = 1;
                    break;
                case MINUTE:
                    jtext_height = 1;
                    break;
                case HEAD:
                    jtext_height = 1;
                    break;
                case HEAD_LINK:
                    jtext_height = 1;
                    break;
                case TOWN:
                    jtext_height = 1;
                    break;
                case PLACE:
                    jtext_height = 1;
                    break;
                case TEXT:
                    jtext_height =10;
                    break;
                case LINK1_TEXT:
                    jtext_height = 1;
                    break;
                case LINK2_TEXT:
                    jtext_height = 1;
                    break;
                case LINK3_TEXT:
                    jtext_height = 1;
                    break;
                case LINK1:
                    jtext_height = 1;
                    break;
                case LINK2:
                    jtext_height = 1;
                    break;
                case LINK3:
                    jtext_height = 1;
                    break;
                case NAME:
                    jtext_height = 1;
                    break;
                case MEDIUM:
                    jtext_height = 1;
                    break;                   
            }
            JPanel item0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel item1 = new JPanel();            
            JPanel item2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            
            
            
            
            
           
            text[i] = new JTextArea(jtext_height,80);
            
            
            text[i].setWrapStyleWord(true);
            text[i].setLineWrap(true);
            save[i] = new JButtonWithNumber(i, "uložit");                 
            
            JLabel head = new JLabel(DE[i].name());
            
            item0.add(head);
            item1.add(new JScrollPane(text[i]));          
            item2.add(save[i]);
       
            panel.add(item0);
            panel.add(item1);
            panel.add(item2);
          
 
            
           mainPanel.setBackground(Color.red);
           panel.setBackground(Color.green);

            setVisible(true); 
    }
 }   
    


}
