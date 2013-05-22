/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import createemail.CreateEmail;
import databasework.GlobalDate;
import databasework.DataDatabase;
import createemail.SaveData;
import databasework.ConectDatabasesDerby;
import databasework.ConectDatabasesDerby;
import databasework.ControlElementDerby;
import createemail.SaveDataToFile;
import database.Element;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static Thread th= null;
    public static void main(String[] args)  {     
            
            th= new Thread(new ControlConection(th));
            th.start();
            new WorkerDatabase(new ControlElementDerby(), new ConectDatabasesDerby(), new GlobalDate());//singleton
            new GlobalSave(new SaveDataToFile(),new CreateEmail());
            WorkerDatabase.dateControl.setDate(WorkerDatabase.dateControl.getDefolteDate());
            JFrameConect.main(null);
            
//            File f = new File("Newsletters");
//       try {
//             WorkerDatabase.conectDatabeses.setUrl(f.getAbsolutePath());
//             WorkerDatabase.conectDatabeses.setName("root");
//             WorkerDatabase.conectDatabeses.setPassword("root");
//             
//             WorkerDatabase.conectDatabeses.conectOnlineDatabase();
//             WorkerDatabase.conectDatabeses.conectWorkerDatabases();
//             for (int i = 0; i < 10000; i++) {
//                 
//                   Element el = new Element( WorkerDatabase.conectDatabeses.getDataDatabases().get(3).DE);
//                   el.setString_of_element(Test.ss, 0);
//                   el.setString_of_element(Test.ss + Test.ss, 2);
//                   WorkerDatabase.conectDatabeses.getDataDatabases().get(3).nowWorkDatabase.addElementt(el);
//             }
//             
//             WorkerDatabase.conectDatabeses.conectionClose();
////         int t = 1;
//        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
//            Logger.getLogger(DatabaseToNewsletter.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
        
         
    }
}
