/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public class PrintedElement implements Comparable<PrintedElement>{
    StringBuilder code;
    String[] path;
    boolean overwrite;

    public PrintedElement(StringBuilder code, String[] path, boolean overwrite) {
        this.code = code;
        this.path = path;
        this.overwrite = overwrite;        
      
    }

    @Override
    public int compareTo(PrintedElement o) {
        
        for (int i = 0; i < this.path.length; i++) {
            if(i<o.path.length) {
                if(o.path[i].equals(this.path[i])){                    
                }else {
                   return this.path[i].compareTo(o.path[i]);
                }
            } else {
                return -1;
            }
        }
        return 1;
    }
    
}
