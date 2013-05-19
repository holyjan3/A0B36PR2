/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import other.ControlConection;
import databasework.WorkerDatabase;
import databasework.ControlElement;
import other.ControlWebSide;
import databasefinal.DataControl;
import databasework.DataElement;
import databasefinal.Database;
import databasefinal.Element;
import static databasework.DataElement.*;
import databasework.WorkDatabase;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * Panel s položkamy
 * @author Jan Holý
 */    
    
        
        
   
public class JPanelElement extends JPanel{    
 
    public JTextArea[] text;
   
    JLabel [] jLabelsError;

    Database database;    
   

    protected int jtext_height;

    protected int jtext_width;    

    protected Insets Ins = new Insets(10, 10, 20, 10);    

    public Element element;
    
    int maxwidth = 70;

    private ActionSave save = new ActionSave();

    private IfChanged ifChanged = new IfChanged();    
   
    private ActionButtonDelete buttonDelete = new ActionButtonDelete();
 
    private ActionButtonRestore buttonRestore = new ActionButtonRestore();
  
    private boolean changed;

    private boolean conected;

    protected boolean wrong;

    protected String ss1= "chyba ve vstupnim retezci";

    private String ss2= "nepodařilo se připojit k intenetu adresa nebyla ověřena";
    
    JPanelElement(Database database,Element element) {
        this.database = database;
        this.element = element;
        this.changed = false;
        conected = ControlConection.isConected();
        wrong = false;
        
        
        
        
        
        
        text =new JTextAreaWithNumber[element.DE.length];  
        jLabelsError = new JLabel[element.DE.length];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
         
        add(panel);
        this.add(panel);
        
      
        
       
        for (int i = 0; i < element.DE.length; i++) {
           
            
            
                    if(element.DE[i].dataSize()<maxwidth)
                        jtext_width = element.DE[i].dataSize();
                    else
                       jtext_width = maxwidth;
                        
                    jtext_height = element.DE[i].numberLine();
                   
                    text[i] = new JTextAreaWithNumber(i,jtext_height,jtext_width);
                    text[i].setText(element.strings_of_elements[i]);
                    
                    switch (element.DE[i].getType()) {

                case DATE:
                    text[i].addKeyListener(new ActionDate());
                    break;
                case TIME:
                    text[i].addKeyListener(new ActionTime());
                    break;
                case VARCHAR:
                    break;
                case URL:
                    break;
                default:
                    throw new AssertionError();
            }
                    
                    
                
            JPanel item0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel item1 = new JPanel(new FlowLayout(FlowLayout.LEFT));            
            JPanel item2 = new JPanel(new FlowLayout(FlowLayout.LEFT));     
            
            JLabel head = new JLabel(element.DE[i].toString());            
           
            
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
            item2 = addButton(i);
       
            panel.add(item0);
            panel.add(item1);
            panel.add(item2);          
            
           //this.setBackground(Color.red);
           panel.setBackground(Color.green);   
    }
        JFormattedTextField field = new JFormattedTextField();
        
        
 
  }

    public boolean isChanged() {
        return changed;
    }
    
    public JPanel addButton(int i){
        JPanel item2 = new JPanel(new FlowLayout(FlowLayout.LEFT));   
         
         JButton restore  = new JButtonWithNumber(i, "obnovit");
         JButton delete  = new JButtonWithNumber(i, "vymazat text");          
         restore.addActionListener(buttonRestore);
         delete.addActionListener(buttonDelete);
         jLabelsError[i] = new JLabel(ss1);
         jLabelsError[i].setVisible(false);
         jLabelsError[i].setBackground(Color.red);
         jLabelsError[i].setOpaque(true);
         jLabelsError[i].setForeground(Color.white);  
         
         if( (element.DE[i].getType() == DataControl.URL)&& (element.strings_of_elements[i]!= null && !"".equals(element.strings_of_elements[i]) )){
               this.controlUrl(text[i], i);
         }
         text[i].addFocusListener(save);
         text[i].addKeyListener(ifChanged);
         item2.add(restore);
         item2.add(delete);
         item2.add(jLabelsError[i]);
         return item2;
        
    }
    
    public void numberLine(String SS, int width){
        if(SS.length() < width) {
            
        }else {
            for (int i = width; i >= 0; i--) {
                if(SS.charAt(i) == ' ' ){
                    
                }
            }
        }        
    }
    

    public void controlUrl(JTextArea area,int i){
        jLabelsError[i].setVisible(false);
       if(WorkerDatabase.controlElement.controlDatabaseElement(database.DE[i],area.getText())){
        if(conected){
            Thread thread = new Thread(new ControlWebSide(jLabelsError[i],area.getText()));
            thread.start();
        } else {
          jLabelsError[i].setBackground(Color.orange);
          jLabelsError[i].setForeground(Color.black);
          jLabelsError[i].setText(ss2);
          jLabelsError[i].setVisible(true);
           
        }
       } else {
          jLabelsError[i].setForeground(Color.white);
          jLabelsError[i].setText(ss1);
          jLabelsError[i].setVisible(true);
       }
    }

    public void save(int i){
        if(!text[i].getText().equals("")) {
                  
            
                   
                    if(element.DE[i].getType() == DataControl.URL){
                        controlUrl(text[i],i);
                     } else {
                         boolean bb = WorkerDatabase.controlElement.controlDatabaseElement(element.DE[i], text[i].getText());
                         jLabelsError[i].setVisible(!bb);
                        
                    }
                    
               } else {
                   jLabelsError[i].setVisible(false);
               } 
           }
    
    class ActionSave implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
              
               JTextAreaWithNumber jtf = (JTextAreaWithNumber) e.getSource();
                int i = jtf.number;
                 save(i);
               
        } 
        
    }    
            
    public void delete(int i){
        
            text[i].setText("");
            jLabelsError[i].setVisible(false);
    }   
   
    class ActionButtonDelete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JButtonWithNumber jbwn =(JButtonWithNumber) e.getSource();
            delete(jbwn.number);
        }
            
    }
        
        /**
     *
     */
    public void restore(int i){
         if(element.strings_of_elements[i]!=null && !element.strings_of_elements[i].equals("")){
            text[i].setText(element.strings_of_elements[i]);
            save(i);
       }
    }
    
    class ActionButtonRestore implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbwn =(JButtonWithNumber) e.getSource();           
            restore(jbwn.number);
        }
        
        
            
     }
    /**
     *
     */
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
            JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
                StringBuilder ss = new StringBuilder(jtawn.getText()); 
                int a= ss.length();
                if(a>0){
                    
                 if(!Character.isDigit(ss.charAt(ss.length()-1))){
                    jtawn.setText(ss.deleteCharAt(ss.length()-1).toString());
                
                 } 
                }
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
        /**
     *
     */
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
            JTextAreaWithNumber jtawn = (JTextAreaWithNumber) e.getSource();
                StringBuilder ss = new StringBuilder(jtawn.getText()); 
                int a= ss.length();
                if((a>0)){
                    
                 if(!Character.isDigit(ss.charAt(ss.length()-1))){
                    jtawn.setText(ss.deleteCharAt(ss.length()-1).toString());
                
                 } 
                }
            
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
            
        
        
        /**
     *
     */
    class IfChanged implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
           
        
        }

        @Override
        public void keyPressed(KeyEvent e) {
            changed = true;
            removeKeyListener(this);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            changed = true;
            removeKeyListener(this);
        }

        }       
                 
   
}
