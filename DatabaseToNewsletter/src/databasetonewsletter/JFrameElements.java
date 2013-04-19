/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.DataElements.DAY;
import static databasetonewsletter.DataElements.HEAD;
import static databasetonewsletter.DataElements.HEAD_LINK;
import static databasetonewsletter.DataElements.HOUR;
import static databasetonewsletter.DataElements.LINK1;
import static databasetonewsletter.DataElements.LINK1_TEXT;
import static databasetonewsletter.DataElements.LINK2;
import static databasetonewsletter.DataElements.LINK2_TEXT;
import static databasetonewsletter.DataElements.LINK3;
import static databasetonewsletter.DataElements.LINK3_TEXT;
import static databasetonewsletter.DataElements.MEDIUM;
import static databasetonewsletter.DataElements.MINUTE;
import static databasetonewsletter.DataElements.MONTH;
import static databasetonewsletter.DataElements.NAME;
import static databasetonewsletter.DataElements.PLACE;
import static databasetonewsletter.DataElements.TEXT;
import static databasetonewsletter.DataElements.TOWN;
import static databasetonewsletter.DataElements.YEAR;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JFrameElements extends JFrame{
    
    JTextField[] text;
    JButton[] save;
    protected int jtext_height;
    protected int jtext_width;
    
    
        
        
   

    JFrameElements(DataElements[] DE) {
        setVisible(true);
       
        
        
        
        text = new JTextField[DE.length];
        save = new JButton[DE.length];
        
       
        
        for (int i = 0; i < DE.length; i++) {
            switch (DE[i]) {
                case DAY:
                   jtext_height = 2;                             
                    break;
                case MONTH:
                    jtext_height = 2;
                    break;
                case YEAR:
                    jtext_height = 2;
                    break;
                case HOUR:
                    jtext_height = 2;
                    break;
                case MINUTE:
                    jtext_height = 2;
                    break;
                case HEAD:
                    jtext_height = 2;
                    break;
                case HEAD_LINK:
                    jtext_height = 2;
                    break;
                case TOWN:
                    jtext_height = 2;
                    break;
                case PLACE:
                    jtext_height = 2;
                    break;
                case TEXT:
                    jtext_height = 2;
                    break;
                case LINK1_TEXT:
                    jtext_height = 2;
                    break;
                case LINK2_TEXT:
                    jtext_height = 2;
                    break;
                case LINK3_TEXT:
                    jtext_height = 2;
                    break;
                case LINK1:
                    jtext_height = 2;
                    break;
                case LINK2:
                    jtext_height = 2;
                    break;
                case LINK3:
                    jtext_height = 2;
                    break;
                case NAME:
                    jtext_height = 2;
                    break;
                case MEDIUM:
                    jtext_height = 2;
                    break;                   
            }
            text[i] = new JTextField(i);           
            save[i] = new JButtonWithNumber(i, "ulozit");            
            this.add(text[i]);
            this.add(save[i]);
    }
 }   
    

}