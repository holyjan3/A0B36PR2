/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import javax.swing.JCheckBox;

/**
 *
 * @author Majitel
 */
public class JPanelElementGlobaBottom extends javax.swing.JPanel {

    /**
     * Creates new form JPanelElementGlobaBottom
     */
    JPanelElement panelElement;
    JFrameElement frameElement;
    JPanelMenuLines panelMenuLines;
    public JPanelElementGlobaBottom(JFrameElement  frameElement, JPanelMenuLines panelMenuLines) {
        initComponents();
        this.frameElement = frameElement;
        this.panelElement = frameElement.jpanel;
        this.panelMenuLines = panelMenuLines;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollbar1 = new java.awt.Scrollbar();
        saveExit = new javax.swing.JButton();
        replaceAll = new javax.swing.JButton();
        deleteAll = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        remove1 = new javax.swing.JButton();

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

        replaceAll.setText("Obnovi vše");
        replaceAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replaceAllMouseClicked(evt);
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

        remove1.setText("Odstanit událost");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remove1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(replaceAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(saveExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(replaceAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        JCheckBox box = (JCheckBox) evt.getSource();
         panelElement.element.strings_of_elements[0] = Boolean.toString(!Boolean.parseBoolean(panelElement.element.strings_of_elements[0]));
         System.out.println(box.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void deleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAllMouseClicked
       
        if(!panelElement.deleteString.equals("")){
            panelElement.element.strings_of_elements[panelElement.deleteNumberString] = panelElement.deleteString;
            panelElement.deleteString = "";
        }
        for (int i = 1; i < panelElement.text.length; i++) {
            
            panelElement.text[i].setText("");
            System.out.println(i);
        }
    }//GEN-LAST:event_deleteAllMouseClicked

    private void replaceAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replaceAllMouseClicked
       
        for (int i = 1; i < panelElement.text.length; i++) {
           
            
            if((i != panelElement.deleteNumberString) || panelElement.deleteString.equals("")) {
            panelElement.text[i].setText(panelElement.element.strings_of_elements[i]);
            } else {
                    panelElement.text[i].setText(panelElement.deleteString);
                    panelElement.deleteString = "";
            }
            
        }
    }//GEN-LAST:event_replaceAllMouseClicked

    private void saveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveExitActionPerformed
      
    }//GEN-LAST:event_saveExitActionPerformed

    private void saveExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveExitMouseClicked
        if(this.jCheckBox1.isSelected()){
             panelElement.element.strings_of_elements[0] = Boolean.toString(true);
        }else {
            panelElement.element.strings_of_elements[0] = Boolean.toString(false);
        }
        
        for (int i = 1; i < this.panelElement.element.strings_of_elements.length; i++) {
            panelElement.element.strings_of_elements[i] = panelElement.text[i].getText();
        }
      
        
        if(frameElement.new_element){
            panelElement.database.nowWorkDatabase.modifyElement(panelElement);
            panelElement.database.nowWorkDatabase.addElementt(panelElement.element);
        } else {
            panelElement.database.nowWorkDatabase.modifyElement(panelElement);
        }
        panelMenuLines.overWritePanel();
        frameElement.dispose();
        
    }//GEN-LAST:event_saveExitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteAll;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton remove1;
    private javax.swing.JButton replaceAll;
    private javax.swing.JButton saveExit;
    private java.awt.Scrollbar scrollbar1;
    // End of variables declaration//GEN-END:variables
}
