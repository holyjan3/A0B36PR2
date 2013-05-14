/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.io.IOException;
import java.net.InetAddress;


/**
 * metoda která skoučí připojení na internet v pravidelných intervalech
 * @author Majitel
 */
public class ControlConection implements Runnable{
Thread thread;
    /**
     * @param conected statická proměná je pravdivá podařilo se metodě připojit na internet
     */
    public  static boolean conected = false;
    private InetAddress inetAddress;
          
   
    
    /**
     * Aplikace si předává svoje vlastní vlákno
     * @param thread
     */
    public ControlConection(Thread thread) {
        this.thread = thread;
        
    }  
    
    @Override
    public void run() {
        while(true){
        getInetAderes();
            try {
                thread.sleep(2000);
            } catch (InterruptedException ex) {
                //thread.start();
            }
       } 
    }
    
    private synchronized  boolean getInetAderes() {
           
           boolean bb;
           try {
               inetAddress = InetAddress.getLocalHost();
               bb = inetAddress.isReachable(2000);
               conected = bb;
               return bb;
           } catch (IOException ex) {
               conected = false;
               return false;
           }
       }
    
}
