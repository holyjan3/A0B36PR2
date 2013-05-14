/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.Element;
import javax.swing.JRadioButton;

/**
 *
 * @author Majitel
 */
public class JRadioButtonWithNumber extends JRadioButton{
    /**
     *
     */
    public final int number;
    /**
     *
     */
    public Element element;
    /**
     *
     * @param number
     * @param element
     */
    public JRadioButtonWithNumber(int number,Element element) {
        this.element = element;
        this.number = number;
    }
    
    
}
