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
public class GlobalSave implements  Serializable {
    static String HEADING = "";
    static String FOOTER = "";
    static String separator = "###################";
    private static String nameFile ="globalsave.txt";
    public static void getText() {
        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new FileReader(nameFile));
            HEADING = read(bis);
            FOOTER = read(bis);
             bis.close();
        } catch (IOException ex) {
            Logger.getLogger(GlobalSave.class.getName()).log(Level.SEVERE, null, ex);
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
    public static void saveText(){
            File f = new File(nameFile);
            if(f.exists())
                f.delete();
            BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f,true));
            save(bw,HEADING);
            save(bw,FOOTER);
        } catch (IOException ex) {
            Logger.getLogger(GlobalSave.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(GlobalSave.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
           
    }   
    
}
