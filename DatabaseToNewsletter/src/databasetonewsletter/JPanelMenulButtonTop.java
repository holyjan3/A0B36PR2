/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JPanelMenulButtonTop extends JPanel{
    Element element;

    public JPanelMenulButtonTop(Element element) {
        this.element = element;
        boolean bdate = false;
        int[] array = new int[6];
        array[0] = 0;
        array[1] = 1;
        int j = 1;
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(DataElements.PRINTED.name());
        comboBox.addItem(DataElements.HEAD.name());        
        comboBox.setSelectedIndex(2);
        
        for (int i = 0; i < element.DE.length; i++) {
            switch ((element.DE[i])) {                
                case DAY:                   
                case TOWN:
                case NAME:
                case MEDIUM:
                    comboBox.addItem(element.DE[i].name());
                    j++;
                    array[j]=i;
                    break;               
            }
            
        }
            JButton addElement = new JButton("přidej text");
            JButton arrange = new JButton("seřadit");
            JButton upload  = new JButton("nahrát z databáze");
            JButton export  = new JButton("vložit do databáze");     
    
    
    
    
    }
    
}
