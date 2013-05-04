/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import javax.swing.JRadioButton;

/**
 *
 * @author Majitel
 */
public class JRadioButtonWithNumber extends JRadioButton{
    final int number;
    Element element;
    public JRadioButtonWithNumber(int number,Element element) {
        this.element = element;
        this.number = number;
    }
    
    
}
