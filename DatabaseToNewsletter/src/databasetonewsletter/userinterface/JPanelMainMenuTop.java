/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import com.toedter.calendar.JCalendar;
import databasetonewsletter.GlobalSave;
import databasetonewsletter.PrintedElementsAdministration;
import databasetonewsletter.WorkerDatabase;
import java.awt.Dimension;
import java.io.*;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;



/**
 * Panel s tlačíty pro správu vytvoření emailu a s textovými poli pro zadání záhlaví a zápatí
 * @author Jan Holý
 */
public class JPanelMainMenuTop extends javax.swing.JPanel {


    JPanelCalendar calendar;
    String path;
    File f;

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
        f = new File(GlobalSave.getTEMPLATE());
        if(f.exists()){
            this.placeTemplate.setText(f.getAbsolutePath());
            
        }else {
             this.placeTemplate.setText("");
        }
        
   
    
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        preview = new javax.swing.JButton();
        printer = new javax.swing.JButton();
        make = new javax.swing.JButton();
        heading = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        footer = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        placeTemplate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        preview.setText("náhled");
        preview.setFocusable(false);
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        printer.setText("uložit do html souboru");
        printer.setFocusable(false);
        printer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printerActionPerformed(evt);
            }
        });

        make.setText("spracuj newsletter");
        make.setFocusable(false);
        make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeActionPerformed(evt);
            }
        });

        heading.setFocusable(false);
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
        footer.setFocusable(false);
        footer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                footerFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(footer);

        label1.setText("záhlaví");

        label2.setText("zápatí");

        placeTemplate.setText("jTextField1");
        placeTemplate.setFocusable(false);
        placeTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeTemplateActionPerformed(evt);
            }
        });

        jButton1.setText("vybrat místo šablony");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("místo uložené šablony ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(printer, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(make, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(placeTemplate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(make, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
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
      chooser.setPreferredSize( new Dimension(800, 500) );
      
      
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

    private void placeTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeTemplateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placeTemplateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             JFileChooser chooser;   
          if(f.exists()){
               chooser= new JFileChooser(f);
               
            
          } else {
              chooser = new JFileChooser();
          }
          chooser.setPreferredSize( new Dimension(800, 500) );
          
          int i =chooser.showOpenDialog(null);
          if(i == 0){
              String zipname = chooser.getSelectedFile().getPath();
              this.placeTemplate.setText(zipname);
              PrintedElementsAdministration.setFile_source(zipname);
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea footer;
    private javax.swing.JTextField heading;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JButton make;
    private javax.swing.JTextField placeTemplate;
    private javax.swing.JButton preview;
    private javax.swing.JButton printer;
    // End of variables declaration//GEN-END:variables
}
