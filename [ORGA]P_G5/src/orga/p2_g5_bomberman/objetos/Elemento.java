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
public class Elemento {
    private Point POS;
    private String letra;
    int posicionGeneral;
    Animacion animacion;
    
    public Elemento(){};
    public Elemento(Point pos, String letra){
        this.POS=pos;
        this.letra=letra;
    }

    public Point getPOS() {
        return POS;
    }

    public void setPOS(Point POS) {
        this.POS = POS;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
