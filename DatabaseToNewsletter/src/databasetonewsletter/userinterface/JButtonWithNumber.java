/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import javax.swing.JButton;

/**
 * tlačítko s číslem
 * @author Jan Holý
 */
public class JButtonWithNumber extends JButton{
 
    public final int number;


    public JButtonWithNumber(int number, String text) {
        super(text);
        this.number = number;
    }
    
    
}
