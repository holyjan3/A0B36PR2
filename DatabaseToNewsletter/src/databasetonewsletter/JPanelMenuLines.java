/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Majitel
 */
public class JPanelMenuLines extends JPanel{
    Database database;
    protected ArrayList<Integer> array;
    protected int length_array;
    protected DataElement[] dataElementses;
    ArrayList<JRadioButtonWithNumber> jrb = new ArrayList<JRadioButtonWithNumber>(20);
    


    public JPanelMenuLines(Database database) {
        this.database = database;  
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        array = new ArrayList(8);
        dataElementses = new DataElement[8];
        length_array=0;
        for (int i = 0; i < database.DE.length; i++) {
            if(database.DE[i].sort()){
                    dataElementses[length_array] = database.DE[i];
                    array.add(length_array, i);
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
           JPanel jp = new JPanelMenuLine(i);
           add(jp);
        }
       this.revalidate();
       this.repaint();
      }
    
    public void addLine(){
           add(new JPanelMenuLine(database.Data.size()));
    }
    
   
    class JPanelMenuLine extends JPanel
    {
        
        JCheckBox checkBox;
        Element element;
        public JPanelMenuLine(int numberLine) {
              jrb.add(numberLine,new JRadioButtonWithNumber(numberLine,this));
              element = database.Data.get(numberLine);
              checkBox = new JCheckBox();
              checkBox.setFocusable(true);
              
              
              
              if(Boolean.parseBoolean(element.strings_of_elements[0])){
                  checkBox.setSelected(true);
              } else {
                  checkBox.setSelected(false);
              }
              checkBox.setEnabled(false);
              
              JLabel label;
              JButton jButton;
              
              label= new JLabel(element.strings_of_elements[1]);              
              label.setSize(DataElement.HEAD.LINE_SIZE, 1);
              
              for (int i = 0; i < length_array; i++) {
                   label= new JLabel(element.strings_of_elements[array.get(i)]);
                   label.setSize(dataElementses[array.get(i)].LINE_SIZE, 1); 
              }        
              jButton = new JButtonWithNumber(numberLine, "upravit");
              add(jrb.get(numberLine));
              add(checkBox);
              add(jButton);           
              
              
        }      
   
    }
    
}

