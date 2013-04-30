/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author Majitel
 */
public class JPanelMainMenuTop extends javax.swing.JPanel {

    /**
     * Creates new form JPanelMainMenuTop
     */
    
    PrintedElementsAdministration printedElement;
    public JPanelMainMenuTop() {
        initComponents();
        printedElement = new PrintedElementsAdministration();
        this.printer.setEnabled(false);
        this.preview.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preview = new javax.swing.JButton();
        printer = new javax.swing.JButton();
        make = new javax.swing.JButton();

        preview.setText("náhled");
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        printer.setText("tisk");
        printer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printerActionPerformed(evt);
            }
        });

        make.setText("zpracuj newsletter");
        make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(make, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(printer)
                        .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
        // TODO add your handling code here:
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
            
            r = chooser.showSaveDialog(this);
            
            
        }else {
            
            
            break;
        }  
        
        
      }
    }//GEN-LAST:event_printerActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
        boolean b = true;
        try {
            //printedElement.printedElements(null);
        } catch (Exception e) {
            b = false;
        }
        if(b){
           this.preview.setEnabled(true);
           this.printer.setEnabled(true);
           this.preview.revalidate();
           this.printer.revalidate();
        } else {
          // vyskakovac9 okno ...   
        }
    }//GEN-LAST:event_makeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton make;
    private javax.swing.JButton preview;
    private javax.swing.JButton printer;
    // End of variables declaration//GEN-END:variables
}
