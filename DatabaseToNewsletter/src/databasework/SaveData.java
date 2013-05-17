/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jan Holýl
 */
public abstract class SaveData {
    abstract public String getCONECTIONURL();
    
    abstract public boolean setCONECTIONURL(String CONECTIONURL);

    
    abstract public boolean setFOOTER(String FOOTER);

  
    abstract public boolean setHEADING(String HEADING);
    
    abstract public String getTEMPLATE();
    
    abstract public boolean setTEMPLATE(String TEMPLATE);

    
    abstract public String getHEADING();
    
    abstract public String getFOOTER();

    
    abstract public void getText() throws FileNotFoundException, IOException;

   
    abstract public void saveText() throws IOException;  
}
