/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import databasetonewsletter.Database;
import StaticClass.WorkerDatabase;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




/**
 * panel s tlačítky pro práci s jedním typem záznamů a s tabulkou jednoho typu záznamu
 * @author Jan Holý
 */
public class JPanelMenu extends JPanel{

    Database database;

    JPanelMenuButtonTop menulButtonTop;

    JPanelMenuButtonBottom menulButtonBottom;

    JPanelMenuLines menuLines;

    JScrollPane scrollPane;

    JPanelCalendar conection;
  
    JFrameMainMenu frameMainMenu;
    
    JPanel pane;

    protected ArrayList<Integer> array;
 
    public JPanelMenu(Database database){
       
        this.database = database;
        
        conection = null;
        
        watch();
        menulButtonTop = new JPanelMenuButtonTop(this);
        menuLines = new JPanelMenuLines(database,array);
        menuLines.addLine();
        menulButtonBottom = new JPanelMenuButtonBottom(this);
        
        
        BorderLayout bl = new BorderLayout();          
        setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        pane = new JPanel(new BorderLayout());

        
        
       conection = new JPanelCalendar(menuLines,WorkerDatabase.date);
 
       
       
     
        
        pane.add(menulButtonBottom,BorderLayout.WEST);
        pane.add(conection,BorderLayout.CENTER);     
        
        
             

        
       
    }

    public void AddPanel(){
        add(menulButtonTop, BorderLayout.NORTH);
         add(scrollPane,BorderLayout.CENTER);
        add(pane,BorderLayout.SOUTH);  
        
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
    
  
 

}