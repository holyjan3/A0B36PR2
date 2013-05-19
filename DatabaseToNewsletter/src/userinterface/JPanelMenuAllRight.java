/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import createemail.GlobalSave;
import createemail.CreateEmail;
import databasework.WorkerDatabase;
import javax.swing.JOptionPane;

/**
 * tlačítko pro vytvoření nového emailu
 * @author Jan Holý
 */
public class JPanelMenuAllRight extends javax.swing.JPanel {
    

    JFrameMenuAll frameMenuAll;
    public JPanelMenuAllRight( JFrameMenuAll frameMenuAll) {
        initComponents();
         this.frameMenuAll = frameMenuAll;
         
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        preview2 = new javax.swing.JButton();

        jButton1.setText("<html><p style=\"text-align: center;\"> T <br /> I <br/> S <br /> K </p> </html>");
        jButton1.setHideActionText(true);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        preview2.setText("<html><p style=\"text-align: center;\"> N <br /> Á <br/> H<br /> L  <br/>E<br/>D</p> </html>");
        preview2.setActionCommand("<html><p style=\"text-align: center;\"> N <br /> Á <br/> H<br /> L  <br/>E<br/>D</p> </html>");
        preview2.setFocusable(false);
        preview2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preview2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(preview2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          boolean b = true;
        try {          
            GlobalSave.printedElement.setDatabases(WorkerDatabase.conectDatabeses.getDataDatabases());
            GlobalSave.printedElement.PrintElement();
            GlobalSave.printedElement.insertText(GlobalSave.saveData.getHEADING(), "HEADING", 0);
            GlobalSave.printedElement.insertText(GlobalSave.saveData.getFOOTER(), "FOOTER", 0);
            GlobalSave.printedElement.saveTempfile();
            GlobalSave.saveData.setTEMPLATE( GlobalSave.printedElement.getFile_source());
        } catch (Exception e) {
            //System.out.println(e.getCause());   
            JOptionPane.showMessageDialog(null, "Email se nepodařilo vytisknout zkontrolujte prosím šablonu", "", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void preview2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview2ActionPerformed
        try {
            GlobalSave.printedElement.previewCode();
        }
        catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(null, "Nepodařilo se otevřít soubor ", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_preview2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton preview2;
    // End of variables declaration//GEN-END:variables
}
