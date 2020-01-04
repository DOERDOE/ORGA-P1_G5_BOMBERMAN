/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnpout32.*;
/**
 *
 * @author david
 */
public class Controlador implements KeyListener{
    Matriz m;
    Jugador j;
    Bloque[][] bloques;
    Point aux;
    //private ioPort puertoParalelo = new ioPort();
   // static pPort lpt;
     short datum = 0;
Thread x2;
    public Controlador(Matriz m){
        this.m=m;
        this.j=m.j;
        this.bloques=m.bloques;
        this.aux = new Point(0,0);
        //hilo controlador
        
    }
    @Override
    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //87 = W = Arriba
        if(ke.getKeyCode()==87){
            if(j.getPOS().y-1<0){
                return;
            }
            aux.x=j.getPOS().x;
            aux.y=j.getPOS().y-1;
            if(!m.alteracion(aux)){
                //aqui tengo que ver con qu esta topando
                return;
            }
                m.m[j.getPOS().x][j.getPOS().y]="O";            
                j.getPOS().y=j.getPOS().y-1;
                m.m[j.getPOS().x][j.getPOS().y]="J";
            
        }
        //83 = S = Abajo
        if(ke.getKeyCode()==83){
            if(j.getPOS().y+1>11){
                return;
            }
            aux.x=j.getPOS().x;
            aux.y=j.getPOS().y+1;
            if(!m.alteracion(aux)){
                //aqui tengo que ver con qu esta topando
                return;
            }
                m.m[j.getPOS().x][j.getPOS().y]="O";
                j.getPOS().y=j.getPOS().y+1;
                m.m[j.getPOS().x][j.getPOS().y]="J";
            
        }
        //65 = A = Izquierda
        if(ke.getKeyCode()==65){
            if(j.getPOS().x-1<0){
                return;
            }
            aux.x=j.getPOS().x-1;
            aux.y=j.getPOS().y;
            if(!m.alteracion(aux)){
                //aqui tengo que ver con qu esta topando
                return;
            }
                m.m[j.getPOS().x][j.getPOS().y]="O";
                j.getPOS().x=j.getPOS().x-1;
                m.m[j.getPOS().x][j.getPOS().y]="J";
            
        }
        //68 = D = Derecha
        if(ke.getKeyCode()==68){
            if(j.getPOS().x+1>11){
                return;
            }
            aux.x=j.getPOS().x+1;
            aux.y=j.getPOS().y;
            if(!m.alteracion(aux)){
                //aqui tengo que ver con qu esta topando
                return;
            }
            m.m[j.getPOS().x][j.getPOS().y]="O";
            j.getPOS().x=j.getPOS().x+1;                
            m.m[j.getPOS().x][j.getPOS().y]="J";
            m.alteracion(j.getPOS());
            
        }
        //66 = B = Bomba
        if(ke.getKeyCode()==66){
            int x = j.getPOS().x;
            int y = j.getPOS().y;
            if(j.getBombasEspeciales()>0){
                j.setBombasEspeciales(j.getBombasEspeciales()-1);
            }
            if(m.b==null){
                m.b=new Bomba(m,new Point(x,y),j.getBombasEspeciales()>0);
                //m.actualizar();
                m.hiloBomba = new Thread(m.b);
                m.hiloBomba.start();                
            }else{
                if(!m.b.isCargando()){
                    m.b=new Bomba(m,new Point(x,y),j.getBombasEspeciales()>0);
                    //m.actualizar();
                    m.hiloBomba = new Thread(m.b);
                    m.hiloBomba.start();                
                }                
            }
        }
        m.t.actualizarDatos(m);

        //m.actualizar();
        //actualizar matriz
    }
    
}
