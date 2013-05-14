/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import com.toedter.calendar.JCalendar;
import databasetonewsletter.WorkerDatabase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class JPanelCalendar extends javax.swing.JPanel {

 
    
    com.toedter.calendar.JCalendar cal;

    JPanelMenuLines jPanelMenuLines;

    String ss ="Vyber všechny záznami";
    
    Date date;
    
    public JPanelCalendar(JPanelMenuLines jPanelMenuLines,Date date) {
       
        initComponents();
        this.jPanelMenuLines = jPanelMenuLines;
        this.date =date;
   
       SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
       jLabel1.setText( "Záznamy od data "+formatDate.format(date).toString());

    jLabel1.setOpaque(true);
    
    
    }

    class DATE extends JFrame{

        JButton close;

        JButton every_time;

        JButton choose_date;
       
        JButton rest_default;
        
        
        
        
      
        DATE(){
           
        close = new JButton("zavřít");
        every_time = new JButton("všechny záznami");
        rest_default = new JButton("mladší 3 měsícu");
        choose_date = new JButton("vyber datum");
        
        
        close.setForeground(Color.white);
        choose_date.setBackground(Color.green);
        choose_date.setOpaque(true);
        
        every_time.setBackground(Color.yellow);
        every_time.setOpaque(true);
        
        close.setBackground(Color.red);
        close.setOpaque(true);
        
        
        rest_default.setBackground(Color.MAGENTA);
        
        
        setLayout(new BorderLayout());
         
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        
       
        Dimension dim = new Dimension(500, 300);
        setSize(dim);
        setMaximumSize(dim);
        setResizable(false);
        
        cal= new JCalendar();       
        cal.setSize(dim);
        cal.setDate(date);
        setAlwaysOnTop( true );
       
        
       
        
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                            }

            @Override
            public void windowClosing(WindowEvent e) {
                jButton1.setEnabled(true);
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
        });
        
        close.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                jButton1.setEnabled(true);
            }
        });
        
         every_time.addActionListener( new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                //WorkerDatabase.date = null;
                date = new Date();
                date.setHours(0);
                date.setMinutes(0);
                date.setSeconds(0);               
                
                //date = c.getD
                cal = null;
                if(jPanelMenuLines != null){
                   
                    jPanelMenuLines.database.nowWorkDatabase.readFromDatabase(null);
                    jPanelMenuLines.overWritePanel();
                    
                    
                } else {
                    WorkerDatabase.date = null;
                }
                 jLabel1.setText(ss);
                 jButton1.setEnabled(true);
                 dispose();
            
            }
        });
         
         
         choose_date.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             
                Date d = cal.getDate();
                d.setHours(0);
                d.setMinutes(0);
                d.setSeconds(0);
              
                date = d;
                if(jPanelMenuLines != null){
                 
                    jPanelMenuLines.database.nowWorkDatabase.readFromDatabase(d);
                    jPanelMenuLines.overWritePanel();
                } else {
                    WorkerDatabase.date = d;                    
                }
                
                
                
                
                jLabel1.setText(d.toString());
                SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
                jLabel1.setText( "Od data "+formatDate.format(d).toString());
                dispose();
                jButton1.setEnabled(true);
            }
            
            });
         
         rest_default.addActionListener(new ActionListener() {
             
             
             

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = WorkerDatabase.setDate();                
                if(jPanelMenuLines != null){
                 
                    jPanelMenuLines.database.nowWorkDatabase.readFromDatabase(d);
                    jPanelMenuLines.overWritePanel();
                } else {
                    WorkerDatabase.date = d;                    
                }
                date = d;
                jLabel1.setText(d.toString());
                SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
                jLabel1.setText( "Od data "+formatDate.format(d).toString());
                dispose();
                jButton1.setEnabled(true);
            }
        });
         
        
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - getWidth();
        int y = (int) rect.getMaxY() - getHeight();
        setLocation(x, y);
        setVisible(true);
          
        
        this.revalidate();
        setVisible(true);
        
        
        add(cal,BorderLayout.CENTER);
        jPanel.add(choose_date);
        jPanel.add(rest_default);
        jPanel.add(every_time);
        jPanel.add(close);
        add(jPanel,BorderLayout.SOUTH);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("vybrat všechny záznamy");

        jButton1.setBackground(new java.awt.Color(255, 153, 255));
        jButton1.setText("Zvolit datum");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new DATE();
        jButton1.setEnabled(false);
        
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}