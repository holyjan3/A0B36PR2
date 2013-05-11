/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Majitel
 */
public class PrintedElementsAdministration {
    
    private StringBuilder stringBuilder;
    private  int global_start;
    private int global_end;
    private  int[] count;
    private Multiply[] multiply;
    private Thread[] threads;
    private ArrayList<Database> databases;
    protected static String file_temp_name = "temp.html" ;
    protected static String file_source = "newslettertemplate.txt";
    
    
    public PrintedElementsAdministration(ArrayList<Database> databases) throws IOException, InterruptedException{
        this.databases = databases;

        multiply = new Multiply[databases.size()];
        threads = new Thread[databases.size()];
        int start_read;
        int end_read;
        int start =0;
        boolean finshed = true;
        readFile();
        countElement();
         ExecutorService es = Executors.newCachedThreadPool(); 
        for (int i = 0; i < databases.size(); i++) {
            if(count[i]!= 0){
            getTarge(Integer.toString(i),start);
                finshed = false;
                start_read = global_start;
                start = global_end;
                getTarge(Integer.toString(i),start);
                end_read = global_end;                
                multiply[i] = new  Multiply(databases.get(i), stringBuilder.subSequence(start_read, end_read), i, count[i]);
                es.execute(multiply[i]);
                   
                stringBuilder.delete(start_read, end_read);
                String ss = "<!--"+Integer.toString(i)+"-->"; 
                stringBuilder.insert(start_read, ss);
                start = start_read;
                
                getTarge(Integer.toString(i),0);
              
                
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
        
        es.shutdown(); 
        while(!finshed){        
                finshed = es.awaitTermination(1, TimeUnit.SECONDS);
            
        }
        for(int i = databases.size()-1; i>=0 ; i--){
            if(count[i]!=0){
                 getTarge(Integer.toString(i),0);
                 int s =global_end;      
            stringBuilder.insert(s,multiply[i].stringBuilder1);
            }
            
        }
           
               
            
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
        if(url.contains(" ")){
        JOptionPane.showMessageDialog(null,"Náhled nebude zobrazen cesta obsahuje bílé znaky \n"
                + url,"", JOptionPane.ERROR_MESSAGE);
        }
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
    
    public void readFile() throws IOException{
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
    
    
    
    public void saveTempfile() throws IOException{
        FileWriter fileWriter = new FileWriter(file_temp_name);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
    

        
        
        
        
        
        
        
   
    
    
    //////////////////////////////////////////////////////////////////////////////
    
   public void countElement(){
        
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
//    
   public void insertNumber(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,insertString);    
    }
//    
//     
   public void insertText(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        insertString = HtmlEscape.escape(insertString);
        stringBuilder.insert(global_start,insertString);
       
    }
//    
    public void insertURL(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");      
    }    

   }

