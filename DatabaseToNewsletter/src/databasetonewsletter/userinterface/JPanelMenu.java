/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.Database;
import databasetonewsletter.WorkerDatabase;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




/**
 *
 * @author Majitel
 */
public class JPanelMenu extends JPanel{
    /**
     *
     */
    Database database;
    /**
     *
     */
    JPanelMenuButtonTop menulButtonTop;
    /**
     *
     */
    JPanelMenuButtonBottom menulButtonBottom;
    /**
     *
     */
    JPanelMenuLines menuLines;
    /**
     *
     */
    JScrollPane scrollPane;
    /**
     *
     */
    JPanelCalendar conection;
    /**
     *
     */
    JFrameMainMenu frameMainMenu;
    /**
     *
     */
    protected ArrayList<Integer> array;
    
    /**
     *
     * @param database
     */
    public JPanelMenu(Database database){
       
        this.database = database;
        
        conection = null;
        
        watch();
        menulButtonTop = new JPanelMenuButtonTop(this);
        menuLines = new JPanelMenuLines(database,array);
        menulButtonBottom = new JPanelMenuButtonBottom(this);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        
        

        //setSize(1000,1000);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        BorderLayout bl = new BorderLayout();          
        setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel pane = new JPanel(new BorderLayout());

        
        
       conection = new JPanelCalendar(menuLines,WorkerDatabase.date);
 
       
       
     
        JpanelTop();
        pane.add(menulButtonBottom,BorderLayout.WEST);
        pane.add(conection,BorderLayout.CENTER);     
        
        
        add(scrollPane,BorderLayout.CENTER);
        add(pane,BorderLayout.SOUTH);        

        
       
    }
    
    /**
     *
     */
    public void JpanelTop(){
        add(menulButtonTop, BorderLayout.NORTH);
    }
    
    /**
     *
     */
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