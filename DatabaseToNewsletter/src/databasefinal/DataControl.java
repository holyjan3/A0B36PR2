
package databasefinal;


/**
 * enum pro odlišení různých typů vstupních/výstupní položek, s položkamy různého typu se různě zachází , enum je vložen v enumu DateElement
 * @author Jan Holý
 */
public enum DataControl {    

    /**
     * vstupní data je datum
     */
    DATE,
    /**
     * vstupní data je čas
     */
    TIME,
    /**
     * vstupní data je skupina znaků
     */
    VARCHAR,
    /**
     * vstupní data je skupina znaků ovšem je to webová adresa a program ověřuje  i existenci
     */
    URL;
    //TEXT("TEXT");

    
}
