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
    TableLayout tableLayout;
    double[][] ds;
   JPanel jp;
    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
      


    public JPanelMenuLines(JFrameMenu frameMenu) {
           
        this.database = frameMenu.database;
        this.array = frameMenu.array;
        
       
        
         
        
        
        array = frameMenu.array;
        int j = array.size();
        ds =  new double[2][j+3];
        
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
        
       jp = new JPanel();
        
       tableLayout = new TableLayout(ds);        
       jp.setLayout(tableLayout);
       this.setLayout(new FlowLayout(FlowLayout.LEFT) );
    
            
        
         for (int i = 0; i < database.Data.size();i++) {
            
            JPanelMenuLine(i,i);
         } 
           add(jp);
           
        } 
        
  
    
    public void overWritePanel(){
       //this.removeAll();
       this.jrb.clear();
       this.removeAll();
       jp = new JPanel();
        
       tableLayout = new TableLayout(ds);     
        
       jp.setLayout(tableLayout);
        
       //tableLayout = new TableLayout(ds);
       for (int i = 0; i < database.Data.size(); i++) {
         System.out.println("velikost" +i);
           JPanelMenuLine(i,i);
        }
       add(jp);
       this.revalidate();
       this.repaint();
 
      }
    
    public void find(String ss){
       this.jrb.clear();
       this.removeAll();
       jp = new JPanel();        
       tableLayout = new TableLayout(ds);       
       jp.setLayout(tableLayout);
       int j = 0;
        for (int i = 0; i < database.Data.size(); i++) {
            if(database.Data.get(i).strings_of_elements[1].toLowerCase().contains(ss)){
               JPanelMenuLine(i,i);
                j++;     
            }
        }
       add(jp);
       this.revalidate();
       this.repaint();
    }
    
    public void addLine(){
        int i = database.Data.size();
        System.out.println(i);
       JPanelMenuLine(i,i);
    }
    
   
   public void JPanelMenuLine(int numberLine, int numberElement) 
    {
        
        JCheckBox checkBox;
        Element element;
        JButton jButton;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
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
       
              
        System.out.println("add line "+ numberLine);
    
        tableLayout.insertRow (0, TableLayout.MINIMUM);
        
        jp.add(jr,"0, 1");       
        jp.add(checkBox,"1, 1");
        jp.add(jButton,"2, 1");
        
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
           jp.add(label,Integer.toString(i+3)+", 1");

           
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
