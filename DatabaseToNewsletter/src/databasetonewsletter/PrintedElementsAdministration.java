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
import javax.swing.JOptionPane;


/**
 * třída pro spracování emailu podle vstupníc dat
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
    private static String file_temp_name = "temp.html" ;    
    private static String file_source = "newslettertemplate.txt";
    
    
    
    /**
     * 
     * @param databases pole databází všech typů záznamů
     */
    public PrintedElementsAdministration(ArrayList<Database> databases) {
        this.databases = databases;

        multiply = new Multiply[databases.size()];
        threads = new Thread[databases.size()];
    }
    
    /**
     * rozmnoží jednotlivé záznamy podle jejich počtů s ohledem na maximální možný počet
     * @throws IOException
     * @throws InterruptedException
     */
    public void PrintElement()throws IOException, InterruptedException{
        
        int start_read;
        int end_read;
        int start =0;
        boolean finshed = true;
        readFile();
        countElement();
        ExecutorService es = Executors.newCachedThreadPool();
        int number;
        for (int i = 0; i < databases.size(); i++) {
            number = databases.get(i).id_database;
            if(count[i]!= 0){
                getTarge(Integer.toString(number),start);
                finshed = false;
                start_read = global_start;
                start = global_end;
                getTarge(Integer.toString(number),start);
                end_read = global_end;                
                multiply[i] = new  Multiply(databases.get(i), stringBuilder.subSequence(start_read, end_read),number, count[i]);
                es.execute(multiply[i]);
                   
                stringBuilder.delete(start_read, end_read);
                String ss = "<!--"+Integer.toString(number)+"-->"; 
                stringBuilder.insert(start_read, ss);
                start = start_read;
                
                getTarge(Integer.toString(number),0);
              
                
            } else {
                  while(true){
                    start=0;
                    getTarge(Integer.toString(number)+"D",start);
                    start_read = global_start;
                    start = global_end;
                    if(global_end == -1)
                        break;
                    getTarge(Integer.toString(number)+"D",start);
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
            stringBuilder.insert(s,multiply[i].getStringBuilder());
            }
            
        }
           
               
            
          saveTempfile();
    }
        
        
        
        
        
        
    
    
    /**
     * uloží vztvořený Substring do dočasného souboru vytvořený email do souboru
     * @param pathFile cesta k souboru
     * @throws IOException
     */
    public static void saveFile(String pathFile) throws IOException{
        String s1= file_temp_name;
        String s2= pathFile;
        BufferedReader inputRead= null;
        BufferedWriter outputRead= null;        
        inputRead = new BufferedReader(new FileReader(file_temp_name));
        File f = new File(pathFile);
        outputRead = new BufferedWriter(new FileWriter(f,false));
        String line = null;
        while((line=inputRead.readLine()) != null){
            outputRead.append(line);
        }            
        inputRead.close();
        outputRead.close();        
        
    }
    
    
    /**
     * metoda složí k zobrazení emailu v {@link #file_temp_name} složce
     * @throws IOException
     */
    public static void previewCode() throws IOException {
        File f = new File(file_temp_name);
       
        String url = "file://localhost/"+ f.getAbsolutePath().replace(File.separatorChar, '/');
        if(url.contains(" ")){
        JOptionPane.showMessageDialog(null,"Náhled nebude zobrazen cesta obsahuje bílé znaky \n"
                + url,"", JOptionPane.ERROR_MESSAGE);
        }
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
    
    
    /**
     * metoda načte {@link #file_source} soubor s předpřipravenou šablonou
     * @throws IOException
     */
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
    
    
    
    
    /**
     * metoda uloží vytvořený soubor do dočasného souboru {@link #file_temp_name}
     * @throws IOException
     */
    public void saveTempfile() throws IOException{
        FileWriter fileWriter = new FileWriter(file_temp_name);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
    }
    

    
    /**
     * metoda spočítá počet záznamů každého druhu záznamu k vložení do emailu a uloží je podle druhu zvlášť do pole {@link #count}
     */
    public void countElement(){
        
        
        int c = 0;       
        count = new int[databases.size()]; 
        for (int i = 0; i < databases.size(); i++) {
            c=0;
             for (int j = 0; j < databases.get(i).Data.size() && ((j < DataDatabase.values()[i].max)|| (DataDatabase.values()[i].max ==0)); j++) {
                 if(databases.get(i).Data.get(j).isPrinted()){
                    c++; 
                 }
                 count[i]=c;
             }
        }
        /**/
    }

    
    /**
     * Najde začátek a konec požadovaného cíle spoléhá na to, že to není koncový znak protože v emailu body
     * metoda uloží do globálních proměnných {@link #global_start} a {@link #global_end}  začátek a konec vyhledávaného řetězce 
     * @param target řetězec který mám vyhledávat
     * @param start od kterého místa mám vyhledávat
     */
    public void getTarge(String target,int start) {
    
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
    
    /**
     * vloží řetězec který nemusí být upraven do emailu (Datum, Čas)
     * @param insertString vkládaný řetězec
     * @param name jméno značky
     * @param start odkud začne prohledávat
     */
    public void insertNumber(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,insertString);    
    }
//    
//     
    
    /**
     * vloží Text do emailu
     * @param insertString Text který má být vložena
     * @param name jméno značky
     * @param start odkud začne prohledávat
     */
    public void insertText(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        insertString = HtmlEscape.escape(insertString);
        stringBuilder.insert(global_start,insertString);
       
    }
//    
    
    /**
     * vloží URL do emailu
     * @param insertString URL která má být vložena
     * @param name jméno značky
     * @param start odkud začne prohledávat
     */
    public void insertURL(String insertString,String name,int start){
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start, "<a href="+ insertString + ">" );
        
        getTarge(name,start);
        stringBuilder.delete(global_start, global_end);
        stringBuilder.insert(global_start,"</a>");      
    }    

   }

