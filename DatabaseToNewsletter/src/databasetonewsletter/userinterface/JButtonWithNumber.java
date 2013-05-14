/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import javax.swing.JButton;

/**
 *
 * @author Majitel
 */
public class JButtonWithNumber extends JButton{
    /**
     *
     */
    public final int number;

    /**
     *
     * @param number
     * @param text
     */
    public JButtonWithNumber(int number, String text) {
        super(text);
        this.number = number;
    }
    
    
}
