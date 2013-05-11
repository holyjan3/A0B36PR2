/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Majitel
 */
public class JFrameMainMenu extends JFrame {
   
     JPanelConection jpc;
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
        BorderLayout bl = new BorderLayout();
        menuTop = new JPanelMainMenuTop();
        jpc = new JPanelConection(null);
        
        this.addWindowListener(new Action());
        
        add(menuTop,BorderLayout.NORTH);
        add(new JPanelDatabases(WorkerDatabase.dataDatabases,this),BorderLayout.CENTER);
        
        add(jpc,BorderLayout.SOUTH);
        setSize(900,600);
        setVisible(true); 
        
    
    
    }
    @Override
        public void revalidate(){
        this.
        jpc.revalidate();
        super.revalidate();

    
    
     }
    
    class Action implements WindowListener {
        JPanelMainMenuTop menuTop1 = menuTop;
        
        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            GlobalSave.FOOTER = menuTop1.getFooter();
            GlobalSave.HEADING = menuTop1.getHeading();
            if(GlobalSave.saveText()) {
                
               System.exit(0);
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
                System.exit(0);
         
                
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