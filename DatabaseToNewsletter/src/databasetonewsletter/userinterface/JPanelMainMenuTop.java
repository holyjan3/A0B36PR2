/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import com.toedter.calendar.JCalendar;
import databasetonewsletter.GlobalSave;
import databasetonewsletter.PrintedElementsAdministration;
import databasetonewsletter.WorkerDatabase;
import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;



public class JPanelMainMenuTop extends javax.swing.JPanel {


    JPanelCalendar calendar;

    PrintedElementsAdministration printedElement;

    public JPanelMainMenuTop(JPanelCalendar calendar) {
        initComponents();
        this.calendar = calendar;
        
         
        try{
            GlobalSave.getText();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Nepodařilo se nahrát záhlaví nebo zápatí ", "", JOptionPane.ERROR_MESSAGE);
        }
        this.heading.setText(GlobalSave.getHEADING());
        this.footer.setText(GlobalSave.getFOOTER());
        
        //this.printer.setEnabled(false);
        //this.preview.setEnabled(false);
    }

 
    public String getFooter() {
        return footer.getText();
    }


    public String getHeading() {
        return heading.getText();
    }
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preview = new javax.swing.JButton();
        printer = new javax.swing.JButton();
        make = new javax.swing.JButton();
        heading = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        footer = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();

        preview.setText("náhled");
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        printer.setText("uložit do html souboru");
        printer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printerActionPerformed(evt);
            }
        });

        make.setText("spracuj newsletter");
        make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeActionPerformed(evt);
            }
        });

        heading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headingActionPerformed(evt);
            }
        });
        heading.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                headingFocusLost(evt);
            }
        });

        footer.setColumns(15);
        footer.setLineWrap(true);
        footer.setRows(2);
        footer.setWrapStyleWord(true);
        footer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                footerFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(footer);

        label1.setText("záhlaví");

        label2.setText("zápatí");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addComponent(heading))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(printer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(make, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(make, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
       try {
           PrintedElementsAdministration.previewCode();
       }
       catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(null, "Nepodařilo se otevřít soubor ", "", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_previewActionPerformed

    private void printerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printerActionPerformed
      JFileChooser chooser = new JFileChooser(); 
      
      
      chooser.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
          return f.getName().toLowerCase().endsWith(".html")
              || f.isDirectory();
        }

        @Override
        public String getDescription() {
          return "HTML Files";
        }
      });
    int r = chooser.showSaveDialog(this);  
      
     
     while (r == 0) {          
        String zipname = chooser.getSelectedFile().getPath();  
        File f = new File(zipname);
        
        if(f.exists()){
            int n = JOptionPane.showConfirmDialog(null, "Přejete si přepsat existující soubor ?", "",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(n == 0){ 
                try {
                    PrintedElementsAdministration.saveFile(zipname);
                    break;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Nepodařilo se otevřít soubor ", "", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            else {
                r = chooser.showSaveDialog(this);
            }
            
        }else {    
             try {
                    PrintedElementsAdministration.saveFile(zipname);
                    break;
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null, "Nepodařilo se otevřít soubor ", "", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
        }       
        
      }
    }//GEN-LAST:event_printerActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
       
            
            GlobalSave.setFOOTER(this.heading.getText());
            GlobalSave.setHEADING(this.footer.getText());
             
            if(calendar.cal == null){
                
               
            new JFrameMenuAll(null);
            } else {
                
                new JFrameMenuAll(calendar.cal.getDate());
            }
                    
      
    }//GEN-LAST:event_makeActionPerformed

    private void headingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headingActionPerformed

    private void headingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headingFocusLost
        GlobalSave.setHEADING(this.heading.getText());
    }//GEN-LAST:event_headingFocusLost

    private void footerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_footerFocusLost
         GlobalSave.setFOOTER(this.footer.getText());
        
    }//GEN-LAST:event_footerFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea footer;
    private javax.swing.JTextField heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JButton make;
    private javax.swing.JButton preview;
    private javax.swing.JButton printer;
    // End of variables declaration//GEN-END:variables
}