/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.WorkerDatabase;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameConect extends javax.swing.JFrame {

  
   
   
   
    public JFrameConect() {
        initComponents();      
        
        
        
        
        setVisible(true);
        setResizable(false);
        
        this.urlText.setText(WorkerDatabase.getDefoulteUrl());
        this.nameText.setText(WorkerDatabase.getDefoulteName());
        this.jPasswordField1.setText(WorkerDatabase.getDefoultePassword());
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


int w = getSize().width;
int h = getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
 

setLocation(x, y);
     
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameText = new javax.swing.JTextField();
        urlText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        changePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Newsletter Maker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        urlText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlTextActionPerformed(evt);
            }
        });

        jButton1.setText("Přihlásit se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("obnovit přihlašovací údaje");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Adresa databáze");

        jLabel3.setText("Uživatelské jméno");

        jLabel4.setText("Heslo");

        jPasswordField1.setText("jPasswordField1");

        changePassword.setText("změnit heslo");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(urlText, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(urlText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(changePassword)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void urlTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
      //url="jdbc:derby:C:/Users/Majitel/.netbeans-derby/Newsletters;create=true;user=root;password=root";
        //jdbc:derby:C:/Users/Majitel/Documents/NetBeansProjects/A0B36PR2/DatabaseToNewsletter/Newsletters;create=true;user=root;password=root
        String url;
  
         String name;
         String password; 
        
        
        
         Connection conn = null;
         name = this.nameText.getText();
         password = this.jPasswordField1.getText();
         url = this.urlText.getText();
        
        try {
         
          
          
          
            WorkerDatabase.setUrl(url);
            WorkerDatabase.setName(name);
            WorkerDatabase.setPassword(password);
            WorkerDatabase.conectOnlineDatabase();
            
             
            
            try {
                WorkerDatabase.WorkerDatabase();
                new JFrameMainMenu();
                this.dispose();
                
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(),
                "Nepodařilo se načíst databáze",
                "",
                JOptionPane.ERROR_MESSAGE);
                
                 try {
                        WorkerDatabase.conection.close();
                        
                    } catch (SQLException ex2) {
                   
                }
                
            }
             
        } catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            this.setEnabled(false);
            ErrorConectToDatabase er = new ErrorConectToDatabase();
             if(er.ErrorConectToDatabase()){
                try {
                    WorkerDatabase.WorkerDatabase();
                    new JFrameMainMenu(); 
                } catch (SQLException ex1) {
                    
                    JOptionPane.showMessageDialog(new JFrame(),
                    "Nepodařilo se načíst databáze",
                    "",
                     JOptionPane.ERROR_MESSAGE);
                    try {
                        WorkerDatabase.conection.close();
                    } catch (SQLException ex2) {
                        
                    }
                }
                                 
                 this.dispose();
             }else {
                 this.setEnabled(true);
             }
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.urlText.setText(WorkerDatabase.getDefoulteUrl());
       this.nameText.setText(WorkerDatabase.getDefoulteName());
       this.jPasswordField1.setText(WorkerDatabase.getDefoultePassword());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        this.setVisible(false);
        new ChangePassword(this);
    }//GEN-LAST:event_changePasswordActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameConect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameConect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameConect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameConect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                new JFrameConect().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField urlText;
    // End of variables declaration//GEN-END:variables
}
