/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;


/**
 *
 * @author Majitel
 */
public enum DataElement{
    
    HEAD        (700,DataControl.VARCHAR,Constants.MaxVarChar),
    DATE        (100,DataControl.DATE, 10),
    TIME        (0,DataControl.TIME,  8),   
    HEAD_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    TOWN        (200,DataControl.VARCHAR,35),
    PLACE       (0,DataControl.VARCHAR,100),
    TEXT        (800,DataControl.VARCHAR,Constants.MaxVarChar),
    TEXT_LINK   (0,DataControl.URL,Constants.MaxVarChar),
    LINK1_TEXT  (0,DataControl.VARCHAR,30),
    LINK2_TEXT  (0,DataControl.VARCHAR, 30),
    LINK3_TEXT  (0,DataControl.VARCHAR, 30),
    LINK1       (0,DataControl.URL, Constants.MaxVarChar),
    LINK2       (0,DataControl.URL, Constants.MaxVarChar),
    LINK3       (0,DataControl.URL, Constants.MaxVarChar),
    NAME        (200,DataControl.VARCHAR, 30),
    MEDIUM      (200,DataControl.VARCHAR, 30),
    TYPE        (200,DataControl.VARCHAR, 30);    
    


    final int LINE_SIZE;
    final int date_size;
    DataControl type;
    
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
                return "Popis Odkazu";
            case LINK1_TEXT:
               return "Popis odkazu 1";
            case LINK2_TEXT:
                return "Popis odkazu 2";
            case LINK3_TEXT:
                return "Popis odkazu 3";
            case LINK1:
                return "odkaz 1";
            case LINK2:
                return "odkaz 2";
            case LINK3:
                return "odkaz 3";
            case NAME:
                return "Jméno";
            case MEDIUM:
                return "Médium";
            case TYPE:
                return "Typ události";
            default:
                throw new AssertionError(this.name());
        }
    }
    
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
    
    public boolean controlLinks(){
        switch (this) {
            case LINK1:
            case LINK2:
            case LINK3:
            case HEAD_LINK: 
                return true;
            default:
                return false;
        }
    }
    static class  Constants {
        static int MaxVarChar = 32700;
        
        
    }
    
}
