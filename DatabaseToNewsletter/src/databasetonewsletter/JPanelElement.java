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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Majitel
 */    
    
        
        
   
public class JPanelElement extends JPanel{    
    JTextArea[] text;
    JLabel [] jLabelsEror;
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
        jLabelsEror = new JLabel[element.DE.length];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         
        add(panel);
        this.add(panel);
        
        ActionSave save = new ActionSave();
        ActionButtonDelete buttonDelete = new ActionButtonDelete();
        ActionButtonRestore buttonRestore = new ActionButtonRestore();
        
       
        for (int i = 1; i < element.DE.length; i++) {
            switch (element.DE[i]) {
         
                case DATE:
                    jtext_height = 1;
                    jtext_width = 10;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    text[i].addKeyListener(new ActionDate());
                    break;
                case TIME:
                    jtext_height = 1;
                    jtext_width = 10;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    text[i].addKeyListener(new ActionTime());
                    break;
                case HEAD:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case HEAD_LINK:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                   // url(text[i],element.strings_of_elements[i]);
                    break;
                case TOWN:
                    jtext_height = 1;
                    jtext_width = 10;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case PLACE:
                    jtext_height = 1;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case TEXT:
                    jtext_height =10;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case LINK1_TEXT:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case LINK2_TEXT:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case LINK3_TEXT:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case LINK1:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    //url(text[i],element.strings_of_elements[i]);
                    break;
                case LINK2:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    //url(text[i],element.strings_of_elements[i]);
                    break;
                case LINK3:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    //url(text[i],element.strings_of_elements[i]);
                    break;
                case NAME:
                    jtext_height = 1;
                    jtext_width = 10;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
                case MEDIUM:
                    jtext_height = 1;
                    jtext_width = 10;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    break;
               case TEXT_LINK:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    //url(text[i],element.strings_of_elements[i]);
                    break;
                case TYPE:
                    jtext_height = 1;
                    jtext_width = 80;
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    break;
            }
            JPanel item0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel item1 = new JPanel(new FlowLayout(FlowLayout.LEFT));            
            JPanel item2 = new JPanel(new FlowLayout(FlowLayout.LEFT));           
            
            
             JLabel head = new JLabel(element.DE[i].toString());
            
            
            //JButton save = new JButtonWithNumber(i, "uložit");                 
            JButton restore  = new JButtonWithNumber(i, "obnovit");
            JButton delete  = new JButtonWithNumber(i, "vymazat text");
            jLabelsEror[i] = new JLabel("chyba ve vstupnim retezci");
            jLabelsEror[i].setVisible(false);
            jLabelsEror[i].setBackground(Color.red);
           
            
            
            text[i].addFocusListener(save);
            
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
            item2.add(jLabelsEror[i]);
       
            panel.add(item0);
            panel.add(item1);
            panel.add(item2);          
            
           //this.setBackground(Color.red);
           panel.setBackground(Color.green);   
    }
        JFormattedTextField field = new JFormattedTextField();
        
        
 }   
   /* protected void url(JTextArea ta,String ss){
        if(ss.equals("")){
            ta.setText("http://");
            
        } else {
            ta.setText(ss);
        }
    }*/
    
        class ActionSave implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
              
               JTextAreaWithNumber jtf = (JTextAreaWithNumber) e.getSource();
               if(!jtf.getText().equals("")) {
                   int i = jtf.number;
                    if(ControlElement.controlDatabaseElement(element.DE[i], jtf.getText())){                        
                        jLabelsEror[i].setVisible(false);
                        deleteString = element.strings_of_elements[i];
                        deleteNumberString = i;
                        element.strings_of_elements[i] = jtf.getText();
                    } else {
                        jLabelsEror[i].setVisible(true);
                    }
               }
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
class ActionDate implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
           JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
            StringBuilder ss = new StringBuilder(jtawn.getText()); 
            int a= ss.length();
            if((a == 2)||(a == 5)){
                ss.append(".");
            } else {
                if(a>9){
                  jtawn.setText(ss.deleteCharAt(a-1).toString());
                }
            }
          jtawn.setText(ss.toString()); 
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
                StringBuilder ss = new StringBuilder(jtawn.getText()); 
                int a= ss.length();
                if(a>0){
                    
                 if(!Character.isDigit(ss.charAt(ss.length()-1))){
                    jtawn.setText(ss.deleteCharAt(ss.length()-1).toString());
                
                 } 
                }
        }

           
            
        }
        class ActionTime implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
           JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
            StringBuilder ss = new StringBuilder(jtawn.getText()); 
            int a= ss.length();
            if((a == 2)){
                ss.append(":");
            } else {
                if(a>4){
                  
                  jtawn.setText(ss.deleteCharAt(a-1).toString());
                }
            }
          jtawn.setText(ss.toString()); 
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
                StringBuilder ss = new StringBuilder(jtawn.getText()); 
                int a= ss.length();
                if((a>0)){
                    
                 if(!Character.isDigit(ss.charAt(ss.length()-1))){
                    jtawn.setText(ss.deleteCharAt(ss.length()-1).toString());
                
                 } 
                }
        }

           
            
        }
}
