/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import com.toedter.calendar.JCalendar;
import createemail.GlobalSave;
import createemail.CreateEmail;
import databasework.WorkerDatabase;
import java.awt.Dimension;
import java.io.*;
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
    File ff = new File("newslettertemplate.txt");//defolní šablony

  

    public JPanelMainMenuTop(JPanelCalendar calendar) {
        initComponents();
        this.calendar = calendar;
        
         
        try{
            GlobalSave.saveData.getText();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Nepodařilo se nahrát záhlaví nebo zápatí ", "", JOptionPane.ERROR_MESSAGE);
        }
        this.heading.setText(GlobalSave.saveData.getHEADING());
        this.footer.setText(GlobalSave.saveData.getFOOTER());
        f = new File(GlobalSave.saveData.getTEMPLATE());
        this.defoleteTemlateNotFound.setVisible(false);
        if(f != null && f.exists()){
            if(ff.getAbsolutePath() == f.getAbsolutePath() || !ff.exists()){
            this.sourceTemplate.setText(f.getAbsolutePath());
            } else {
                this.defaulteAdress.setSelected(true);
                 this.defoleteTemlateNotFound.setVisible(false);
                this.jButton1.setEnabled(false);
                this.sourceTemplate.setText(ff.getAbsolutePath());                
                this.sourceTemplate.setEnabled(false);
               
            }
            
            
        }else {
            if(ff.exists()){                
                this.defaulteAdress.setSelected(true);
                 this.defoleteTemlateNotFound.setVisible(false);
                this.jButton1.setEnabled(false);
                this.sourceTemplate.setText(ff.getAbsolutePath());                
                this.sourceTemplate.setEnabled(false);
                
            } else {
             this.sourceTemplate.setText("");
            }
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
        sourceTemplate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        defaulteAdress = new javax.swing.JCheckBox();
        defoleteTemlateNotFound = new javax.swing.JLabel();

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

        footer.setColumns(15);
        footer.setLineWrap(true);
        footer.setRows(2);
        footer.setWrapStyleWord(true);
        jScrollPane1.setViewportView(footer);

        label1.setText("záhlaví");

        label2.setText("zápatí");

        sourceTemplate.setText("jTextField1");
        sourceTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceTemplateActionPerformed(evt);
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

        defaulteAdress.setText("výchozí uloženíá šablona");
        defaulteAdress.setToolTipText("");
        defaulteAdress.setActionCommand("");
        defaulteAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaulteAdressActionPerformed(evt);
            }
        });

        defoleteTemlateNotFound.setForeground(java.awt.Color.red);
        defoleteTemlateNotFound.setText("nenašlo výchzí šablonu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(make, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printer, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sourceTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(defaulteAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(defoleteTemlateNotFound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(sourceTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(defaulteAdress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(defoleteTemlateNotFound, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(printer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(409, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
       try {
           GlobalSave.printedElement.previewCode();
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
                    GlobalSave.printedElement.saveFile(zipname);
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
                    GlobalSave.printedElement.saveFile(zipname);
                    break;
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null, "Nepodařilo se otevřít soubor ", "", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
        }       
        
      }
    }//GEN-LAST:event_printerActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
       
            
            GlobalSave.saveData.setFOOTER(this.footer.getText());
            GlobalSave.saveData.setHEADING(this.heading.getText());
            
            GlobalSave.printedElement.setFile_source(this.sourceTemplate.getText());
            if(calendar.cal == null){
            new JFrameMenuAll(null);
            } else {
                
                new JFrameMenuAll(calendar.cal.getDate());
            }
                    
      
    }//GEN-LAST:event_makeActionPerformed

    private void sourceTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceTemplateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceTemplateActionPerformed

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
              this.sourceTemplate.setText(zipname);
              GlobalSave.printedElement.setFile_source(zipname);
              this.defoleteTemlateNotFound.setVisible(false);
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void defaulteAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaulteAdressActionPerformed
         
       
        if(this.defaulteAdress.isSelected()){
            if(ff.exists()){
                this.defoleteTemlateNotFound.setVisible(false);
                this.jButton1.setEnabled(false);
                this.sourceTemplate.setText(ff.getAbsolutePath());
                
                this.sourceTemplate.setEnabled(false);
            } else {
                this.defaulteAdress.setSelected(false);
                this.defoleteTemlateNotFound.setVisible(true);
                this.sourceTemplate.setEnabled(true);
                this.jButton1.setEnabled(true);
            }      
        } else {
            this.defoleteTemlateNotFound.setVisible(false);
             this.sourceTemplate.setEnabled(true);
             this.jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_defaulteAdressActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox defaulteAdress;
    private javax.swing.JLabel defoleteTemlateNotFound;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JButton make;
    private javax.swing.JButton preview;
    private javax.swing.JButton printer;
    private javax.swing.JTextField sourceTemplate;
    // End of variables declaration//GEN-END:variables
}
