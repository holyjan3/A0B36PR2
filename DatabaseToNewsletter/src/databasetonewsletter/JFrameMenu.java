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
public class JFrameMenu extends JFrame{
    Database database;
    JPanelMenulButtonTop menulButtonTop;
    JPanelMenulButtonBottom menulButtonBottom;
    JPanelMenuLines menuLines;
    JScrollPane scrollPane;
    JPanelConection conection;
    JFrameMainMenu frameMainMenu;
    protected ArrayList<Integer> array;
       
    public JFrameMenu(Database database,JFrameMainMenu frameMainMenu) throws HeadlessException {        
        super(database.name_database);
        
        this.frameMainMenu = frameMainMenu;
        this.database = database;
        this.watch();
        menulButtonTop = new JPanelMenulButtonTop(this);
        menuLines = new JPanelMenuLines(this);
        menulButtonBottom = new JPanelMenulButtonBottom(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
        
        setVisible(true);
        
        

        setSize(1000,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        BorderLayout bl = new BorderLayout();        
        Container con = getContentPane();  
        con.setLayout(bl);
        
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(menuLines);
        
        addWindowListener(new Action());
        JPanel pane = new JPanel(new BorderLayout());
        conection = new JPanelConection(this);
       
       
  
        
        pane.add(menulButtonBottom,BorderLayout.WEST);
        pane.add(conection,BorderLayout.EAST);
       
        
        con.add(menulButtonTop, BorderLayout.NORTH);
        con.add(scrollPane,BorderLayout.CENTER);
        con.add(pane,BorderLayout.SOUTH);        

        
       
    }
    
    public void watch(){
        int j = 0;
        array = new ArrayList(8);
        array.add(j,1);
        for (int i = 1; i < database.DE.length; i++) {
            if(database.DE[i].sort()){
                j++;    
                array.add(j, i);
        
            }
        }
    }
    
    @Override
    public void revalidate(){
        conection.revalidate();
        super.revalidate();
        frameMainMenu.revalidate();
        
    }
    class Action implements WindowListener{
       
        

        @Override
        public void windowOpened(WindowEvent e) {
           
        }

        @Override
        public void windowClosing(WindowEvent e) {          
            database.nowWorkDatabase.saveDatabese();
            frameMainMenu.setVisible(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
           
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            
        }

        @Override
        public void windowActivated(WindowEvent e) {
            
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
           
        }
        
    }
 
}
