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
public class JPanelMenuLines extends JPanel{
    Element element;

    public JPanelMenuLines(Element element) {
        this.element = element;
        for (int i = 0; i < element.strings_of_elements.length; i++) {
            add(new JPanelMenuLine());
        }    
    
    }
    
    public void overWritePanel(){
        this.removeAll();
        for (int i = 0; i < element.strings_of_elements.length; i++) {
            add(new JPanelMenuLine());
        }
    }
    
   
    class JPanelMenuLine extends JPanel
    {

        public JPanelMenuLine() {       
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        for (int i = 0; i < element.DE.length; i++) {
            switch ((element.DE[i])) {
                case PRINTED:
                    break;
                case HEAD:
                    break;
                case DAY:
                    break;
                case MONTH:
                    break;
                case NAME:
                    break;
                case MEDIUM:
                    break;               
            }
        }
        
    }
    }
    
}
