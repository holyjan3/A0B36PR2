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
public class JPanelElementGlobaBottom extends JPanel{
    Database database;
    
    public JPanelElementGlobaBottom(Database database) {
        this.database = database;
        
        
        GroupLayout layout = new GroupLayout(this);
        GridLayout gr = new GridLayout(8, 1);       
        
        gr.setVgap(40);
     
        setLayout(gr);
        
        
        JCheckBox jbox;
        jbox = new JCheckBox("vytisknout",true);
        
        JButton remove = new JButton("odstanit udalost");
        JButton saveAll = new JButton("Ulozit vše");
        JButton replaceAll = new JButton("Obnovi vše");
        JButton deleteAll = new JButton("Vymazat vše");
        
        this.add(new JLabel());
        this.add(remove);
        this.add(saveAll);            
        this.add(replaceAll);
        this.add(deleteAll);
        this.add(jbox);
        
        
    }
    
    
    
}
