
package databasetonewsletter;


/**
 * enum pro kontrolu vstupních dat pro kontrolu shodnosti typu položek s typem buněk datází a jiné kontroly
 * @author Majitel
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
