
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public enum DataControl {
    DATE("DATE"),
    TIME("TIME"),
    VARCHAR("VARCHAR"),
    URL("VARCHAR"),
    TEXT("TEXT"),
    BOOL("BOOL");
    
    final String mysqlType;

    private DataControl(String mysqlType) {
        this.mysqlType = mysqlType;
    }
    
}
