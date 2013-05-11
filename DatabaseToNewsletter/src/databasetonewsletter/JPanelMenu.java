/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public class JPanelMenu extends JPanel{
    Database database;
    JPanelMenulButtonTop menulButtonTop;
    JPanelMenulButtonBottom menulButtonBottom;
    JPanelMenuLines menuLines;
    JScrollPane scrollPane;
    JPanelConection conection;
    JFrameMainMenu frameMainMenu;
    protected ArrayList<Integer> array;
       
    public JPanelMenu(Database database){
        
  
        this.database = database;
        
        
        
        watch();
        menulButtonTop = new JPanelMenulButtonTop(this);
        menuLines = new JPanelMenuLines(database,array);
        menulButtonBottom = new JPanelMenulButtonBottom(this);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        
        

        //setSize(1000,1000);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        BorderLayout bl = new BorderLayout();          
        setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel pane = new JPanel(new BorderLayout());
        conection = new JPanelConection(menuLines);
       
       
     
        JpanelTop();
        pane.add(menulButtonBottom,BorderLayout.WEST);
        pane.add(conection,BorderLayout.CENTER);     
        
        
        add(scrollPane,BorderLayout.CENTER);
        add(pane,BorderLayout.SOUTH);        

        
       
    }
    
    public void JpanelTop(){
        add(menulButtonTop, BorderLayout.NORTH);
    }
    
    public void watch(){
        int j = 0;
        array = new ArrayList(8);
        array.add(j,0);
 
        
        for (int i = 0; i < database.DE.length; i++) {
            if(database.DE[i].sort()){
                j++;    
                array.add(j, i);
        
            }
        }
    }
    
   
        
//      @Override
//        public void revalidate(){
//            conection.revalidate();
//            super.revalidate();
//            frameMainMenu.revalidate();
//
//        }    

 

}