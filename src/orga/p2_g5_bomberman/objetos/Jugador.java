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
public class Jugador extends Elemento{
    private String nombre;
    private int vidas;
    private int punteo;
    private int bombasEspeciales;
    
    public Jugador(){
        super(new Point(1,1),"J");        
    };
    public Jugador(String nombre, int vidas, int punteo,int bombasEspeciales){
        super(new Point(1,1),"J");
        this.nombre=nombre;
        this.vidas=vidas;
        this.punteo=punteo;
        this.bombasEspeciales=bombasEspeciales;
    }
    public Jugador(String nombre, int vidas, int punteo,int bombasEspeciales, Point p){
        super(p,"J");
        this.nombre=nombre;
        this.vidas=vidas;
        this.punteo=punteo;
        this.bombasEspeciales=bombasEspeciales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public int getBombasEspeciales() {
        return bombasEspeciales;
    }

    public void setBombasEspeciales(int bombasEspeciales) {
        this.bombasEspeciales = bombasEspeciales;
    }
    
}
