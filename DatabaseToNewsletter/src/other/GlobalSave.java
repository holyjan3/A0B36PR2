/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import createemail.CreateEmail;
import createemail.CreateEmail;
import createemail.SaveData;


/**
 * uloží vybraná data do textového souboru (Záhlaví a Zápatí)
 * @author Jan Holý
 */
public class GlobalSave {
    public static SaveData saveData;
    public static CreateEmail printedElement;
    public GlobalSave(SaveData saveData,CreateEmail printedElement) {
        GlobalSave.saveData = saveData;
        GlobalSave.printedElement = printedElement;
    } 
}
