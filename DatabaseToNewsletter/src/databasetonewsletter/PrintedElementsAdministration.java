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
public class PrintedElementsAdministration {
    ArrayList<PrintedElement> printed_el;
    public PrintedElementsAdministration() {
        printed_el = new ArrayList<>(20);            
        
    }
    
    
    
    public void insertText(){
        //najdi poyadovanz prvekjdi dokavad neojevi znacku smaz ji a vlo6 String....
    }
    
    
    public void copy() {
        // najdi znacku pozadovanou hodnotu
        // dokud nenakdes znacku dalsi kopiruj 
        // nasel si znacku za ni vloz newline a vloz nakopirovny retez podle pocu prvku
    }
    
    
    public void markMakerFile(){
        char ch = ' ';
        if(ch == '<'){
            while( ch == ' ') {
                // cti po zancch                 
            }
            switch (ch) {
                case '/':
                    // umisti znacku z interatoru a sniz ho....
                    break;
                case '!':
                        //precti dva znaky  potom cti dokud nenerazis na - cti dokud - jestli - je vetsi nez 2 a jestli dalsi ynak je  > konec jinak yacni hledat                       
                    break;
                default:
                    // zvys itrator a umisti znacku zacatecni
                    throw new AssertionError();
            }
        } else {
            // precti znak
        }
        
        /// budeš číst znak po znaku dokudnenarazíš na < ale ne načteš do zásobníku a dokud nenarazíš na další znak četš...  až do znaku nemezerového 
        // jestli narazíš na ! nezkládej jinak zvyš interátor o plusj
    }

   
    
}
