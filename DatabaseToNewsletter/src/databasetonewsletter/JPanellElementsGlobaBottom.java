/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JPanellElementsGlobaBottom extends JPanel{

    public JPanellElementsGlobaBottom() {
        GroupLayout layout = new GroupLayout(this);
        GridLayout gr = new GridLayout(3, 1);
        gr.setRows(20);
        gr.setVgap(10);
        setLayout(gr);
        
        
        JCheckBox jbox;
        jbox = new JCheckBox("vytisknout");
        JButton saveAll = new JButton("Ulozit vše");
        JButton replaceAll = new JButton("Obnovi vše");
        JButton deleteAll = new JButton("Vymazat vše");
        
        
        this.add(saveAll);            
        this.add(replaceAll);
        this.add(deleteAll);
        this.add(jbox);
    }
    
}
