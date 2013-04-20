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
    Database database;
    protected int[] array;
    protected int length_array;
    protected DataElements[] dataElementses;

    public JPanelMenuLines(Database database) {
        this.database = database;  
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        array = new int[8];
        dataElementses = new DataElements[8];
        length_array=0;
        for (int i = 0; i < database.DE.length; i++) {
            switch ((database.DE[i])) {               
                case DAY:
                case MONTH:                   
                case TOWN:
                case NAME:
                case MEDIUM:
                    dataElementses[length_array] = database.DE[i];
                    array[length_array] = i;
                    length_array++;
                    break;               
            }
        }                             
            
        
          for (int i = 0; i < database.Data.size();i++) {
              add(new JPanelMenuLine(i));
          }
                
        } 
        
  
    
    public void overWritePanel(){
        this.removeAll();
        for (int i = 0; i < database.Data.size(); i++) {
            add(new JPanelMenuLine(i));
        }
    }
    
    public void addLine(){
           add(new JPanelMenuLine(database.Data.size()));
    }
    
   
    class JPanelMenuLine extends JPanel
    {
        JRadioButton jrb;
        JCheckBox checkBox; 
        public JPanelMenuLine(int numberLine) {
              jrb = new JRadioButtonWithNumber(numberLine);
              checkBox = new JCheckBox();
              checkBox.setFocusable(true);
              
              if(Boolean.parseBoolean(database.Data.get(numberLine).strings_of_elements[0])){
                  checkBox.setSelected(true);
              } else {
                  checkBox.setSelected(false);
              }
              checkBox.setEnabled(false);
              
              JLabel label;
              JButton jButton;
              label= new JLabel(database.Data.get(numberLine).strings_of_elements[1].substring(0, DataElements.HEAD.LINE_SIZE));
              label.setSize(DataElements.HEAD.LINE_SIZE, 1);
              
              for (int i = 0; i < length_array; i++) {
                   label= new JLabel(database.Data.get(numberLine).strings_of_elements[array[i]].substring(0,dataElementses[array[i]].LINE_SIZE));
                   label.setSize(dataElementses[array[i]].LINE_SIZE, 1); 
              }        
              jButton = new JButtonWithNumber(numberLine, "upravit");
        }       
   
    }
    
}

