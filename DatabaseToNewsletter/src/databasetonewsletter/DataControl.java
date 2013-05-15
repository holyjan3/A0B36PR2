
package databasetonewsletter;


/**
 * enum pro odlišení různých typů vstupních/výstupní položek, s položkamy různého typu se různě zachází , enum je vložen v enumu DateElement
 * @author Jan Holý
 */
public enum DataControl {    

    /**
     * vstupní data je datum
     */
    DATE("DATE"),
    /**
     * vstupní data je čas
     */
    TIME("TIME"),
    /**
     * vstupní data je skupina znaků
     */
    VARCHAR("VARCHAR"),
    /**
     * vstupní data je skupina znaků ovšem je to webová adresa a program ověřuje  i existenci
     */
    URL("VARCHAR");
    //TEXT("TEXT");
    
    final public String databaseType;

    private DataControl(String databaseType) {
        this.databaseType = databaseType;
    }
    
}
