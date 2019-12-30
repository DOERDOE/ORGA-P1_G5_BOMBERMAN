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
public class Bloque extends Elemento{
    private boolean ocultaBonus;
    private boolean ocultaLlave;
    public Bloque(Point p){
        super(p,"H");
        this.ocultaBonus=false;
        this.ocultaLlave=true;
    }

    public boolean isOcultaBonus() {
        return ocultaBonus;
    }

    public void setOcultaBonus(boolean ocultaBonus) {
        this.ocultaBonus = ocultaBonus;
    }

    public boolean isOcultaLlave() {
        return ocultaLlave;
    }

    public void setOcultaLlave(boolean ocultaLlave) {
        this.ocultaLlave = ocultaLlave;
    }
    
}
