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
    Enemigo[] enemigos;
    Jugador j;
    Bomba b;
    Fuego[][] explosion;
    TableroCaracteres t;  
    int nivel;
    Thread hiloBomba;

    Thread hiloEnemigo1;
    Thread hiloEnemigo2;
    Thread hiloEnemigo3;
    Thread hiloEnemigo4;
    Thread hiloEnemigo5;
    Thread hiloEnemigo6;
    Thread hiloEnemigo7;
    Thread hiloEnemigo8;

    public Matriz(){
        nivel = 1;
        this.m = new String[12][12];
        this.bloques = new Bloque[12][12];
        this.enemigos = new Enemigo[8];
        this.j = new Jugador("Pompilio",3,0,0);
        llenadoAutomaticoDeO();
        configuracionBloquesNivel1();
        Controlador c = new Controlador(this);
        t = new TableroCaracteres(this,c);
        configuaracionEnemigosNivel1();
        Refresher r = new Refresher(this);
        Thread hiloRefresher = new Thread(r);
        hiloRefresher.start();
        
    }
    
    public void actualizar(Jugador j){
        m[j.getPOS().x][j.getPOS().y] = j.getLetra();        
    //    t.actualizar(this);
    };
    //para las bombas
    public void actualizar(){        
        m[j.getPOS().x][j.getPOS().y] = j.getLetra();        
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
        if(bloques[p.x][p.y]!=null){
            if(bloques[p.x][p.y].isOcultaBonus()){
                m[p.x][p.y]="Z";
            }else if(bloques[p.x][p.y].isOcultaLlave()){
                m[p.x][p.y]="L";
            }else{
                m[p.x][p.y]=VACIO;                
            }
            bloques[p.x][p.y]=null;
            j.setPunteo(j.getPunteo()+10);
            return;
        }
        if(j.getPOS().x==p.x && j.getPOS().y==p.y){
            j.setPOS(new Point(1,1));
            m[1][1]="J";
            this.j.setVidas(j.getVidas()-1);
            m[p.x][p.y]=VACIO;
        }       
        //verificamos si lo que destruimos es un enemigo
        for(int i=0;i<8;i++){
            if(enemigos[i]==null){
                continue;
            }
            if(enemigos[i].getPOS().x==p.x && enemigos[i].getPOS().y==p.y){
                if(i==0){
                    hiloEnemigo1.stop();
                }else if(i==1){
                    hiloEnemigo2.stop();                    
                }else if(i==2){
                    hiloEnemigo3.stop();                    
                }else if(i==3){
                    hiloEnemigo4.stop();                    
                }else if(i==4){
                    hiloEnemigo5.stop();                    
                }else if(i==5){
                    hiloEnemigo6.stop();                    
                }else if(i==6){
                    hiloEnemigo7.stop();                    
                }else if(i==7){
                    hiloEnemigo8.stop();                    
                }
                m[p.x][p.y]="O";
            }
        }
        if(m[p.x][p.y]==null){
            return;
        }
       // this.actualizar(j);
    }
    //true es dejar pasar, false no dejar pasar
    public boolean alteracion(Point p){
        if(m[p.x][p.y]=="Z"){
            j.setBombasEspeciales(j.getBombasEspeciales()+3);
           // this.actualizar(j);
            return true;
        }else if(m[p.x][p.y]=="L"){
            m[j.getPOS().x][j.getPOS().y]="O";
            nivel++;            
            j.setPOS(new Point(1,1));
            m[1][1]="J";
            cambioDeNivel();
            //this.actualizar(j);
            return false;
        }else if(m[p.x][p.y]=="M"){
            m[j.getPOS().x][j.getPOS().y]=VACIO;
            j.setPOS(new Point(1,1));
            m[1][1]="J";
            this.j.setVidas(j.getVidas()-1);
            return false;
        }else if(m[p.x][p.y]=="O"){
            return true;
        }else{
            return false;
        }
    }
    public void cambioDeNivel(){
        if(nivel==2){
            this.hiloBomba.stop();
            this.hiloEnemigo1.stop();
            this.hiloEnemigo2.stop();
            configuracionBloquesNivel2();
            this.configuaracionEnemigosNivel2();
        }else if(nivel==3){
            this.hiloBomba.stop();
            this.hiloEnemigo1.stop();
            this.hiloEnemigo2.stop();
            this.hiloEnemigo3.stop();
            this.hiloEnemigo4.stop();
            configuracionBloquesNivel3();
            this.configuaracionEnemigosNivel3();
        }else{
            this.hiloBomba.stop();
            this.hiloEnemigo1.stop();
            this.hiloEnemigo2.stop();
            this.hiloEnemigo3.stop();
            this.hiloEnemigo4.stop();
            this.hiloEnemigo5.stop();
            this.hiloEnemigo6.stop();
            this.hiloEnemigo7.stop();
            this.hiloEnemigo8.stop();
            m[5][5]="Felicidades~!, SOS LA MERA VERGA!";
        }
       // this.actualizar(j);
    };
    public void frenarHilos(){
        
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
        bloques[4][4].setOcultaBonus(true);
        bloques[4][5]=new Bloque(new Point(4,5));
        bloques[5][4]=new Bloque(new Point(5,4));
        bloques[5][5]=new Bloque(new Point(5,5));   
        bloques[5][5].setOcultaLlave(true);
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                if(bloques[x][y]!=null)
                m[x][y]=bloques[x][y].getLetra();
            }            
        }        
    }
    public void configuaracionEnemigosNivel1(){
        enemigos[0]=new Enemigo(this,new Point(7,7),true,1);
        enemigos[1]=new Enemigo(this,new Point(5,2),false,2);
        m[7][7]=enemigos[0].getLetra();
        m[5][2]=enemigos[1].getLetra();
        //this.actualizar();
        hiloEnemigo1 = new Thread(this.enemigos[0]);
        hiloEnemigo2 = new Thread(this.enemigos[1]);
        hiloEnemigo1.start();
        hiloEnemigo2.start();
    }
    
    public void configuracionBloquesNivel2(){
        //bloques
        //fila x,y->
        for(int i=0;i<12;i++){
            bloques[0][i]=new Bloque(new Point(0,i));
            bloques[11][i]=new Bloque(new Point(11,i));
            bloques[i][0]=new Bloque(new Point(i,0));
            bloques[i][11]=new Bloque(new Point(i,11));          
        }
        bloques[4][4]=new Bloque(new Point(4,4));
        bloques[4][4].setOcultaBonus(true);
        bloques[4][5]=new Bloque(new Point(4,5));
        bloques[5][4]=new Bloque(new Point(5,4));
        bloques[5][5]=new Bloque(new Point(5,5));   
        bloques[5][5].setOcultaLlave(true);
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                if(bloques[x][y]!=null)
                m[x][y]=bloques[x][y].getLetra();
            }            
        }        
    }
    public void configuaracionEnemigosNivel2(){
        enemigos[0]=new Enemigo(this,new Point(7,7),true,1);
        enemigos[1]=new Enemigo(this,new Point(5,2),false,2);
        enemigos[2]=new Enemigo(this,new Point(7,9),true,3);
        enemigos[3]=new Enemigo(this,new Point(10,10),false,4);
        m[7][7]=enemigos[0].getLetra();
        m[5][2]=enemigos[1].getLetra();
        m[7][9]=enemigos[2].getLetra();
        m[10][10]=enemigos[3].getLetra();
        //this.actualizar();
        hiloEnemigo1 = new Thread(this.enemigos[0]);
        hiloEnemigo2 = new Thread(this.enemigos[1]);
        hiloEnemigo3 = new Thread(this.enemigos[2]);
        hiloEnemigo4 = new Thread(this.enemigos[3]);
        hiloEnemigo1.start();
        hiloEnemigo2.start();
        hiloEnemigo3.start();
        hiloEnemigo4.start();
    }
    
    public void configuracionBloquesNivel3(){
        //bloques
        //fila x,y->
        for(int i=0;i<12;i++){
            bloques[0][i]=new Bloque(new Point(0,i));
            bloques[11][i]=new Bloque(new Point(11,i));
            bloques[i][0]=new Bloque(new Point(i,0));
            bloques[i][11]=new Bloque(new Point(i,11));          
        }
        bloques[4][4]=new Bloque(new Point(4,4));
        bloques[4][4].setOcultaBonus(true);
        bloques[4][5]=new Bloque(new Point(4,5));
        bloques[5][4]=new Bloque(new Point(5,4));
        bloques[5][5]=new Bloque(new Point(5,5));   
        bloques[5][5].setOcultaLlave(true);
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                if(bloques[x][y]!=null)
                m[x][y]=bloques[x][y].getLetra();
            }            
        }        
    }
    public void configuaracionEnemigosNivel3(){
        enemigos[0]=new Enemigo(this,new Point(7,7),true,1);
        enemigos[1]=new Enemigo(this,new Point(5,2),false,2);
        enemigos[2]=new Enemigo(this,new Point(7,9),true,3);
        enemigos[3]=new Enemigo(this,new Point(10,10),false,4);
        enemigos[4]=new Enemigo(this,new Point(7,7),true,5);
        enemigos[5]=new Enemigo(this,new Point(4,4),false,6);
        enemigos[6]=new Enemigo(this,new Point(6,4),true,7);
        enemigos[7]=new Enemigo(this,new Point(11,10),false,8);
        m[7][7]=enemigos[0].getLetra();
        m[5][2]=enemigos[1].getLetra();
        m[7][9]=enemigos[2].getLetra();
        m[10][10]=enemigos[3].getLetra();
        m[7][7]=enemigos[4].getLetra();
        m[4][4]=enemigos[5].getLetra();
        m[6][4]=enemigos[6].getLetra();
        m[11][10]=enemigos[7].getLetra();
        //this.actualizar();
        hiloEnemigo1 = new Thread(this.enemigos[0]);
        hiloEnemigo2 = new Thread(this.enemigos[1]);
        hiloEnemigo3 = new Thread(this.enemigos[2]);
        hiloEnemigo4 = new Thread(this.enemigos[3]);
        hiloEnemigo5 = new Thread(this.enemigos[4]);
        hiloEnemigo6 = new Thread(this.enemigos[5]);
        hiloEnemigo7 = new Thread(this.enemigos[6]);
        hiloEnemigo8 = new Thread(this.enemigos[7]);
        hiloEnemigo1.start();
        hiloEnemigo2.start();
        hiloEnemigo3.start();
        hiloEnemigo4.start();
        hiloEnemigo5.start();
        hiloEnemigo6.start();
        hiloEnemigo7.start();
        hiloEnemigo8.start();
    }
}
