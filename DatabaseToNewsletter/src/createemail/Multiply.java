/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package createemail;

import databasedata.Database;




 /**
 * třída která slouží k rozmnožení disjunktních podřetězců daného emailu a vloží do nich přepřipravená dat
 * @author Jan Holý
 */
public class Multiply implements Runnable{
        
    private Database database;        
    private StringBuilder stringBuilder;        
    private int number;        
    private int count;        
    private int global_start = 0;        
    private int global_end = 0;

        
    /**
     * 
     * @param database databáze
     * @param charSequence podřetězec
     * @param number číslo položky
     * @param count počet záznamů
     */
    public Multiply( Database database, CharSequence charSequence, int number,int count) {
            this.database = database;
            this.stringBuilder = new StringBuilder(charSequence);
            this.number = number;
            this.count = count;
        }
        

        @Override
        public void run() {
            copyElement();
            insertElements();
        }  
        
        
      
        
   
    
    
    
    private  void copyElement(){
        // rozmonožení předdefinovaných prvkú
        int start=0;
        int start_read =0;
        int end_read =0;
      
         
  
                int addsubstring = stringBuilder.length();
                String copyString = stringBuilder.substring(start_read, addsubstring);
                for (int j = 1; j <count; j++) {       
                    stringBuilder.insert(start, System.getProperty("line.separator") + copyString);
                    addsubstring = addsubstring + System.getProperty("line.separator").length();
                }                

                
    }
    
    
    
    private  void insertElements() {
          
        int start = 0;
        int c;
        String [] ss;
        String write = "";
        //int i = number;
       c = 0;
            for (int j = database.Data.size()-1; j >=0  && c<count; j--) {
                if(database.Data.get(j).isPrinted()){
                    c++;
                    getTarge(Integer.toString(number), start);
                    start = global_end;
                    for (int k = 0; k < database.DE.length; k++) {
                        if((!"".equals(database.Data.get(j).strings_of_elements[k]))&&database.Data.get(j).strings_of_elements[k]!=null ){
                            switch (database.DE[k].type) {
                                case DATE:                
                                ss = database.Data.get(j).strings_of_elements[k].split("[.]");
                                write = Integer.toString(Integer.parseInt(ss[0])) + "." + Integer.toString(Integer.parseInt(ss[1]));                            
                                insertNumber(write,database.DE[k].name(),start);
                                break;
                            case TIME:
                                ss = database.Data.get(j).strings_of_elements[k].split("[:]");
                                write = Integer.toString(Integer.parseInt(ss[0])) + ":" + ss[1];
                                insertNumber(write,database.DE[k].name(),start);
                                break;
                            case URL:
                                insertURL(database.Data.get(j).strings_of_elements[k],database.DE[k].name(),start);
                                break;
//                            case TEXT:             
//                                insertText(database.Data.get(j).strings_of_elements[k],database.DE[k].name(),start);
//                                break;
                            case VARCHAR:
                                insertText(database.Data.get(j).strings_of_elements[k],database.DE[k].name(),start);
                                break;
                        
                        }
                    }
                    
                }
               getTarge(Integer.toString(number), start);
               start = global_end;
              
                }
        }
        
    
    }
    
    

    
    
    private void getTarge(String target,int start) {
    
        int save_index=0;
        int i=start;
        StringBuilder sc = new StringBuilder(10);
        StringBuilder scn = new StringBuilder(2);
        int length = stringBuilder.length();
        while(i<length){
        if(stringBuilder.charAt(i) == '<'){
            i++;
        if(i<length && stringBuilder.charAt(i)  == '!') {
            save_index = i-1;
            i++;            
              if(i<length && stringBuilder.charAt(i)  == '-'){
                  i++;
                  if(stringBuilder.charAt(i)  == '-'){
                      i++;
                       while(i<length){
                         while(i<length && stringBuilder.charAt(i) != '-') {
                            sc.append(stringBuilder.charAt(i));
                            i++;    
                         }
                         i++;
                         scn.append('-');
                         if(i<length && stringBuilder.charAt(i)== '-'){
                             i++;
                             scn.append('-');
                             if(i<length && stringBuilder.charAt(i)== '>'){
                                  if(sc.toString().equals(target)){
                                      global_start = save_index;
                                      global_end = i+1;
                                      return;
                                  } else {
                                      sc.delete(0, sc.capacity());
                                      scn.delete(0, scn.capacity());
                                      break;
                                  }
                                    
                              }                                
                         }
                        sc.append(scn); 
                      }
                    }                    
               }
             }
          } else {
          i++;  
          }
        }
        global_start = -1;
        global_end = -1;
            
     } 
    
    
    private void insertNumber(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,insertString);    
    }
    
    
    
   private  void insertText(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        insertString = HtmlEscape.escape(insertString);
        stringBuilder.insert(global_start,insertString);
       
    }
    
    
   private void insertURL(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        insertString = HtmlEscape.escapeTextArea(insertString);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");      
    }  

    /**
     * 
     * @return vrátí vytvořený řetězec
     */
    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
    
    
 }      