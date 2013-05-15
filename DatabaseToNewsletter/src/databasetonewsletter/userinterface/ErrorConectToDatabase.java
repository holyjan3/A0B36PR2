/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import databasetonewsletter.WorkDatabaseOffline;
import databasetonewsletter.WorkerDatabase;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jan Holý
 */
public class ErrorConectToDatabase {

    public boolean ErrorConectToDatabase() {
        String ss;

            ss = "Zavřít";

        
        JOptionPane  frame = new JOptionPane();
           Object[] options = {ss,
                    "Spojit",};
            int n = JOptionPane.showOptionDialog(frame,
                 "Nezdařilo se spojení s  databází",
                    "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
             null,
            options,
            options[1]);
            if (n==1){
           
            try {
            WorkerDatabase.conectOnlineDatabase();
                return true;
            
            } catch (    SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {           
               return false;        
                
            }
           } else {
             return false;
          }
       }
   }   
