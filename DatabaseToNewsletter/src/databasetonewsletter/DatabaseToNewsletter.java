/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;


/**
 *
 * @author Majitel
 */
public class DatabaseToNewsletter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {  
           Thread th= null;
           th= new Thread(new ControlConection(th));
           th.start();        
           JFrameConect.main(null);
            
        
         
    }
}
