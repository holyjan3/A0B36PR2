/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedata;


/**
 * uloží vybraná data do textového souboru (Záhlaví a Zápatí)
 * @author Jan Holý
 */
public class GlobalSave {
    public static SaveData saveData;

    public GlobalSave(SaveData saveData) {
        GlobalSave.saveData = saveData;
    } 
}
