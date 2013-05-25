/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import database.DataControl;
import databasework.DataElementInterface;



/**
 * Typy položek v záznamech
 * @author Jan Holý
 */
public enum DataElement implements DataElementInterface{
    /**
     * Nadpis
     */
    HEAD        (700,DataControl.VARCHAR),
    /**
     * Datum
     */
    DATE        (100,DataControl.DATE),
    /**
     * Čas
     */
    TIME        (0,DataControl.TIME),   
    /**
     * Odkaz nadpisu
     */

    /**
     * Město/Vesnice
     */
    TOWN        (200,DataControl.VARCHAR),
    /**
     * Místo
     */
    PLACE       (0,DataControl.VARCHAR),
    /**
     * Popis
     */
    TEXT        (800,DataControl.VARCHAR),
    /**
     * Popis Odkaz
     */
  
    TEXT_LINK   (0,DataControl.VARCHAR),
    HEAD_LINK   (0,DataControl.URL),
    /**
     * Popis odkazu 1
     */
    LINK1_TEXT  (0,DataControl.VARCHAR),
    /**
     * Popis odkazu 2
     */
    LINK2_TEXT  (0,DataControl.VARCHAR),
    /**
     * Popis odkazu 3
     */
    LINK3_TEXT  (0,DataControl.VARCHAR),
    /**
     * Odkaz 1
     */
    LINK1       (0,DataControl.URL),
    /**
     * Odkaz 2
     */
    LINK2       (0,DataControl.URL),
    /**
     * Odkaz 3
     */
    LINK3       (0,DataControl.URL),
    /**
     * Jméno osoby
     */
    NAME        (200,DataControl.VARCHAR),
    /**
     * Médium
     */
    MEDIUM      (200,DataControl.VARCHAR),
    /**
     * Typ události
     */
    TYPE        (200,DataControl.VARCHAR);    
    


    
    /**
     * určuje velikost buňky ve které se zobrazuje
     */
    final private int LINE_SIZE;
    
    /**
     * typ kontroly dané položky union DataControl
     */
    final private DataControl type;
    
    /**
     * maximální počet znaků položky
     */
    public int getLINE_SIZE() {
        return LINE_SIZE;
    }

    public DataControl getType() {
        return type;
    }

    
    
  
    private DataElement(int LINE_SIZE, DataControl type) {
  
        this.LINE_SIZE = LINE_SIZE;
        this.type = type;
      }
    

    @Override
    public String toString() {
       switch (this) {
            case HEAD:
                return "Nadpis";                
            case DATE:
                return "Datum";                
            case TIME:
                return "Čas";                
            case HEAD_LINK:
               return "více odkaz";
            case TOWN:
                return "Město/Vesnice";
            case PLACE:
                return "Místo";
            case TEXT:
                return "Popis";                
            case TEXT_LINK:
                return "více";
            case LINK1_TEXT:
               return "Popis odkazu 1";
            case LINK2_TEXT:
                return "Popis odkazu 2";
            case LINK3_TEXT:
                return "Popis odkazu 3";
            case LINK1:
                return "Odkaz 1";
            case LINK2:
                return "Odkaz 2";
            case LINK3:
                return "Odkaz 3";
            case NAME:
                return "Jméno osoby";
            case MEDIUM:
                return "Médium";
            case TYPE:
                return "Typ události";
            default:
                throw new AssertionError(this.name());
        }
    }
    
    
    /**
     * metoda vrátí jméno pro řazení
     * @return
     */
    public String toStringSort() {        
     switch (this) {               
            case DATE:
                return "Datumu";
                        
          
            case TOWN:
                return "Místa";
      
            case NAME:
                return "Jména";
            case MEDIUM:
                return "Média";
            case TYPE:
                return "Typ události";
            default:
                throw new AssertionError(this.name());
        }
        
    }
     
     
    
    
    /**
     * metoda vrátí zda se to má přidat k možností řazení
     * @return
     */
    public boolean sort(){
        switch (this) {
            //case PRINTED:   
            case DATE:           
            case TOWN:
            case NAME:
            case MEDIUM:
            case TYPE:
                return true;               
            default:
                return false;
            }
    }
    
    
    public int dataSize() {
        int MaxVarChar = 32700;
        switch (this) {            
            case HEAD:
                return 1000;
            case DATE:
                return 10;
            case TIME:
                return 8;
            case HEAD_LINK:
                return 2000;
            case TOWN:
                return 35;
            case PLACE:
               return 100;
            case TEXT:
                return 4000;
            case TEXT_LINK:
                return 2000;
            case LINK1_TEXT:
                return 30;
            case LINK2_TEXT:
                return 30;
            case LINK3_TEXT:
               return 30;
            case LINK1:
                return 2000;
            case LINK2:
                return 2000;
            case LINK3:
                return 2000;
            case NAME:
                return 30;
            case MEDIUM:
                return 30;
            case TYPE:
                return 30;
            default:
                throw new AssertionError(this.name());
            
        }
    }
    
    public int numberLine(){
        switch (this) {         
                case DATE:
                    return 1;
                    
                case TIME:
                    return 1;
                    
                case HEAD:
                    return  1;
                    
                case HEAD_LINK:
                    return 1;
                   
                case TOWN:
                    return  1;
                   
                case PLACE:
                    return  3;
                     
                case TEXT:
                    return 10;
                    
                case LINK1_TEXT:
                    return 1;
                    
                case LINK2_TEXT:
                    return 1;
                   
                case LINK3_TEXT:
                    return 1;
                   
                case LINK1:
                    return 1;
                    
                case LINK2:
                    return 1;
                    
                case LINK3:
                    return 1;
                    
                    
                case NAME:
                    return  1;
                    
                case MEDIUM:
                    return  1;
                    
               case TEXT_LINK:
                    return  1;
                   
                case TYPE:
                    return 1;
                default:
                    return 0;
            }
        
    }
       
}
