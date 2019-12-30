/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

import java.awt.Point;

/**
 *
 * @author david
 */
public class Enemigo extends Elemento implements Runnable{
    //true horizontal
    //false vertical
    private boolean desplazamientoH;
    private int desplazamiento = 1;
    private Matriz m;
    private int numeroDeEnemigo;
    public Enemigo(Matriz m,Point p,boolean desplazamientoH,int numeroEnemigo){
        super(p,"M");
        this.m=m;
        this.numeroDeEnemigo=numeroEnemigo;
        this.desplazamientoH=desplazamientoH;
    }

    public boolean isDesplazamientoH() {
        return desplazamientoH;
    }

    public void setDesplazamientoH(boolean desplazamientoH) {
        this.desplazamientoH = desplazamientoH;
    }
    
    @Override
    public void run(){
        Point aux = new Point();
        aux.setLocation(this.getPOS());
        try{
            while(true){
                Thread.sleep(2000);
                m.m[aux.x][aux.y]="O";
                if(this.desplazamientoH){
                    aux.x=aux.x+desplazamiento;                    
                    if(verificarAfeccion(aux)){
                        aux.x=aux.x+desplazamiento;
                        
                    };
                }else{
                    aux.y=aux.y+desplazamiento;                    
                    if(verificarAfeccion(aux)){
                        aux.y=aux.y+desplazamiento;
                    };
                }
                m.m[aux.x][aux.y]="M";                
                super.setPOS(aux);
                if(this.numeroDeEnemigo==1){
                    m.actualizar();                    
                }
                
            }
        }catch(Exception e){
            
        }
        
    }
    public boolean verificarAfeccion(Point p){
        if(!m.m[p.x][p.y].equals("O")){
            if(p.x<0 || p.y<0 || p.x>11|| p.y>11 || m.m[p.x][p.y].equals("M") || m.m[p.x][p.y].equals("H") || m.m[p.x][p.y].equals("B") || m.m[p.x][p.y].equals("b") ){
                desplazamiento=desplazamiento*-1;
                return true;
            }else if(m.m[p.x][p.y].equals("J")){
                m.j.setPOS(new Point(1,1));
                m.m[1][1]="J";
                m.j.setVidas(m.j.getVidas()-1);
                m.m[p.x][p.y]="O";
            }
        }
        return false;
    }

    public int getNumeroDeEnemigo() {
        return numeroDeEnemigo;
    }

    public void setNumeroDeEnemigo(int numeroDeEnemigo) {
        this.numeroDeEnemigo = numeroDeEnemigo;
    }
}
