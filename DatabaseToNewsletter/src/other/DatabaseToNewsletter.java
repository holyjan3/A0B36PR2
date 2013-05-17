/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import databasework.GlobalDate;
import databasework.DataDatabase;
import databasework.SaveData;
import databasework.ConectDatabasesDerby;
import databasework.ConectDatabasesDerby;
import databasework.ControlElementDerby;
import databasework.GlobalSave;
import databasework.SaveDataToFile;
import databasework.WorkerDatabase;
import databasework.WorkerDatabase;
import userinterface.JFrameConect;



/**
 * spuštěná třída
 * @author Jan Holýl
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
           new WorkerDatabase(new ControlElementDerby(), new ConectDatabasesDerby(), new GlobalDate());
           new GlobalSave(new SaveDataToFile());
           WorkerDatabase.dateControl.setDate(WorkerDatabase.dateControl.getDefolteDate());
           JFrameConect.main(null);
            
        
         
    }
}
