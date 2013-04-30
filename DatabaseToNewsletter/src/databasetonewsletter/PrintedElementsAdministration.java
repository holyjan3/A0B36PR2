/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Majitel
 */
public class PrintedElementsAdministration {
    ArrayList<PrintedElement> printed_el;
    protected StringBuilder stringBuilder;
    protected int actual_postion;
    
    public PrintedElementsAdministration(ArrayList<Database> databases) {
        printed_el = new ArrayList<>(20);
        for (int i = 0; i < databases.size(); i++) {
            printed_el.add(new PrintedElement(databases.get(i)));
        }     
        Collections.sort(printed_el);
        stringBuilder = new StringBuilder();
        actual_postion = 0;
        
        
        boolean b = true;
        while(b){
            stringBuilder = stringBuilder.append("");
        }
        
        int start_read;
        String copyString = null;
        for (int i = 0; i < printed_el.size(); i++) {
            if(printed_el.get(i).count != 0){
                getTarge(Integer.toString(i));
                start_read = actual_postion;
                copyString = copyText(Integer.toString(i));
                stringBuilder.insert(actual_postion, System.getProperty("line.separator") + copyString);
                actual_postion = 2*actual_postion-start_read;
            } else {
                getTarge(Integer.toString(i));
                start_read = actual_postion;
                copyText(Integer.toString(i));
                stringBuilder.delete(start_read, actual_postion);
                actual_postion = start_read;
            }
            
        }
        
        for (int i = 0; i < printed_el.size(); i++) {
            for (int j = 1; j <= printed_el.get(i).count ; j++) {
                for (int k = 0; k < printed_el.get(i).database.DE.length; k++) {
                    switch (printed_el.get(i).database.DE[k].type) {
                        case DATE:
                            break;
                        case TIME:
                            break;
                        case URL:
                            break;
                        case TEXT:
                            break;
                        case VARCHAR:
                            break;
                        
                    }
                    
                }
            }
        }
 
    
    }
    
    public void getTarge(String target) {
        char ch = ' ';
        String ss = null;       
        if(ch == '!') {             
              if(ch == '-'){                        
                  if(ch == '-'){
                       while(true){
                         while(ch != '-') {
                               
                         }
                         if(ch == '-'){
                              if(ch == '>'){
                                    return;
                              }                                
                         }
                      }
                    }                    
               }
        }
            
     }
    
    
    public void insertText(){
        
       
    }
    
    public void inserURL(){
        
    }
    
    
   public String copyText(String target){
      char ch = ' ';
      String ss;
      for (int i = 1; i < 10; i++) {
      while(ch!=' '){
      if(ch == '<'){
            getTarge(target);
      if(target != null){
      break;
      }
      }
      }
      for (int j = 0; j < 10; j++) {
     
      }
      }
      return null;
  }    
  
}
