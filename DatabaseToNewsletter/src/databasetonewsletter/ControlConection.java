/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Majitel
 */
public class ControlConection implements Runnable{
Thread thread;

    public ControlConection(Thread thread) {
        this.thread = thread;
    }

    
    @Override
    public void run() {
        while(true){
        ControlElement.getInetAderes();
            try {
                thread.sleep(100);
            } catch (InterruptedException ex) {
                thread.start();
            }
       } 
    }
    
}
