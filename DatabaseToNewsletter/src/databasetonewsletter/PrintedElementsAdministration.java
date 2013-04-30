/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Majitel
 */
public class PrintedElementsAdministration {
    ArrayList<PrintedElement> printed_el;
    protected StringBuilder stringBuilder;
    protected int actual_postion;
    private int global_index;
    private int global_start;
    private int global_end;
    
    public void PrintedElementsAdministration(ArrayList<Database> databases) {
        printed_el = new ArrayList<>(20);
        global_index = 0;
        
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
        int end_read;
        String copyString = null;
        for (int i = 0; i < printed_el.size(); i++) {
            if(printed_el.get(i).count != 0){
                getTarge(Integer.toString(i));
                start_read = global_start;
                getTarge(Integer.toString(i));
                end_read = global_end;
                copyString = stringBuilder.substring(start_read, end_read);
                stringBuilder.insert(actual_postion, System.getProperty("line.separator") + copyString);
                actual_postion = 2*actual_postion-start_read;
            } else {
                getTarge(Integer.toString(i));
                start_read = global_start;
                getTarge(Integer.toString(i));
                end_read = global_end;
                stringBuilder.delete(start_read, end_read);
                actual_postion = start_read;
            }
            
        }
        String [] ss;
        String write = "";
        
        for (int i = 0; i < printed_el.size(); i++) {
            for (int j = 0; j <= printed_el.get(i).database.Data.size() ; j++) {
                if(printed_el.get(i).database.Data.get(j).printed){
                for (int k = 1; k < printed_el.get(i).database.DE.length; k++) {
                  if((!"".equals(printed_el.get(i).database.Data.get(j).strings_of_elements[k]))){
                    switch (printed_el.get(i).database.DE[k].type) {
                        case DATE:                
                            ss = printed_el.get(i).database.Data.get(j).strings_of_elements[k].split("[.]");
                            write = Integer.toString(Integer.parseInt(ss[0])) + "." + Integer.toString(Integer.parseInt(ss[1]));
                            insertText(write,printed_el.get(i).database.DE[k]);
                            break;
                        case TIME:
                            ss = printed_el.get(i).database.Data.get(j).strings_of_elements[k].split("[:]");
                            write = Integer.toString(Integer.parseInt(ss[0])) + ":" + Integer.toString(Integer.parseInt(ss[1]));
                            insertText(write,printed_el.get(i).database.DE[k]);
                            break;
                        case URL:
                            insertURL(write,printed_el.get(i).database.DE[k]);
                            break;
                        case TEXT:
                            insertText(write,printed_el.get(i).database.DE[k]);
                            break;
                        case VARCHAR:
                            insertText(write,printed_el.get(i).database.DE[k]);
                            break;
                        
                        }
                    }
                    
                }
             }
            }
        }
 
    
    }
    
    public void getTarge(String target) {
        char ch = ' ';
        String ss = null; 
        int index = global_index;
        int save_index=0;
        while(ch != '<'){
           
        if(ch == '!') {
            save_index = index-1;
              if(ch == '-'){                        
                  if(ch == '-'){
                       while(true){
                         while(ch != '-') {
                               
                         }
                         if(ch == '-'){
                              if(ch == '>'){
                                  if(ss.equals(target)){
                                      global_start = save_index;
                                      global_end = index;
                                      return;
                                  }
                                    
                              }                                
                         }
                      }
                    }                    
               }
        }
        }
        global_start = -1;
        global_end = -1;
            
     }
    
    
    
    
    public void insertText(String insertString,DataElement DE){
        getTarge(DE.name());
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, insertString);
       
    }
    
    public void insertURL(String insertString,DataElement DE){
        getTarge(DE.name());
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(DE.name());
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");
        
    }
    
    
    class PrintedElement implements Comparable<PrintedElement>{
    private int number;
    protected int count;
    protected Database database;

    public PrintedElement(Database database) {
             this.database = database;
             number = database.database.number;
             int c = 0;
             for (int i = 0; i < database.Data.size(); i++) {
                 if(database.Data.get(i).printed){
                    c++; 
                 }
             }
             count = c;
      
    }
    

    @Override
    public int compareTo(PrintedElement o) {
        return this.number - o.number;
    }
   }
}
