/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticClass;

import databasetonewsletter.SaveData;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * uloží vybraná data do textového souboru (Záhlaví a Zápatí)
 * @author Jan Holý
 */
public class GlobalSave {
    public static SaveData saveData;

    public GlobalSave() {
        this.saveData = new SaveData();
    } 
}
