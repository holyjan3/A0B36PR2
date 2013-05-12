/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import com.toedter.calendar.JCalendar;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Majitel
 */
public class JPanelCalendar extends javax.swing.JPanel {

    /**
     * Creates new form JPanelCalendar
     */
    JPanelMenuLines jPanelMenuLines;
    String ss ="Vyber všechny záznami";
    public JPanelCalendar(JPanelMenuLines jPanelMenuLines) {
        initComponents();
        this.jPanelMenuLines = jPanelMenuLines;
        if(WorkerDatabase.date == null){
            jLabel1.setText(ss);
        } else {
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
            jLabel1.setText( "Záznamy od data "+formatDate.format(WorkerDatabase.date).toString());
        }
        
    jLabel1.setOpaque(true);
    
    
    }
    
    class DATE extends JFrame{
        JButton close;
        JButton every_time;
        JButton choose_date;
        
        com.toedter.calendar.JCalendar cal;
        
        
        DATE(){
        close = new JButton("zavřít");
        every_time = new JButton("všechny záznami");
        choose_date = new JButton("vyber datum");
        
        close.setForeground(Color.white);
        choose_date.setBackground(Color.green);
        choose_date.setOpaque(true);
        
        every_time.setBackground(Color.yellow);
        every_time.setOpaque(true);
        
        close.setBackground(Color.red);
        close.setOpaque(true);
        
        
        setLayout(new BorderLayout());
         
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        
       
        Dimension dim = new Dimension(500, 300);
        setSize(dim);
        setMaximumSize(dim);
        setResizable(false);
        
        cal= new JCalendar();
        cal.setSize(dim);
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
                WorkerDatabase.date = null;
                if(jPanelMenuLines != null){
                   
                    jPanelMenuLines.database.nowWorkDatabase.readFromDatabase();
                    jPanelMenuLines.overWritePanel();
                    
                    
                }
                 jLabel1.setText(ss);
                 jButton1.setEnabled(true);
                 dispose();
            
            }
        });
         
         
         choose_date.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WorkerDatabase.date = cal.getDate();
                WorkerDatabase.date.setHours(0);
                WorkerDatabase.date.setMinutes(0);
                WorkerDatabase.date.setSeconds(0);
                
                if(jPanelMenuLines != null){
                 
                    jPanelMenuLines.database.nowWorkDatabase.readFromDatabase();
                    jPanelMenuLines.overWritePanel();
                } else {
                    
                }
                
                
                
                
                jLabel1.setText(WorkerDatabase.date.toString());
                SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
                jLabel1.setText( "Od data "+formatDate.format(WorkerDatabase.date).toString());
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
        jPanel.add(every_time);
        jPanel.add(close);
        add(jPanel,BorderLayout.SOUTH);

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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