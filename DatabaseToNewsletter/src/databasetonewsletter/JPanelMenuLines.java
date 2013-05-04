/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import layout.TableLayout;



/**
 *
 * @author Majitel
 */
public class JPanelMenuLines extends JPanel{
    Database database;
    double height = 30;   
    protected ArrayList<Integer> array;
   
    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
      


    public JPanelMenuLines(JFrameMenu frameMenu) {
           
        this.database = frameMenu.database;
        this.array = frameMenu.array;
        
       
        
         
        
        
        array = frameMenu.array;
        int j = array.size();
        double[][] ds =  new double[2][j+3];
        
        ds[0][0]= 30;
        ds[1][0]= height;
        ds[0][1]= 30;
        ds[1][1]= height;
        ds[0][2]= 100;
        ds[1][2]= height;
         
        
        for (int i = 3; i < j+3; i++) {
          ds[0][i]= (double)database.DE[array.get(i-3)].LINE_SIZE;
          ds[1][i]= height;   
        }
        
       
        
        TableLayout tableLayout = new TableLayout(ds);
       
        
        setLayout(tableLayout);
        
    
            
        
         for (int i = 0; i < database.Data.size();i++) {
            JPanelMenuLine(i);
         }
                
        } 
        
  
    
    public void overWritePanel(){
       this.removeAll();
       this.jrb.clear();
       for (int i = 0; i < database.Data.size(); i++) {
           JPanelMenuLine(i);
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
               JPanelMenuLine(i);
                j++;     
            }
        }
       this.revalidate();
       this.repaint();
    }
    
    public void addLine(){
          JPanelMenuLine(database.Data.size());
    }
    
   
   public void JPanelMenuLine(int numberLine) 
    {
        
        JCheckBox checkBox;
        Element element;
        JButton jButton;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(10,10,10,10);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
        element = database.Data.get(numberLine);
        
        JRadioButtonWithNumber jr=new JRadioButtonWithNumber(numberLine,element);
        jrb.add(jr);       
        ActionModify acl = new ActionModify();
        checkBox = new JCheckBox();
        checkBox.setFocusable(true);
        jButton = new JButtonWithNumber(numberLine, "upravit");
        jButton.addActionListener(acl);
        
        
        
        if(Boolean.parseBoolean(element.strings_of_elements[0])){
            checkBox.setSelected(true);
            checkBox.setBackground(Color.green);
            checkBox.setOpaque(true);
        } else {
            checkBox.setSelected(false);
            checkBox.setBackground(Color.red);
            checkBox.setOpaque(true);
        }
        
        checkBox.setEnabled(false);
        UIManager.put("checkBox.focus",Color.RED);
       
              
       
        add(jr,"0, "+Integer.toString(numberLine));  
        
        add(checkBox,"1, "+Integer.toString(numberLine));
        add(jButton,"2, "+Integer.toString(numberLine));
          
     for (int i = 0; i < array.size(); i++) {
           //System.out.println("nnn"+element.strings_of_elements[array.get(i)]+array.get(i));
           label= new JLabel(element.strings_of_elements[array.get(i)]);
           if(i%2 == 0){
               
               label.setBackground(Color.CYAN);
               
           } else {
              label.setBackground(Color.ORANGE); 
           }
           
           label.setOpaque(true);
           
           
           label.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
           
           
           add(label,Integer.toString(i+3)+", "+ Integer.toString(numberLine));
     }       
             
              
  }      
   
    
    class ActionModify implements ActionListener{
        Database database1= database;
        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbw = (JButtonWithNumber) e.getSource();
            System.out.println(jbw.number);
            int a = 0;
            Element el = database1.nowWorkDatabase.openElement(jbw.number);
            new JFrameElement(JPanelMenuLines.this, el);
            
        }
        
    }
   
}
