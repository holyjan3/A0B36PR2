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
    private int number;
    protected int count;
    protected Database database;

    public PrintedElement(Database database) {
             this.database = database;
             number = database.database.number;
             int c = 0;
             for (int i = 0; i < database.Data.size(); i++) {
                 if(database.Data.get(i).printed){
                    c++; 
                 }
             }
             count = c;
      
    }
    

    @Override
    public int compareTo(PrintedElement o) {
        return this.number - o.number;
    }

   
      
    
}
