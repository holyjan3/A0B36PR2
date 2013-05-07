/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Majitel
 */
public class PrintedElementsAdministration {
    
    private static StringBuilder stringBuilder;
    private static int global_start;
    private static int global_end;
    private static int[] count;
    private static ArrayList<Database> databases;
    protected static String file_temp_name = "aaaa.html" ;
    protected static String file_source = "aaa.txt";
    
    public static void printElement(ArrayList<Database> databases1) throws IOException{
        databases = databases1;
        readFile();
       
    }
    
    public static void saveInsert() throws IOException{
        countElement();       
        copyElement();
        insertElements();
        saveTempfile();
    }
    
    public static void saveFile(String saveFile) throws IOException{
        String s1= file_temp_name;
        String s2= saveFile;
        BufferedReader inputRead= null;
        BufferedWriter outputRead= null;        
        inputRead = new BufferedReader(new FileReader(file_temp_name));
        File f = new File(saveFile);
        outputRead = new BufferedWriter(new FileWriter(f,false));
        String line = null;
        while((line=inputRead.readLine()) != null){
            outputRead.append(line);
        }            
        inputRead.close();
        outputRead.close();        
        
    }
    
    public static void previewCode() throws IOException {
        File f = new File(file_temp_name);
        String url = "file://localhost/"+ f.getAbsolutePath().replace(File.separatorChar, '/');
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
    
    public static void readFile() throws IOException{
        String ss= file_source;
        BufferedReader input = new BufferedReader(new FileReader(ss));        
        stringBuilder = new StringBuilder();
        String line = null;
        while((line = input.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append("\r\n");            
        }
        input.close();
        
    }
    
    
    
    public static void saveTempfile() throws IOException{
        FileWriter fileWriter = new FileWriter(file_temp_name);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
    
    
   public static void countElement(){
        
       /*
       int max= 11;
          
        count = new int[11];
        for (int i = 0; i < max; i++) {
            count[i] = i;
        }
        /**/
        
        int c = 0;       
        count = new int[databases.size()]; 
        for (int i = 0; i < databases.size(); i++) {
            c=0;
             for (int j = 0; j < databases.get(i).Data.size() && ((j < DataDatabase.values()[i].max)|| (DataDatabase.values()[i].max ==0)); j++) {
                 if(databases.get(i).Data.get(j).printed){
                    c++; 
                 }
                 count[i]=c;
             }
        }
        /**/
    }
    
    
  public static void copyElement(){
        // rozmonožení předdefinovaných prvkú
        int start=0;
        int start_read =0;
        int end_read =0;
         
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0 ){
                getTarge(Integer.toString(i),start);
                start_read = global_start;
                start = global_end;
                getTarge(Integer.toString(i),start);
                end_read = global_end;
                int addsubstring = global_end-global_start;
                String copyString = stringBuilder.substring(start_read, end_read);
                start = end_read+1;
                // vloží šablony
                for (int j = 1; j <count[i]; j++) {       
                    stringBuilder.insert(start, System.getProperty("line.separator") + copyString);
                    start = start+addsubstring + System.getProperty("line.separator").length();
                }                
            } else {
                
                while(true){
                    start=0;
                    getTarge(Integer.toString(i)+"D",start);
                    start_read = global_start;
                    start = global_end;
                    if(global_end == -1)
                        break;
                    getTarge(Integer.toString(i)+"D",start);
                    end_read = global_end;
                    stringBuilder.delete(start_read, end_read);
                }
               global_start = 0;
               global_end = 0;
               start = 0;
               
            }
            
        }
    }
    
    
    private static void insertElements() {
          
        int start = 0;
        int c;
        String [] ss;
        String write = "";
        
        
        
        for (int i = 0; i < databases.size(); i++) {
            c = 0;
            for (int j = 0; j < databases.get(i).Data.size() && c<count[i]; j++) {
                if(databases.get(i).Data.get(j).printed){
                    c++;
                    getTarge(Integer.toString(i), start);
                    start = global_end;
                    for (int k = 1; k < databases.get(i).DE.length; k++) {
                        if((!"".equals(databases.get(i).Data.get(j).strings_of_elements[k]))){
                            switch (databases.get(i).DE[k].type) {
                                case DATE:                
                                ss = databases.get(i).Data.get(j).strings_of_elements[k].split("[.]");
                                write = Integer.toString(Integer.parseInt(ss[0])) + "." + Integer.toString(Integer.parseInt(ss[1]));                            
                                insertNumber(write,databases.get(i).DE[k].name(),start);
                                break;
                            case TIME:
                                ss = databases.get(i).Data.get(j).strings_of_elements[k].split("[:]");
                                write = Integer.toString(Integer.parseInt(ss[0])) + ":" + ss[1];
                                insertNumber(write,databases.get(i).DE[k].name(),start);
                                break;
                            case URL:
                                insertURL(databases.get(i).Data.get(j).strings_of_elements[k],databases.get(i).DE[k].name(),start);
                                break;
                            case TEXT:             
                                insertText(databases.get(i).Data.get(j).strings_of_elements[k],databases.get(i).DE[k].name(),start);
                                break;
                            case VARCHAR:
                                insertText(databases.get(i).Data.get(j).strings_of_elements[k],databases.get(i).DE[k].name(),start);
                                break;
                        
                        }
                    }
                    
                }
               getTarge(Integer.toString(i), start);
               start = global_end;
              System.out.println("aaa");
                }
            }
        }
        
    
    }
    
    

    
    private static void getTarge(String target,int start) {
    
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
    
   public static void insertNumber(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,insertString);    
    }
    
    
   public static void insertText(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        insertString = HtmlEscape.escape(insertString);
        stringBuilder.insert(global_start,insertString);
       
    }
    
    public static void insertURL(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");      
    }    

   }

