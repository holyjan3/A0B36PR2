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
        menuLines = new JPanelMenuLines(database,array);
        menulButtonBottom = new JPanelMenulButtonBottom(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       
        
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
        array.add(j,0);
 
        
        for (int i = 0; i < database.DE.length; i++) {
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
            
            if(database.nowWorkDatabase.saveDatabese()){
                
                dispose();
                frameMainMenu.setVisible(true);
            }else {
             
                JOptionPane  frame = new JOptionPane();
             Object[] options = {"zahodit ",
                    "vráti se"};
            int n = JOptionPane.showOptionDialog(frame,
                 "Nezdařilo se uložení přejete si přesto zavřít okno data budou zničena",
                    "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.ERROR_MESSAGE,
             null,
            options,
            options[1]);
            if(n==0){
              dispose();
              frameMainMenu.setVisible(true);
                
            }
            }
            
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
