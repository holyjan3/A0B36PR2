/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;


import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
        
        
       // WorkerDatabase.conectOnlineDatabase(null, null);
//        WorkerDatabase.WorkerDatabase();  
//        
////        while(true){
////            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////            Calendar cal = Calendar.getInstance();
////            System.out.println(dateFormat.format(cal.getTime()));
////        }
//        
//         try {
//            
//            
//            

//           
//          new JFrameMainMenu();
//           // new JFrameMenuAll();
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(null, ex.toString(), "", JOptionPane.ERROR_MESSAGE);
//            
//        }
    }
}
