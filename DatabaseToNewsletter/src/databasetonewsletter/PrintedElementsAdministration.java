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
    protected static String file_temp_name = "newslettertemplate.html";
    protected static String file_source = "";
    
    public static void printElement(ArrayList<Database> databases1) throws IOException{
        databases = databases1;
        readFile();
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
    
    
    private static void readFile() throws IOException{
        String ss= file_source;
        BufferedReader input = new BufferedReader(new FileReader(ss));        
        stringBuilder = new StringBuilder();
        String line = null;
        while((line = input.readLine()) != null){
            stringBuilder.append(ss);
            stringBuilder.append(System.getProperty("line_separatot"));            
        }
        input.close();
        
    }
    
    
    
    private static void saveTempfile() throws IOException{
        FileWriter fileWriter = new FileWriter(file_temp_name);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
    
    
    private static void countElement(){
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
    }
    
    
  private static void copyElement(){
        // rozmonožení předdefinovaných prvkú
        int start=0;
        int start_read =0;
        int end_read =0;
         
        for (int i = 0; i < databases.size(); i++) {
            if(count[i] != 0 ){
                getTarge(Integer.toString(i),start);
                start_read = global_start;
                start = global_end+1;
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
                getTarge(Integer.toString(i),start);
                start_read = global_start;
                start = global_end+1;
                getTarge(Integer.toString(i),start);
                end_read = global_end;
                stringBuilder.delete(start_read, end_read);
                start = start_read;
            }
            
        }
    }
    
    
    private static void insertElements() {
        
        int start = 0;       
        String [] ss;
        String write = "";
        
        for (int i = 0; i < databases.size(); i++) {
            for (int j = 0; j < databases.get(i).Data.size() && j<count[i]; j++) {
                if(databases.get(i).Data.get(j).printed){
                getTarge(Integer.toString(i), start);
                start = global_end+1;
                for (int k = 1; k < databases.get(i).DE.length; k++) {
                  if((!"".equals(databases.get(i).Data.get(j).strings_of_elements[k]))){
                    switch (databases.get(i).DE[k].type) {
                        case DATE:                
                            ss = databases.get(i).Data.get(j).strings_of_elements[k].split("[.]");
                            write = Integer.toString(Integer.parseInt(ss[0])) + "." + Integer.toString(Integer.parseInt(ss[1]));                            
                            insertNumber(write,databases.get(i).DE[k],start);
                            break;
                        case TIME:
                            ss = databases.get(i).Data.get(j).strings_of_elements[k].split("[:]");
                            write = Integer.toString(Integer.parseInt(ss[0])) + ":" + Integer.toString(Integer.parseInt(ss[1]));
                            insertNumber(write,databases.get(i).DE[k],start);
                            break;
                        case URL:
                            insertURL(write,databases.get(i).DE[k],start);
                            break;
                        case TEXT:             
                            insertText(write,databases.get(i).DE[k],start);
                            break;
                        case VARCHAR:
                            insertText(write,databases.get(i).DE[k],start);
                            break;
                        
                        }
                    }
                    
                }
               getTarge(Integer.toString(i), start);
               start = global_end+1;
             }
            }
        }
        
    
    }
    
    

    
    private static void getTarge(String target,int start) {
        int index = start;
        int save_index=0;
        int i=0;
        StringBuilder sc = new StringBuilder(10);
        StringBuilder scn = new StringBuilder(2);
        int length = stringBuilder.length();
        while(i<length){
        if(stringBuilder.charAt(i) == '<'){
            i++;
        if(i<length && stringBuilder.charAt(i)  == '!') {
            save_index = index-1;
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
                             scn.append('-');
                             if(i<length && stringBuilder.charAt(i)== '>'){
                                  if(sc.toString().equals(target)){
                                      global_start = save_index;
                                      global_end = index;
                                      return;
                                  } else {
                                      sc.delete(0, sc.capacity());
                                      scn.delete(0, scn.capacity());
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
    
    private static void insertNumber(String insertString,DataElement DE,int start){
        getTarge(DE.name(),start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,insertString);    
    }
    
    
    private static void insertText(String insertString,DataElement DE,int start){
        getTarge(DE.name(),start);
        stringBuilder.delete(global_start, global_end);
        String ss = HtmlEscape.escapeTextArea(insertString);
        stringBuilder.insert(global_start,ss);
       
    }
    
    private static void insertURL(String insertString,DataElement DE,int start){
        getTarge(DE.name(),start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(DE.name(),start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");      
    }    

   }

