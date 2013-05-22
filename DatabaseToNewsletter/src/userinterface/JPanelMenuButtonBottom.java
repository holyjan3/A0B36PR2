/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import databasework.DataElement;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


/**
 * Dolní tlačítka pro práci s jedním typem záznamů 
 * @author Jan Holý
 */
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
        jFrame1 = new javax.swing.JFrame();
        eneblePrint = new javax.swing.JButton();
        disablePrint = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        arrange = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        SelectBox = new javax.swing.JComboBox();
        selectCheckBox = new javax.swing.JCheckBox();

        jButton4.setText("jButton1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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

        comboBox.setBackground(new java.awt.Color(45, 45, 242));
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

        jPanel1.setBackground(new java.awt.Color(0, 255, 169));

        SelectBox.setBackground(new java.awt.Color(0, 255, 169));
        SelectBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "vyber vše", "vyber k vytiště", "vyber k nevytištění" }));
        SelectBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SelectBoxItemStateChanged(evt);
            }
        });
        SelectBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectBoxActionPerformed(evt);
            }
        });
        SelectBox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                SelectBoxCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        selectCheckBox.setBackground(new java.awt.Color(102, 255, 204));
        selectCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(eneblePrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disablePrint)
                .addGap(78, 78, 78)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrange)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arrange))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(disablePrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eneblePrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectAll(){
         for (int i = 0; i < frameMenu.menuLines.jrb.size(); i++) {
                JToggleButton  button =frameMenu.menuLines.jrb.get(i);
                button.setSelected(true);
                button.revalidate();
        }
    }
    
    private void selectCancel(){
        for (int i = 0; i < frameMenu.menuLines.jrb.size(); i++) {
                JToggleButton button =frameMenu.menuLines.jrb.get(i);
                button.setSelected(false);
                button.revalidate();
        }
    }
    
    private void eneblePrint(){
          for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.isSelected()){                   
                    button.element.setPrinted(true,button.element.getKey());
                }
        }
    }
    private void disablePrint(){
        for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.isSelected()){                   
                    button.element.setPrinted(false,button.element.getKey());
                }
        }
  
    }
    
    private void  selectToNotPrinted(){
        for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(!button.element.isPrinted()){                   
                    button.setSelected(true);
                    button.revalidate();
                }
        } 
    } 
   private void selectToPrinted() {                                                
        
        for (JRadioButtonWithNumber button  :frameMenu.menuLines.jrb) {
                if(button.element.isPrinted()){                   
                    button.setSelected(true);
                    button.revalidate();
                }
        }
        
   }
   
   
   
   
   
    private void eneblePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eneblePrintActionPerformed
      eneblePrint();
      this.SelectBox.setSelectedIndex(0);
      //this.selectCancel();
      this.selectCheckBox.setSelected(false);
      frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_eneblePrintActionPerformed

    private void disablePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disablePrintActionPerformed
      disablePrint();
      this.SelectBox.setSelectedIndex(0);
      this.selectCheckBox.setSelected(false);
      frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_disablePrintActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void arrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeActionPerformed
        int i = comboBox.getSelectedIndex();
        if(i==0){
            frameMenu.database.sortPrint();
        } else {
            if(frameMenu.database.DE[array.get(i)].name() == null ? DataElement.DATE.name() == null : frameMenu.database.DE[array.get(i)].name().equals(DataElement.DATE.name())){
                frameMenu.database.sortDate(array.get(i));
            } else {
                frameMenu.database.sortString(array.get(i));
            }

        }
        frameMenu.menuLines.overWritePanel();
    }//GEN-LAST:event_arrangeActionPerformed

    private void selectCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCheckBoxActionPerformed
        if(selectCheckBox.isSelected()){
            this.selectAll();
        }else {
            
            this.SelectBox.setSelectedIndex(0);
            this.selectCancel();
            this.selectCheckBox.setSelected(false);
     }
    }//GEN-LAST:event_selectCheckBoxActionPerformed

    private void SelectBoxCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_SelectBoxCaretPositionChanged
      
    }//GEN-LAST:event_SelectBoxCaretPositionChanged

    private void SelectBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SelectBoxItemStateChanged
       int i = 0;
        switch (SelectBox.getSelectedIndex()) {
            case 0:
                 this.selectCancel();
                this.selectAll();
                break;
           case 1:
                this.selectCancel();
                this.selectToPrinted();
                break;
               
           case 2: 
                this.selectCancel();
               this.selectToNotPrinted();
                break;
            default:
                throw new AssertionError();
        }
        
        this.selectCheckBox.setSelected(true);
        
     
    }//GEN-LAST:event_SelectBoxItemStateChanged

    private void SelectBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox SelectBox;
    private javax.swing.JButton arrange;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JButton disablePrint;
    private javax.swing.JButton eneblePrint;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox selectCheckBox;
    // End of variables declaration//GEN-END:variables
}
