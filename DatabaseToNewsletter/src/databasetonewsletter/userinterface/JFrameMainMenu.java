/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.GlobalSave;
import databasetonewsletter.WorkerDatabase;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Jan Holý
 */
public class JFrameMainMenu extends JFrame {

    JPanelCalendar jpc;

    JPanelMainMenuTop menuTop;

    public JFrameMainMenu() {   
        super("Newsletter maker");
         
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
        BorderLayout bl = new BorderLayout();
       
        jpc = new JPanelCalendar(null,WorkerDatabase.date);
         
       
        
        this.addWindowListener(new Action());
        menuTop = new JPanelMainMenuTop(jpc);
        add(menuTop,BorderLayout.NORTH);
        add(new JPanelDatabases(WorkerDatabase.dataDatabases,this),BorderLayout.CENTER);
        jpc.setLayout(new FlowLayout(FlowLayout.RIGHT));
       
        add(jpc,BorderLayout.SOUTH);
        setSize(900,600);
        setVisible(true); 
        
        // Get the size of the screen
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

// Determine the new location of the window
int w = getSize().width;
int h = getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
 
// Move the window
setLocation(x, y);
        
    
    
    }
    @Override
        public void revalidate(){
        this.
        jpc.revalidate();
        super.revalidate();

    
    
     }

    class Action implements WindowListener {
        
        
        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            GlobalSave.setFOOTER(menuTop.getFooter());
            GlobalSave.setHEADING(menuTop.getHeading());
            boolean bb =true;
            try {
                 GlobalSave.saveText();
                 close(0);
                 
            } catch  (IOException | NullPointerException ee){
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
                    close(1);
                
                }
                else bb = false;
            }
            if(bb){
               
            }
        }
        

        public void close(int i){
             try {
                    WorkerDatabase.conection.close();
                } catch (SQLException ex) {
                   i = 2;
                } finally {
                   System.exit(i);
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