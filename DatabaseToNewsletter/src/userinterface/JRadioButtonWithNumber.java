/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import databasefinal.Element;
import javax.swing.JRadioButton;

/**
 * Radian buom obahující třídu element a číslo
 * @author Jan Holý
 */
public class JRadioButtonWithNumber extends JRadioButton{
  
    public final int number;
  
    public Element element;
 
    public JRadioButtonWithNumber(int number,Element element) {
        this.element = element;
        this.number = number;
    }
    
    
}
