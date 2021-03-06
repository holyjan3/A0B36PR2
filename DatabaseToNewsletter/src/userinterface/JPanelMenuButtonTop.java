/*                                         
 * To change this template, choose Tools | Templates                                        
 * and open the template in the editor.
 */
package userinterface;

import database.Database;


/**
 * Horní tlačítka pro práci s jedním typem záznamů 
 * @author Jan Holý
 */
public class JPanelMenuButtonTop extends javax.swing.JPanel {

    private String findInText="Vyhledat v Názvech"; 
    Database database; 
    JPanelMenu jFrameMenu;
  
    

    public JPanelMenuButtonTop(JPanelMenu jFrameMenu) {
        this.jFrameMenu = jFrameMenu;
        initComponents();
        this.database= jFrameMenu.database;

      
      
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        addElement = new javax.swing.JButton();
        findExit = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        findButton1 = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        jTextField2.setText("Najít v názvu");
        jTextField2.setToolTipText("");
        jTextField2.setName(""); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        addElement.setBackground(new java.awt.Color(102, 255, 102));
        addElement.setText("přidej záznam");
        addElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElementActionPerformed(evt);
            }
        });

        findExit.setBackground(new java.awt.Color(175, 175, 255));
        findExit.setForeground(new java.awt.Color(255, 0, 0));
        findExit.setText("zrušit hledání");
        findExit.setActionCommand("");
        findExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findExitActionPerformed(evt);
            }
        });
        findExit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                findExitFocusLost(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setText(this.findInText);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jTextField1VetoableChange(evt);
            }
        });

        findButton1.setBackground(new java.awt.Color(175, 175, 255));
        findButton1.setText("najít");
        findButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButton1ActionPerformed(evt);
            }
        });
        findButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                findButton1FocusLost(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 153, 153));
        delete.setText("smazat");
        delete.setFocusable(false);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addElement, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(findButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(findExit)
                .addGap(127, 127, 127)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addElement)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton1)
                    .addComponent(findExit)
                    .addComponent(delete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if(jTextField1.getText().equals("")){
            this.jTextField1.setText(findInText);
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        this.jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void addElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElementActionPerformed
        new JFrameElement(jFrameMenu.menuLines);
    }//GEN-LAST:event_addElementActionPerformed

    private void findExitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_findExitFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_findExitFocusLost

    private void findButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButton1ActionPerformed
        if(jTextField1.getText() != ""){            
        jFrameMenu.menuLines.find(jTextField1.getText().toLowerCase());
        }
    }//GEN-LAST:event_findButton1ActionPerformed

    private void findButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_findButton1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_findButton1FocusLost

    private void findExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findExitActionPerformed
       this.jTextField1.setText(findInText);
       jFrameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_findExitActionPerformed

    private void jTextField1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jTextField1VetoableChange
      
    }//GEN-LAST:event_jTextField1VetoableChange

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        for (JRadioButtonWithNumber button  :jFrameMenu.menuLines.jrb) {
            if(button.isSelected()){
                jFrameMenu.database.nowWorkDatabase.removeElement(button.element);
            }
        }
           jFrameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElement;
    private javax.swing.JButton delete;
    private javax.swing.JButton findButton1;
    private javax.swing.JButton findExit;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
