/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.DataElement;
import java.util.ArrayList;
import javax.swing.JRadioButton;


public class JPanelMenuButtonBottom extends javax.swing.JPanel {

    ArrayList<Integer> array;

    JPanelMenu frameMenu;

    public JPanelMenuButtonBottom(JPanelMenu frameMenu) {
        initComponents();
        this.frameMenu = frameMenu;
        
        
        
        array = new ArrayList<>(8);
        array.add(0,0);
        array.addAll(frameMenu.array);
        int j = 1;
      
      
        comboBox.addItem("Vyštěno");       
        comboBox.addItem("Nadpisu");        
        
        for (int i = 0; i < frameMenu.database.DE.length; i++) {
           if(frameMenu.database.DE[i].sort()){
                    comboBox.addItem(frameMenu.database.DE[i].toStringSort()); 
                    
            }           
        }
        
        comboBox.setSelectedIndex(1);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        selectCancel = new javax.swing.JButton();
        selectAll = new javax.swing.JButton();
        eneblePrint = new javax.swing.JButton();
        disablePrint = new javax.swing.JButton();
        selectToNotPrinted = new javax.swing.JButton();
        selectToPrinted = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        arrange = new javax.swing.JButton();

        jButton4.setText("jButton1");

        selectCancel.setBackground(new java.awt.Color(102, 255, 204));
        selectCancel.setForeground(new java.awt.Color(255, 0, 0));
        selectCancel.setText("zrušit výběr");
        selectCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCancelActionPerformed(evt);
            }
        });

        selectAll.setBackground(new java.awt.Color(102, 255, 204));
        selectAll.setText("vybrat vše");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });

        eneblePrint.setBackground(new java.awt.Color(255, 255, 102));
        eneblePrint.setText("přidat k tisku");
        eneblePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eneblePrintActionPerformed(evt);
            }
        });

        disablePrint.setBackground(new java.awt.Color(255, 255, 102));
        disablePrint.setForeground(new java.awt.Color(255, 0, 0));
        disablePrint.setText("odstranit z tisku");
        disablePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disablePrintActionPerformed(evt);
            }
        });

        selectToNotPrinted.setBackground(new java.awt.Color(102, 255, 204));
        selectToNotPrinted.setText("<html>vybrat </br> k nevytištění</html>");
        selectToNotPrinted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectToNotPrintedActionPerformed(evt);
            }
        });

        selectToPrinted.setBackground(new java.awt.Color(102, 255, 204));
        selectToPrinted.setText("<html>vybrat</br> k vytištění</html>");
        selectToPrinted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectToPrintedActionPerformed(evt);
            }
        });

        comboBox.setBackground(new java.awt.Color(192, 192, 242));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        arrange.setBackground(new java.awt.Color(175, 175, 255));
        arrange.setText("seřadit");
        arrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectToNotPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectToPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectCancel)
                .addGap(18, 18, 18)
                .addComponent(eneblePrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disablePrint)
                .addGap(35, 35, 35)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrange)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectToNotPrinted)
                        .addComponent(selectToPrinted)
                        .addComponent(selectCancel)
                        .addComponent(eneblePrint)
                        .addComponent(disablePrint)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrange)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        for (int i = 0; i < frameMenu.menuLines.jrb.size(); i++) {
                JRadioButton button =frameMenu.menuLines.jrb.get(i);
                button.setSelected(true);
                button.revalidate();
        }
    }//GEN-LAST:event_selectAllActionPerformed

    private void selectCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCancelActionPerformed
        for (int i = 0; i < frameMenu.menuLines.jrb.size(); i++) {
                JRadioButton button =frameMenu.menuLines.jrb.get(i);
                button.setSelected(false);
                button.revalidate();
        }
    }//GEN-LAST:event_selectCancelActionPerformed

    private void eneblePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eneblePrintActionPerformed
         for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.isSelected()){                   
                    button.element.setPrinted(true,button.element.getKey());
                    
                }
        }
        frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_eneblePrintActionPerformed

    private void disablePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disablePrintActionPerformed
        for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.isSelected()){                   
                    button.element.setPrinted(false,button.element.getKey());
                }
        }
        frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_disablePrintActionPerformed

    private void selectToNotPrintedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectToNotPrintedActionPerformed
         for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(!button.element.isPrinted()){                   
                    button.setSelected(true);
                    button.revalidate();
                }
        } 
        
         
    }//GEN-LAST:event_selectToNotPrintedActionPerformed

    private void selectToPrintedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectToPrintedActionPerformed
        
        for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.element.isPrinted()){                   
                    button.setSelected(true);
                    button.revalidate();
                }
        } 
   
    }//GEN-LAST:event_selectToPrintedActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void arrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeActionPerformed
        int i = comboBox.getSelectedIndex();
        if(i==0){
            frameMenu.database.sortPrint();
        } else {
            if(frameMenu.database.DE[array.get(i)] == DataElement.DATE){
                frameMenu.database.sortDate(array.get(i));
            } else {
                frameMenu.database.sortString(array.get(i));
            }

        }
        frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_arrangeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arrange;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JButton disablePrint;
    private javax.swing.JButton eneblePrint;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton selectAll;
    private javax.swing.JButton selectCancel;
    private javax.swing.JButton selectToNotPrinted;
    private javax.swing.JButton selectToPrinted;
    // End of variables declaration//GEN-END:variables
}