/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * uloží vybraná data do textového souboru (Záhlaví a Zápatí)
 * @author Jan Holý
 */
public class GlobalSave {
    
    private static String HEADING = "";    
    private static String FOOTER = "";
    private final static String separator = "####################";
    private final static String nameFile ="globalsave.txt";

    /**
     * nastaví zápatí
     * @param FOOTER zápatí
     * @return false v případě že se název rovná separátoru
     */
    public static boolean setFOOTER(String FOOTER) {
         if(FOOTER == null || !FOOTER.equals(separator)){
            GlobalSave.FOOTER= FOOTER;
            return true;
        } else {
            return false;
        }
    }

    /**
     * nastaví záhlaví
     * @param HEADING záhlaví
     * @return false v případě že se název rovná separátoru
     */
    public static boolean setHEADING(String HEADING) {
        if(HEADING == null || !HEADING.equals(separator)){
            GlobalSave.HEADING = HEADING;
            return true;
        } else {
            return false;
        }
        
    }
    
    
    
    

    /**
     * získá záhlaví
     * @return
     */
    public static String getHEADING() {
        return HEADING;
    }

    /**
     * získá zápatí
     * @return
     */
    public static String getFOOTER() {
        return FOOTER;
    }
    
    
    /**
     * nahraje data ze souboru
     * @throws FileNotFoundException 
     * @throws IOException
     */
    public static void getText() throws FileNotFoundException, IOException {
        BufferedReader bis = null;
        File f = new File(nameFile);
        if(f.exists()){
       
            bis = new BufferedReader(new FileReader(nameFile));
            HEADING = read(bis);
            FOOTER = read(bis);
            bis.close();
        
      } else {
       HEADING="";
       FOOTER ="";
      }
        
        
    }
    
    private static String read(BufferedReader br) throws IOException{
        String line = "";
        StringBuilder sb = new StringBuilder("");
        boolean bb = false;
        while((line = br.readLine())!= null && (!line.equals(separator))){
            sb.append(line);
            sb.append("\n");
            bb = true;
        }
        if(bb)
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    

    private static void save(BufferedWriter bw,String ss) throws IOException{
        bw.write(ss);
        bw.write(System.getProperty("line.separator"));
        bw.write(separator);
        bw.write(System.getProperty("line.separator"));
        
    }
    
    /**
     *  uloží text do souboru
     * @throws IOException
     */
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
