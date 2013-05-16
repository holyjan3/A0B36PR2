/*                                      
 * To change this template, choose Tools | Templates                                     
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


/**
 * Panel s tlačítky pro úpravu jendnoho záznamu
 * @author Jan Holý
 */
public class JPanelElementGlobaBottom extends javax.swing.JPanel {

    JPanelElement panelElement;
    
    JFrameElement frameElement;
    
    JPanelMenuLines panelMenuLines;

    Boolean check;
    
    public JPanelElementGlobaBottom(JFrameElement  frameElement, JPanelMenuLines panelMenuLines) {
        initComponents();
        this.frameElement = frameElement;
        this.panelElement = frameElement.jpanel;
        this.panelMenuLines = panelMenuLines;
        this.jCheckBox1.setSelected(panelElement.element.isPrinted());
        check = panelElement.element.isPrinted();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollbar1 = new java.awt.Scrollbar();
        saveExit = new javax.swing.JButton();
        restoreAll = new javax.swing.JButton();
        deleteAll = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        remove1 = new javax.swing.JButton();
        saveNot = new javax.swing.JButton();

        saveExit.setBackground(java.awt.Color.green);
        saveExit.setText("Uložit a zavřít");
        saveExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveExitMouseClicked(evt);
            }
        });
        saveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveExitActionPerformed(evt);
            }
        });

        restoreAll.setText("Obnovi vše");
        restoreAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restoreAllMouseClicked(evt);
            }
        });
        restoreAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreAllActionPerformed(evt);
            }
        });

        deleteAll.setText("Vymazat všechen text");
        deleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAllMouseClicked(evt);
            }
        });

        jCheckBox1.setText("Vytisknout");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        remove1.setBackground(java.awt.Color.red);
        remove1.setForeground(new java.awt.Color(255, 255, 255));
        remove1.setText("Odstanit událost");
        remove1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove1MouseClicked(evt);
            }
        });
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        saveNot.setBackground(java.awt.Color.yellow);
        saveNot.setText("zahodit změny");
        saveNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(remove1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveNot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restoreAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(saveExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveNot, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(restoreAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        JCheckBox box = (JCheckBox) evt.getSource();
        check = box.isSelected();
      
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void deleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAllMouseClicked
       
     
        for (int i = 0; i < panelElement.text.length; i++) {
            
            panelElement.delete(i);
        }
  
    }//GEN-LAST:event_deleteAllMouseClicked

    private void restoreAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreAllMouseClicked
       
        for (int i = 0; i < panelElement.text.length; i++) {
            panelElement.restore(i);
 
        }
    }//GEN-LAST:event_restoreAllMouseClicked

    private void saveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveExitActionPerformed
      
    }//GEN-LAST:event_saveExitActionPerformed

   
    public void saveElement(){
         if(this.jCheckBox1.isSelected()){
             panelElement.element.setPrinted(true);
        }else {
            panelElement.element.setPrinted(false);
        }
        
         
        for (int i = 0; i < this.panelElement.element.strings_of_elements.length; i++) {
            panelElement.element.strings_of_elements[i] = panelElement.text[i].getText();
            
        }
      
        
        if(frameElement.new_element){
           
            panelElement.database.nowWorkDatabase.addElementt(panelElement.element);
            
        } else {
            panelElement.database.nowWorkDatabase.modifyElement(panelElement);
            panelElement.element.setPrinted(this.jCheckBox1.isSelected(), panelElement.element.getKey());
             
        }
        
        panelMenuLines.overWritePanel();
        frameElement.dispose();
    }
    
 
    public void save(){
        if(checkData()){
            saveElement();
        } 
            
    }
    

    public boolean checkData(){
        for (int i = 0; i < this.frameElement.jpanel.jLabelsError.length; i++) {
            if(this.frameElement.jpanel.jLabelsError[i].isVisible() && this.frameElement.jpanel.jLabelsError[i].getText().equals(this.frameElement.jpanel.ss1)){
                JOptionPane  frame = new JOptionPane();
                Object[] options = {"uložit",
                    "vráti se"};
             int n = JOptionPane.showOptionDialog(frame,
                 "Dojde ke strátě dat jelikož některá data nejsou správně zadána",
                    "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                 null,
                options,
                options[1]);
            
            if(n == 0){
                return true;
            } else {
                return false;
            }
          }
            
        }
        return true;
    }
    
    private void saveExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveExitMouseClicked
       save();
        
    }//GEN-LAST:event_saveExitMouseClicked
    
    public void remove(){
        if(panelElement.database.Data.contains(panelElement.element)){
            panelElement.database.nowWorkDatabase.removeElement(panelElement.element);
        } else {
            panelMenuLines.overWritePanel();
            frameElement.dispose();
            
        }
    } 
    
    
    private void remove1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove1MouseClicked
        remove();
    }//GEN-LAST:event_remove1MouseClicked

    private void saveNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNotActionPerformed
        frameElement.dispose();
    }//GEN-LAST:event_saveNotActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remove1ActionPerformed

    private void restoreAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restoreAllActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteAll;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton remove1;
    private javax.swing.JButton restoreAll;
    private javax.swing.JButton saveExit;
    private javax.swing.JButton saveNot;
    private java.awt.Scrollbar scrollbar1;
    // End of variables declaration//GEN-END:variables
}
