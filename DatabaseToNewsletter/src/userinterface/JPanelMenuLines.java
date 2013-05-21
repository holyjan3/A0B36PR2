/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import database.Database;
import database.Element;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;




/**
 * třída přidává a aktualizuje řádky záznamů
 * @author Jan Holý
 */


public class JPanelMenuLines extends JPanel {

    public Database database;
    boolean shiftIsDown = false;

    int Y = 25;
    protected ArrayList<Integer> array;

    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
 
      

    public JPanelMenuLines(Database database, ArrayList<Integer> array) {
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        
        this.database = database;
        this.array = array;
        setPreferredSize(new Dimension(400,(database.Data.size()+1)*30) );

        this.setLayout(null);
           
     }
    
    public void addLine(){

         for (int i = 0; i < database.Data.size();i++) {
            
            JPanelMenuLine(i,i);
         } 
         JPanelDEScription();
    }



        

    public void overWritePanel(){
       this.jrb.clear();
       this.removeAll();
       setPreferredSize(new Dimension(400,(database.Data.size()+1)*30) );
       for (int i = 0; i < database.Data.size(); i++) {
       
           JPanelMenuLine(i,i);
        }
      // add(jp);
       JPanelDEScription();
       this.revalidate();
       this.repaint();
 
      }

    public void find(String ss){
       this.jrb.clear();
       this.removeAll();
       int j = 0;
        for (int i = 0; i < database.Data.size(); i++) {
           
            if(database.Data.get(i).strings_of_elements[0]!=null && database.Data.get(i).strings_of_elements[0].toLowerCase().contains(ss)){
               JPanelMenuLine(i,j);
                j++;     
            }
        }
        setPreferredSize(new Dimension(400,(j+1)*30) );
        JPanelDEScription();
       this.revalidate();
       this.repaint();
    }

    public void JPanelDEScription(){
      
        
        Element element;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        Insets insets = this.getInsets();
        
        
     int x=170;
        
     for (int i = 0; i < array.size(); i++) {
           label= new JLabel(database.DE[array.get(i)].toString());
           label.setBounds(x, insets.top+5,database.DE[array.get(i)].getLINE_SIZE(),20);
           x = x +database.DE[array.get(i)].getLINE_SIZE();
           add(label);

     } 
     int i = 0;
      
  } 
    
    

    
   public void JPanelMenuLine(int numberLine,int postion) {
           
        
        
    
          Element element;
        JLabel label;
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
//        
        element = database.Data.get(numberLine);
        Insets insets = this.getInsets();
        int X = addButton (postion,element,insets.left+10);
        
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
           label.setBounds(X, height(postion), element.DE[array.get(i)].getLINE_SIZE(), Y);
           X=X+ element.DE[array.get(i)].getLINE_SIZE();
           
           add(label);

           
     } 
//     int i = 0;
       
  }      
       ShiftDown shiftDown = new ShiftDown();
  SelectJRB selectJRB = new SelectJRB();
   
  int addButton (int numberLine,Element element,int X){
   JCheckBox checkBox;
        JButton jButton;
        JRadioButtonWithNumber jr=new JRadioButtonWithNumber(numberLine,element);
        
        jr.addKeyListener(shiftDown);
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
        
        jr.setBounds(X, height(numberLine),20, Y);
        X = X+30;
        checkBox.setBounds(X, height(numberLine), 20, Y); 
        X = X+30;
        
        jButton.setBounds(X,height(numberLine),80, Y);
        X = X + 100;
        add(jr);       
        add(checkBox);
        add(jButton);
        return X;
   
   }
   int height(int numberLine){
       Insets insets = this.getInsets();
       return (30 + insets.top)*(numberLine+1);
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
    
          
           if(shiftIsDown){
          if(jr.isSelected()){
             
          
               for (int i = 0; i<jrb.size(); i++) {
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
           
            
              
          } else {
              for (int i = jr.number+1 ; i <jrb.size() && jrb.get(i).isSelected(); i++) {
                  jrb.get(i).setSelected(false);
              }
          }           
        }
      }
   }
     
     class ShiftDown implements KeyListener
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode()== KeyEvent.VK_SHIFT) shiftIsDown = true; 
            }

            public void keyReleased(KeyEvent e)
            {
                 if (e.getKeyCode() == KeyEvent.VK_SHIFT && shiftIsDown == true) shiftIsDown = false;
            }

            public void keyTyped(KeyEvent e)
            {
                // nothing
            }

     }
 
   
       
    
   
}
