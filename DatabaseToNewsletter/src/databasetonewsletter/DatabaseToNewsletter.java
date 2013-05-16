/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import StaticClass.ControlConection;
import StaticClass.GlobalSave;
import StaticClass.WorkerDatabase;
import userinterface.JFrameConect;



/**
 * spuštěná třída
 * @author Majitel
 */
public class DatabaseToNewsletter {

    
    /**
     * spouští vlákno které se zajímá o to zda je aplikace připojena k internetu a spuštění prvního okna přhlášení se do aplikace
     * @param args nic nedělají
     */
    public static void main(String[] args)  {  
        

           Thread th= null;
           th= new Thread(new ControlConection(th));
           th.start();
           new WorkerDatabase();
           new GlobalSave();
           WorkerDatabase.dateControl.setDate(WorkerDatabase.dateControl.getDefolteDate());
           JFrameConect.main(null);
            
        
         
    }
}
