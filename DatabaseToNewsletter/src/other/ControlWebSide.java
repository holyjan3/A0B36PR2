/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other;


import java.awt.Color;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JLabel;



/**
 * vlákno kontrolujíci existenci webové adresy
 * @author Jan Holý
 */
public class ControlWebSide implements Runnable{
    private String URLString ;
    private String ss2;
    private JLabel jLabel;
    

    
    /**
     *  konrola adresy 
     * @param jLabel label který mění barvu podle výsledků testu červená = neuspěla adresa/ zelená  = uspěla adresa
     * @param URLString webová adresa
     */
    public ControlWebSide(JLabel jLabel,String URLString) {
        this.URLString = URLString;
        this.ss2 = "chyba ve vstupnim retezci";
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
    
