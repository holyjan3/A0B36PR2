/*//GEN-FIRST:event_comboBoxActionPerformed
 * To change this template, choose Tools | Templates//GEN-LAST:event_comboBoxActionPerformed
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
/**
 *
 * @author Majitel
 */
public class JPanelMenulButtonTop extends javax.swing.JPanel {
    private String findInText="Vyhledat v Názvech";
    ArrayList<Integer> array;
    Database database;
    JFrameMenu jFrameMenu;
    
    public JPanelMenulButtonTop(JFrameMenu jFrameMenu) {
        this.jFrameMenu = jFrameMenu;
        initComponents();
        this.database= jFrameMenu.database;
        DataElement [] DE = database.DE;
        array = new ArrayList<>(8);
        array.add(0,0);
        array.addAll(jFrameMenu.array);
        int j = 1;
       
        
        comboBox.addItem(DataElement.PRINTED.toString());       
        comboBox.addItem(DataElement.HEAD.toString());        
        
        for (int i = 0; i < DE.length; i++) {
           if(DE[i].sort()){
                    comboBox.addItem(DE[i].toStringSort()); 
                    
            }           
        }
        
         comboBox.setSelectedIndex(1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox();
        arrange = new javax.swing.JButton();
        addElement = new javax.swing.JButton();
        findExit = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        findButton1 = new javax.swing.JButton();

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

        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        arrange.setText("seřadit");
        arrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrangeActionPerformed(evt);
            }
        });

        addElement.setText("přidej záznam");
        addElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElementActionPerformed(evt);
            }
        });

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

        saveButton.setText("uložit");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addElement, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrange)
                .addGap(33, 33, 33)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(findButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(findExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(findExit)
                        .addComponent(findButton1))
                    .addComponent(comboBox)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(arrange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1))
                    .addComponent(addElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

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

    private void arrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeActionPerformed
        int i = comboBox.getSelectedIndex();
        if(i==0){
            jFrameMenu.database.sortPrint();
        } else {
            if(jFrameMenu.database.DE[array.get(i)] == DataElement.DATE){
                jFrameMenu.database.sortDate(array.get(i));
            } else {                
                 jFrameMenu.database.sortString(array.get(i)); 
            }
                            
        }
        jFrameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_arrangeActionPerformed

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

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        database.saveToFile();
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElement;
    private javax.swing.JButton arrange;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JButton findButton1;
    private javax.swing.JButton findExit;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
