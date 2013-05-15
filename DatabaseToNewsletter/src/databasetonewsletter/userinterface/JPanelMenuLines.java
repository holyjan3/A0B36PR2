/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.Database;
import databasetonewsletter.Element;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import layout.TableLayout;



/**
 * třída přidává a aktualizuje řádky záznamů
 * @author Jan Holý
 */
public class JPanelMenuLines extends JPanel{

    public Database database;

    double height = 30;   

    protected ArrayList<Integer> array;

    TableLayout tableLayout;

    double[][] ds;

    JPanel jp;

    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
 
    private int add;
      

    public JPanelMenuLines(Database database, ArrayList<Integer> array) {
           
        this.database = database;
        this.array = array;
        this.add = 3;        
        
       
       this.setLayout(new FlowLayout(FlowLayout.LEFT) );            
       
           
     }
    
    public void addLine(){
        jp = new JPanel();
         doubleAray();
         tableLayout = new TableLayout(ds);
         jp.setLayout(tableLayout);
         for (int i = 0; i < database.Data.size();i++) {
            
            JPanelMenuLine(i);
         } 
         JPanelDEScription();
           add(jp);
    }
    

    public void doubleAray(){
  
        int j = array.size();
        ds =  new double[2][j+add];        
        ds[0][0]= 30;
        ds[1][0]= height;
        ds[0][1]= 30;
        ds[1][1]= height;
        ds[0][2]= 100;
        ds[1][2]= height;
        doubleArayAdd(add);
    }
    

    public void doubleArayAdd(int add){
         int j = array.size();
         for (int i = add; i < j+add; i++) {
          ds[0][i]= (double)database.DE[array.get(i-add)].LINE_SIZE;
          ds[1][i]= height;   
        }        
    }
        

    public void overWritePanel(){
       this.jrb.clear();
       this.removeAll();
       jp = new JPanel();
        
       tableLayout = new TableLayout(ds);     
        
       jp.setLayout(tableLayout);
        
       //tableLayout = new TableLayout(ds);
       for (int i = 0; i < database.Data.size(); i++) {
       
           JPanelMenuLine(i);
        }
       add(jp);
       JPanelDEScription();
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
            if(database.Data.get(i).strings_of_elements[0].toLowerCase().contains(ss)){
               JPanelMenuLine(i);
                j++;     
            }
        }
       add(jp);
        JPanelDEScription();
       this.revalidate();
       this.repaint();
    }

    public void JPanelDEScription(){
      
      tableLayout.insertRow (0, TableLayout.MINIMUM);
        
        Element element;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
      ;
        
        
     for (int i = 0; i < array.size(); i++) {
           //System.out.println("nnn"+element.strings_of_elements[array.get(i)]+array.get(i));
           label= new JLabel(database.DE[array.get(i)].toString());
                   
           
              
           jp.add(label,Integer.toString(i+3)+", 1");

           
     } 
     int i = 0;
      
  } 
    
    

    public void JPanelMenuLine(int numberLine) 
    {
        tableLayout.insertRow (0, TableLayout.MINIMUM);
        
        Element element;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
        element = database.Data.get(numberLine);
        
        addButton (numberLine,element);
        
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
     int i = 0;
       
  }      
   
  SelectJRB selectJRB = new SelectJRB();
  
    void addButton (int numberLine,Element element){
   JCheckBox checkBox;
        JButton jButton;
        JRadioButtonWithNumber jr=new JRadioButtonWithNumber(numberLine,element);
        jr.addActionListener(selectJRB);
        jrb.add(jr);       
        JPanelMenuLines.ActionModify acl = new JPanelMenuLines.ActionModify();
        checkBox = new JCheckBox();
        checkBox.setFocusable(true);
        jButton = new JButtonWithNumber(numberLine, "upravit");
        jButton.addActionListener(acl);        
        
        if(element.isPrinted()){
            checkBox.setSelected(true);
            checkBox.setBackground(Color.green);
            checkBox.setOpaque(true);
        } else {
            checkBox.setSelected(false);
            checkBox.setBackground(Color.red);
            checkBox.setOpaque(true);
        }
        
        checkBox.setEnabled(false);
        jp.add(jr,"0, 1");       
        jp.add(checkBox,"1, 1");
        jp.add(jButton,"2, 1");
   
   }
   
   

    class ActionModify implements ActionListener{
    
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButtonWithNumber jbw = (JButtonWithNumber) e.getSource();
          
            int a = 0;
            
            Element el = database.nowWorkDatabase.openElement(jbw.number);
            new JFrameElement(JPanelMenuLines.this, el);
            
        }
        
    }
     class SelectJRB implements ActionListener{
    
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButtonWithNumber jr = (JRadioButtonWithNumber) e.getSource();
            JRadioButtonWithNumber jrbd = null;
            
          boolean bb =false;
          
          
           if(e.getModifiers()!=0 && InputEvent.SHIFT_MASK !=0){
          if(jr.isSelected()){
             
          
               for (int i = jrb.size()-1; i >=0; i--) {
                   if(jrb.get(i).isSelected()) {
                       if(jrb.get(i) != jr){
                           
                           jrbd = jrb.get(i);
                           if(bb)
                               break;
                       } else {
                           bb = true;
                           if(jrbd != null) {
                               break;
                           }
                       }
                   }                   
               }
              if(jrbd!= null){
                  if(jrbd.number < jr.number){
                      for (int i = jrbd.number; i < jr.number; i++) {
                          jrb.get(i).setSelected(true);
                      }
                      
                  }else {
                      for (int i = jr.number; i < jrbd.number; i++) {
                          jrb.get(i).setSelected(true);
                      }
                      
                  }                 
              }
           
            
              
          }           
        }
      }
   }   
 
   
       
    
   
}
