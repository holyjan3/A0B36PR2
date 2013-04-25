/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Majitel
 */
public class PrintedElementsAdministartion {
    ArrayList<PrintedElement> printed_el;
    public PrintedElementsAdministartion() {
        printed_el = new ArrayList<>(20);
        while(true)// dokud neprectes vsechnuy soubory v slozce
        {
            //precte prvni radku v soubour nastavi boolean
            //nacte ostatni radky
            printed_el.add(new PrintedElement(null, null, true));
            break;
        }
        
        Collections.sort(printed_el);
        // tady to vybere nejvetsi poocet stringu
        int max_count_string=0;
        // tady musi byt zacleneni udalost... 
        
        
        for (int i = 0; i < printed_el.size(); i++) {
            
        }
        
        for (int i = max_count_string-1; i>=0 ; i--) {
            
        }
        
        
    }  

   
    
}
