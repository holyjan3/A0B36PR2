/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import databasetonewsletter.userinterface.JFrameConect;



public class DatabaseToNewsletter {

    
    public static void main(String[] args)  {  
        
           // spouští vlákno které se zajímá o to zda je aplikace připojena k internetu
           Thread th= null;
           th= new Thread(new ControlConection(th));
           th.start();
           
           // spuštění prvního okna přhlášení se do aplikace
           WorkerDatabase.date =WorkerDatabase.setDate();
           JFrameConect.main(null);
            
        
         
    }
}
