/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Majitel
 */
public class JPanelMenuLines extends JPanel{
    Database database;
    protected ArrayList<Integer> array;
    protected DataElement[] dataElementses;
    private ActionModify acl = new ActionModify();
    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
    


    public JPanelMenuLines(Database database) {
        this.database = database; 
        BoxLayout box = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(box);

        array = new ArrayList(8);
        dataElementses = new DataElement[8];
        int j = 0;
        array.add(j,1);
        for (int i = 1; i < database.DE.length; i++) {
            if(database.DE[i].sort()){
                j++;    
                array.add(j, i);
                    
            }
        }
        int ddd = 0;
            
        
          for (int i = 0; i < database.Data.size();i++) {
              JPanel jp = new JPanelMenuLine(i);
              add(jp);
              jp.setAlignmentX(LEFT_ALIGNMENT);
          }
                
        } 
        
  
    
    public void overWritePanel(){
       this.removeAll();
       this.jrb.clear();
       for (int i = 0; i < database.Data.size(); i++) {
           JPanel jp = new JPanelMenuLine(i);
           add(jp);
            jp.setAlignmentX(LEFT_ALIGNMENT);
            
        }
       this.revalidate();
       this.repaint();
      }
    
    public void find(String ss){
       this.removeAll();
       this.jrb.clear();
       int j = 0;
        for (int i = 0; i < database.Data.size(); i++) {
            if(database.Data.get(i).strings_of_elements[1].toLowerCase().contains(ss)){
                JPanel jp = new JPanelMenuLine(i);
                j++;
                add(jp);
                jp.setAlignmentX(LEFT_ALIGNMENT);
                

            }
        }
       this.revalidate();
       this.repaint();
    }
    
    public void addLine(){
           add(new JPanelMenuLine(database.Data.size()));
    }
    
   
    class JPanelMenuLine extends JPanel
    {
        
        JCheckBox checkBox;
        Element element;
        public JPanelMenuLine(int numberLine) {
              JLabel label;
              JButton jButton;
                
              JRadioButtonWithNumber jr=new JRadioButtonWithNumber(numberLine,this);
              jrb.add(jr);
       
              element = database.Data.get(numberLine);
              BoxLayout boxLayout = new BoxLayout(this,BoxLayout.X_AXIS);
              this.setLayout(boxLayout);
              
              
              JLabel jLabel = new JLabel();
              JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
              
              
              checkBox = new JCheckBox();
              checkBox.setFocusable(true);
              
              jButton = new JButtonWithNumber(numberLine, "upravit");
              jButton.addActionListener(acl);
              
              if(Boolean.parseBoolean(element.strings_of_elements[0])){
                  checkBox.setSelected(true);
              } else {
                  checkBox.setSelected(false);
              }
              checkBox.setEnabled(false);
              
              
             
              label= new JLabel(element.strings_of_elements[1]);              
              label.setSize(DataElement.HEAD.LINE_SIZE, 1);
              label.setSize(10,20);
              
              item.add(jr);              
              item.add(checkBox);
              item.add(jButton);
              
              for (int i = 0; i < array.size(); i++) {
                   System.out.println("nnn"+element.strings_of_elements[array.get(i)]+array.get(i));
                   label= new JLabel(element.strings_of_elements[array.get(i)]);
                   item.add(label);
              }        
              
               add(item);
              
        }      
   
    }
    class ActionModify implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbw = (JButtonWithNumber) e.getSource();
            Element el = database.nowWorkDatabase.openElement(jbw.number);
            new JFrameElement(JPanelMenuLines.this,el);
            
        }
        
    }
    
    
}

