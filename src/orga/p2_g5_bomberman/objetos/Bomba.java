/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Bomba extends Elemento implements Runnable {
    Matriz m;
    boolean especial;
    private boolean cargando;
    public Bomba(Matriz m,Point p,boolean especial){
        super(p,"B");
        this.cargando=true;
        this.m=m;
        this.especial=especial;
//        detonar();
    }
    
    @Override
    public void run() {
      detonarNormal();      
//      m.verificarEfectos(this.getPOS(),"B",especial);
        //son las 4 a 8 areas de explosion que debemos alterar
      m.destruir(this.getPOS());
      Point p = new Point();
      p.setLocation(this.getPOS());
      p.x = p.x+1;
      m.destruir(p);
      p.x = p.x-2;
      m.destruir(p);
      p.x = p.x+1;
      p.y = p.y+1;
      m.destruir(p);
      p.y = p.y-2;
      m.destruir(p);
      //restaurado en su punto original
      p.setLocation(this.getPOS());
      if(especial){
        p.x=p.x+2;
        m.destruir(p);
        p.x=p.x-4;
        m.destruir(p);
        p.x=p.x+2;
        p.y=p.y+2;
        m.destruir(p);
        p.y=p.y-4;
        m.destruir(p);
        p.x=p.y+2;
          
      }
      this.cargando=false;
    }
    public void detonarNormal(){
          try {
            for (int contar=0; contar<10; contar++){
                try {
                    Thread.sleep(400);
                    if(contar%2==0){
                        m.m[this.getPOS().x][this.getPOS().y]="B";
                    }else{                    
                        m.m[this.getPOS().x][this.getPOS().y]="b";
                    }
                    m.actualizar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(especial){
                if(this.getPOS().y!=0){
                    m.m[this.getPOS().x][this.getPOS().y-2]="F";
                }
                if(this.getPOS().y!=11){
                    m.m[this.getPOS().x][this.getPOS().y+2]="F";
                }
                if(this.getPOS().x!=0){
                    m.m[this.getPOS().x-2][this.getPOS().y]="F";
                }
                if(this.getPOS().x!=11){
                    m.m[this.getPOS().x+2][this.getPOS().y]="F";
                }                
            }
            if(this.getPOS().y!=0){
                m.m[this.getPOS().x][this.getPOS().y-1]="F";
            }
            if(this.getPOS().y!=11){
                m.m[this.getPOS().x][this.getPOS().y+1]="F";
            }
            if(this.getPOS().x!=0){
                m.m[this.getPOS().x-1][this.getPOS().y]="F";
            }
            if(this.getPOS().x!=11){
                m.m[this.getPOS().x+1][this.getPOS().y]="F";
            }
            m.m[this.getPOS().x][this.getPOS().y]="F";
            m.actualizar();
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(this.getPOS().y!=0){
                m.m[this.getPOS().x][this.getPOS().y-1]="O";
            }
            if(this.getPOS().y!=11){
                m.m[this.getPOS().x][this.getPOS().y+1]="O";
            }
            if(this.getPOS().x!=0){
                m.m[this.getPOS().x-1][this.getPOS().y]="O";
            }
            if(this.getPOS().x!=11){
                m.m[this.getPOS().x+1][this.getPOS().y]="O";
            }
            if(especial){
                if(this.getPOS().y!=0){
                    m.m[this.getPOS().x][this.getPOS().y-2]="O";
                }
                if(this.getPOS().y!=11){
                    m.m[this.getPOS().x][this.getPOS().y+2]="O";
                }
                if(this.getPOS().x!=0){
                    m.m[this.getPOS().x-2][this.getPOS().y]="O";
                }
                if(this.getPOS().x!=11){
                    m.m[this.getPOS().x+2][this.getPOS().y]="O";
                }                
            }
            m.m[this.getPOS().x][this.getPOS().y]="O";
        
        //verificar efectos
    }

    public boolean isCargando() {
        return cargando;
    }

    public void setCargando(boolean cargando) {
        this.cargando = cargando;
    }
    
}
