/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Refresher implements Runnable{
    Matriz m;
    public Refresher(Matriz m){
        this.m=m;
    }
    @Override
    public void run() {
        while(true){
            try {
                m.actualizar();
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Refresher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
