/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import javax.swing.JButton;

/**
 *
 * @author Majitel
 */
public class JButtonWithNumber extends JButton{
    final int number;

    public JButtonWithNumber(int number, String text) {
        super(text);
        this.number = number;
    }
    
    
}
