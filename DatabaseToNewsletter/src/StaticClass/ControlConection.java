/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticClass;

import java.io.IOException;
import java.net.InetAddress;


/**
 * třída která zkouší připojení na internet v pravidelných intervalech
 * @author Jan Holý
 */
public class ControlConection implements Runnable{
Thread thread;
    /**
     * @param conected statická proměná je pravdivá podařilo se metodě připojit na internet
     */
    private static boolean conected = false;
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

    /**
     * metoda vrátí true jestliže je nalezeno připojení k internetu jinak vrací false
     * @return
     */
    public synchronized static boolean isConected() {
        return conected;
    }

    /**
     * nastavení hodnoty true proměnné {@link #ControlConection.conected}jestliže je nalezno připojení k internetu janak vrací hodnotu false
     * @param conected
     */
    public synchronized static void setConected(boolean conected) {
        ControlConection.conected = conected;
    }
    
    
    
    
    private synchronized  boolean getInetAderes() {
           
           boolean bb;
           try {
               inetAddress = InetAddress.getLocalHost();
               bb = inetAddress.isReachable(2000);
               setConected(bb);
               return bb;
           } catch (IOException ex) {
               setConected(false);
               return false;
           }
       }
    
}
