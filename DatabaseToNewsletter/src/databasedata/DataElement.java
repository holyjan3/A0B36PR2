/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedata;



/**
 * Typy položek v záznamech
 * @author Jan Holý
 */
public enum DataElement{
    /**
     * Nadpis
     */
    HEAD        (700,DataControl.VARCHAR,Constants.MaxVarChar),
    /**
     * Datum
     */
    DATE        (100,DataControl.DATE, 10),
    /**
     * Čas
     */
    TIME        (0,DataControl.TIME,  8),   
    /**
     * Odkaz nadpisu
     */
    HEAD_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    /**
     * Město/Vesnice
     */
    TOWN        (200,DataControl.VARCHAR,35),
    /**
     * Místo
     */
    PLACE       (0,DataControl.VARCHAR,100),
    /**
     * Popis
     */
    TEXT        (800,DataControl.VARCHAR,Constants.MaxVarChar),
    /**
     * Popis Odkaz
     */
    TEXT_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    /**
     * Popis odkazu 1
     */
    LINK1_TEXT  (0,DataControl.VARCHAR,30),
    /**
     * Popis odkazu 2
     */
    LINK2_TEXT  (0,DataControl.VARCHAR, 30),
    /**
     * Popis odkazu 3
     */
    LINK3_TEXT  (0,DataControl.VARCHAR, 30),
    /**
     * Odkaz 1
     */
    LINK1       (0,DataControl.URL, Constants.MaxVarChar),
    /**
     * Odkaz 2
     */
    LINK2       (0,DataControl.URL, Constants.MaxVarChar),
    /**
     * Odkaz 3
     */
    LINK3       (0,DataControl.URL, Constants.MaxVarChar),
    /**
     * Jméno osoby
     */
    NAME        (200,DataControl.VARCHAR, 30),
    /**
     * Médium
     */
    MEDIUM      (200,DataControl.VARCHAR, 30),
    /**
     * Typ události
     */
    TYPE        (200,DataControl.VARCHAR, 30);    
    


    
    /**
     * určuje velikost buňky ve které se zobrazuje
     */
    final public int LINE_SIZE;
    
    /**
     * typ kontroly dané položky union DataControl
     */
    final public DataControl type;
    
    /**
     * maximální počet znaků položky
     */
    final public int date_size;
    
  
    private DataElement(int LINE_SIZE, DataControl type,int date_size) {
  
        this.LINE_SIZE = LINE_SIZE;
        this.type = type;
        this.date_size = date_size;
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
               return "Odkaz nadpisu";
            case TOWN:
                return "Město/Vesnice";
            case PLACE:
                return "Místo";
            case TEXT:
                return "Popis";                
            case TEXT_LINK:
                return "Popis Odkaz";
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
    
    
    
    
   
    private static class  Constants {
        
        static int MaxVarChar = 32700;
        
        
    }
    
}
