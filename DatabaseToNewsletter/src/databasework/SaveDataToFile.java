/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import createemail.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Majitel
 */
public class SaveDataToFile  extends SaveData{
    
    private String HEADING;    
    private String FOOTER;
    private String TEMPLATE;
    private String CONECTIONURL;
    private final String separator = "####################";
    private final  String nameFile ="globalsave.txt";

    public String getCONECTIONURL() {
        return CONECTIONURL;
    }

    public boolean setCONECTIONURL(String CONECTIONURL) {
       if(CONECTIONURL == null || !CONECTIONURL.equals(separator)){
            this.CONECTIONURL= CONECTIONURL;
            return true;
        } else {
            return false;
        }
    }

    
    
    
    /**
     * nastaví zápatí
     * @param FOOTER zápatí
     * @return false v případě že se název rovná separátoru
     */  
    
    public boolean setFOOTER(String FOOTER) {
         if(FOOTER == null || !FOOTER.equals(separator)){
            this.FOOTER= FOOTER;
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
    public boolean setHEADING(String HEADING) {
        if(HEADING == null || !HEADING.equals(separator)){
            this.HEADING = HEADING;
            return true;
        } else {
            return false;
        }
        
    }

    public String getTEMPLATE() {
       
        return TEMPLATE;
        
    }

   

    public  boolean setTEMPLATE(String TEMPLATE) {     
            
         if(TEMPLATE == null || !TEMPLATE.equals(separator)){
            this.TEMPLATE = TEMPLATE;
            return true;
        } else {
            return false;
        }
        
    }
    
    
    
    /**
     * získá záhlaví
     * @return
     */
    public String getHEADING() {
    
        return HEADING;
    }

    /**
     * získá zápatí
     * @return
     */
    public  String getFOOTER() {
        return FOOTER;
    }
    
    
    /**
     * nahraje data ze souboru
     * @throws FileNotFoundException 
     * @throws IOException
     */
    public  void getText() throws FileNotFoundException, IOException {
        BufferedReader bis = null;
        File f = new File(nameFile);
        if(f.exists()){
       
            bis = new BufferedReader(new FileReader(nameFile));
            HEADING = read(bis);
            FOOTER = read(bis);
            TEMPLATE = read(bis);
            CONECTIONURL = read(bis);
            bis.close();
        
      } else {
       HEADING="";
       FOOTER ="";
       TEMPLATE = "";
       CONECTIONURL = "";
      }
        
        
    }
    
    private  String read(BufferedReader br) throws IOException{
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
    
    

    private void save(BufferedWriter bw,String ss) throws IOException{
        bw.write(ss);
        bw.write(System.getProperty("line.separator"));
        bw.write(separator);
        bw.write(System.getProperty("line.separator"));
        
    }
    
    /**
     *  uloží text do souboru
     * @throws IOException
     */
    public  void saveText() throws IOException{
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
            save(bw,TEMPLATE);
            save(bw,CONECTIONURL);
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
