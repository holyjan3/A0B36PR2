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
    JPanelMenuLines.JPanelMenuLine line;
    public JRadioButtonWithNumber(int number,JPanelMenuLines.JPanelMenuLine line) {
        this.line = line;
        this.number = number;
    }
    
    
}
