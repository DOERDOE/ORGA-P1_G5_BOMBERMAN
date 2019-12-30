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
public class Matriz {
    final String VACIO = "O";
    String[][] m;
    Bloque[][] bloques;
    Jugador j;
    Bomba b;
    Fuego[][] explosion;
    TableroCaracteres t;        
    public Matriz(){
        this.m = new String[12][12];
        this.bloques = new Bloque[12][12];
  //      this.explosion = new Explosion[]
        this.j = new Jugador("Pompilio",3,0,0);
        llenadoAutomaticoDeO();
        configuracionBloquesNivel1();
        Controlador c = new Controlador(this);
        t = new TableroCaracteres(this,c);
        this.actualizar(j);
    }
    
    public void actualizar(Jugador j){
        m[j.getPOS().x][j.getPOS().y] = j.getLetra();        
        t.actualizar(this);
    };
    //para las bombas
    public void actualizar(){        
        t.actualizar(this);  
        
    }
    public void llenadoAutomaticoDeO(){
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                m[x][y]=VACIO;
            }            
        }
    }
    public void destruir(Point p){
        if(p.x<0 || p.x>11||p.y>11||p.y<0){           
            return;
        }
        if(m[p.x][p.y]==null){
            return;
        }
        if(bloques[p.x][p.y]!=null){
            bloques[p.x][p.y]=null;            
            m[p.x][p.y]=VACIO;
            j.setPunteo(j.getPunteo()+10);
            return;
        }
        if(j.getPOS().x==p.x && j.getPOS().y==p.y){
            j.setPOS(new Point(1,1));
            this.j.setVidas(j.getVidas()-1);
        }        
        this.actualizar(j);
    }
    public void configuracionBloquesNivel1(){
        //bloques
        //fila x,y->
        for(int i=0;i<12;i++){
            bloques[0][i]=new Bloque(new Point(0,i));
            bloques[11][i]=new Bloque(new Point(11,i));
            bloques[i][0]=new Bloque(new Point(i,0));
            bloques[i][11]=new Bloque(new Point(i,11));          
        }
        bloques[4][4]=new Bloque(new Point(4,4));
        bloques[4][5]=new Bloque(new Point(4,5));
        bloques[5][4]=new Bloque(new Point(5,4));
        bloques[5][5]=new Bloque(new Point(5,5));        
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                if(bloques[x][y]!=null)
                m[x][y]=bloques[x][y].getLetra();
            }            
        }        
    }

}
