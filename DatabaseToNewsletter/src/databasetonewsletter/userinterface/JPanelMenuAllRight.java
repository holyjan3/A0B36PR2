/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.GlobalSave;
import databasetonewsletter.PrintedElementsAdministration;
import databasetonewsletter.WorkerDatabase;
import javax.swing.JOptionPane;

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

        jButton1.setText("<html><p style=\"text-align: center;\">\nT\n<br />\nI\n<br/>\nS\n<br />\nK\n</p>\n</html>");
        jButton1.setHideActionText(true);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          boolean b = true;
        try {            
            PrintedElementsAdministration pea = new PrintedElementsAdministration(WorkerDatabase.dataDatabases);
            pea.PrintElement();
            pea.insertText(GlobalSave.getHEADING(), "HEADING", 0);
            pea.insertText(GlobalSave.getFOOTER(), "FOOTER", 0);
            pea.saveTempfile();
            frameMenuAll.dispose();
        } catch (Exception e) {
            //System.out.println(e.getCause());   
            JOptionPane.showMessageDialog(null, "Email se nepodařilo vytisknout zkontrolujte prosím zdrojové soubory", "", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}