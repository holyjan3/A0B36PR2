/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


import database.Database;
import database.Element;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
/**
 * okno jednotlivého záznamu
 * @author Jan Holý
 */
public class JFrameElement extends JFrame{
    
 
    JPanelElement jpanel;
    JScrollPane scrollPane;
    JPanel jpanelW;
    int number_of_element;
    Database database;

    Element element;

    boolean new_element;
    
    public JFrameElement(JPanelMenuLines panelMenuLines,Element element) throws HeadlessException {
         super(panelMenuLines.database.Data.get(panelMenuLines.database.Data.indexOf(element)).strings_of_elements[0]!=null ? 
                 panelMenuLines.database.Data.get(panelMenuLines.database.Data.indexOf(element)).strings_of_elements[0].toString()
                 :"");
        
      
       
        database = panelMenuLines.database;
        this.element = element;
        new_element = false;
        
        
        
        jpanel = new JPanelElement(database,element);    
        
        jpanelW = new JPanelElementGlobaBottom(this,panelMenuLines);
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE );
        setVisible(true);
        setSize(1000, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        BorderLayout bl = new BorderLayout();
        addWindowListener(new Action());
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        bl.setHgap(40);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jpanel);
        
        
        con.add(scrollPane, BorderLayout.CENTER);        
        con.add(jpanelW,BorderLayout.EAST);
        

        
    } 
    
    public JFrameElement(JPanelMenuLines panelMenuLines) throws HeadlessException {
        super("Nový záznam");
        this.database = panelMenuLines.database;
        element = new Element(database.DE);
        new_element = true;        
        
        //database.Data.add(element);
        jpanel = new JPanelElement(database,element);    
        
        jpanelW = new JPanelElementGlobaBottom(this,panelMenuLines);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE );
        
         
        setVisible(true);
        setSize(1000, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        BorderLayout bl = new BorderLayout();
        addWindowListener(new Action());
        
        
        Container con = getContentPane();  
        con.setLayout(bl);       
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jpanel);
        
        
        con.add(scrollPane, BorderLayout.CENTER);        
        con.add(jpanelW,BorderLayout.EAST);
        
    }
    /**
     *
     */
    class Action implements WindowListener{
        /**
         *
         */
        JPanelElementGlobaBottom globaBottom = (JPanelElementGlobaBottom) jpanelW;
        

        @Override
        public void windowOpened(WindowEvent e) {
           
        }

        @Override
        public void windowClosing(WindowEvent e) {
            
           if(jpanel.isChanged()){ 
           JOptionPane  frame = new JOptionPane();
           Object[] options = {"uložit",
                    "zahodit změny",
                    "vráti se"};
            int n = JOptionPane.showOptionDialog(frame,
                 "Přejete si uložit záznam",
                    "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
             null,
            options,
            options[2]);
            if(n==0){
                globaBottom.save();
            } else {
                if(n==1){
                    dispose();
                } else {                    
                    setVisible(true);
                }
            } 
           } else {
               dispose();
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
