/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import static databasetonewsletter.ControlElement.conected;
import static databasetonewsletter.ControlElement.contolVarChar;
import java.awt.Color;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JLabel;


/**
 *
 * @author Majitel
 */
public class ControlWebSide implements Runnable{
    String URLString ;
    String ss2;
    JLabel jLabel;
    

    public ControlWebSide(String ss2, JLabel jLabel,String URLString) {
        this.URLString = URLString;
        this.ss2 = ss2;
        this.jLabel = jLabel;
    }

   

   
    @Override
    public void run() {
        boolean bb = false;
          try {
      HttpURLConnection.setFollowRedirects(false);      
      HttpURLConnection con =
         (HttpURLConnection) new URL(URLString).openConnection();
      con.setRequestMethod("HEAD");
      bb =(con.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch (Exception e) {
       
      }
      if(bb){
          jLabel.setBackground(Color.green);
          jLabel.setForeground(Color.black);
          jLabel.setText("adresa ověřena");
          jLabel.setVisible(true);
      }else {
          jLabel.setBackground(Color.red);
          jLabel.setForeground(Color.white);
          jLabel.setText(ss2);
          jLabel.setVisible(true);
      }    
          
          
          
    }

  
}
    
