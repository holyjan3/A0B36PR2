/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.DataElement.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

/**
 *
 * @author Majitel
 */    
    
        
        
   
public class JPanelElement extends JPanel{    
    JTextArea[] text;
    Database database;    
   
    protected int jtext_height;
    protected int jtext_width;    
    protected Insets Ins = new Insets(10, 10, 20, 10);    
    Element element;
    
    protected String deleteString = "";
    protected int deleteNumberString = 0;

    JPanelElement(Database database,Element element) {
        this.database = database;
        this.element = element;
       
        
        text = new JTextArea[element.DE.length];        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         
        add(panel);
        this.add(panel);
        
        ActionSave save = new ActionSave();
        ActionButtonDelete buttonDelete = new ActionButtonDelete();
        ActionButtonRestore buttonRestore = new ActionButtonRestore();
        
        for (int i = 1; i < element.DE.length; i++) {
            switch (element.DE[i]) {
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
            
            
            text[i] = new JTextAreaWithNumber(i,jtext_height,80);
           
            
            
            //JButton save = new JButtonWithNumber(i, "uložit");                 
            JButton restore  = new JButtonWithNumber(i, "obnovit");
            JButton delete  = new JButtonWithNumber(i, "vymazat text");
            JLabel head = new JLabel(element.DE[i].toString());
            
            
            text[i].addFocusListener((FocusListener) save);
            
            restore.addActionListener(buttonRestore);
           
            delete.addActionListener(buttonDelete);
            
            item0.add(head);
            if(jtext_height > 1){
                text[i].setWrapStyleWord(true);
                text[i].setLineWrap(true);
                item1.add(new JScrollPane(text[i]));          
            } else {
            text[i].setLineWrap(true);
            item1.add(text[i]); 
            }
            
            //item2.add(save);
            item2.add(restore);
            item2.add(delete);
       
            panel.add(item0);
            panel.add(item1);
            panel.add(item2);          
            
           this.setBackground(Color.red);
           panel.setBackground(Color.green);   
    }
        
        
 }   
    
        class ActionSave implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
               JTextAreaWithNumber jtf = (JTextAreaWithNumber) e.getSource();
               if(!jtf.getText().equals("")) {
                   
               deleteString = element.strings_of_elements[jtf.number];
               deleteNumberString = jtf.number;
               element.strings_of_elements[jtf.number] = jtf.getText();
               
               }
               //System.out.println(e.getActionCommand());
        }

      

        
            
        }
        
        class ActionButtonDelete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbwn =(JButtonWithNumber) e.getSource();
            deleteString = text[jbwn.number].getText();
            deleteNumberString = jbwn.number;
            text[jbwn.number].setText(""); 
            
        }
            
        }
        
        class ActionButtonRestore implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbwn =(JButtonWithNumber) e.getSource();
            if((jbwn.number == deleteNumberString) && (!deleteString.equals("") )){
                element.strings_of_elements[jbwn.number] = deleteString;
            } else {                
                deleteString = "";
            }
           
            if(!element.strings_of_elements[jbwn.number].equals("")){
            text[jbwn.number].setText(element.strings_of_elements[jbwn.number]);
            }
        }
            
     }


}
