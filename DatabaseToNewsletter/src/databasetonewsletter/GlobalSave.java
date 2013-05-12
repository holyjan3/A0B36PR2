/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class GlobalSave {
    static String HEADING = "";
    static String FOOTER = "";
    static String separator = "###################";
    private static String nameFile ="globalsave.txt";
    public static void getText() {
        BufferedReader bis = null;
        File f = new File(nameFile);
        if(f.exists()){
        try {
            bis = new BufferedReader(new FileReader(nameFile));
            HEADING = read(bis);
            FOOTER = read(bis);
             bis.close();
        } catch (IOException ex) {
            Logger.getLogger(GlobalSave.class.getName()).log(Level.SEVERE, null, ex);
        } 
       }
        
        
    }
    
    public static String read(BufferedReader br) throws IOException{
        String line = "";
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!= null && (!line.equals(separator))){
            sb.append(line);
            sb.append("\n");
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    public static void save(BufferedWriter bw,String ss) throws IOException{
        bw.write(ss);
        bw.write(System.getProperty("line.separator"));
        bw.write(separator);
        bw.write(System.getProperty("line.separator"));
        
    }
    public static void saveText() throws IOException{
       File f = null;
       boolean bb = true;
        BufferedWriter bw = null;
        try {
        f= new File(nameFile);
            if(f.exists())
                f.delete();           
                bw = new BufferedWriter(new FileWriter(nameFile, true));
            save(bw,HEADING);
            save(bw,FOOTER);
        } catch (IOException ex) {
            bb = false;
        }       
        finally {
                try {
                    bw.close();
                } catch (IOException | NullPointerException e) {
                    bb = false;
                    throw e;
                
                }
                    
               
        }
        
        
           
    }   
    
}
