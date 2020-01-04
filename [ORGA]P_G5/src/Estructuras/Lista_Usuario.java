/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author Aragon Perez
 */
public class Lista_Usuario {

    public Lista_Usuario() {
         Hitorial=new ArrayList<>();
    }
    public ArrayList<Historial_Punteo> Hitorial;
    String Nodo_Usu;
    String Nodo_Pass;
    public String getUsuario(){
        return Nodo_Usu;
    }
    public String getPass(){
        return Nodo_Pass;
    }
    public void setUsuario(String Usu){
        this.Nodo_Usu=Usu;
    }
    public void setPass(String Pass){
        this.Nodo_Pass=Pass;
    }
    public String[] ObtenerTiempos(){
        String Time[]= new String[100];
        //recorremos la lista de tiempos
        for (int x = 0; x <Hitorial.size() ; x++) {
            //sin son iguales obtenemos su nodo
            Historial_Punteo aux=Hitorial.get(x);
            Time[x]=String.valueOf(aux.getTiempos());
        }
        return Time;
    }
    public String[] ObtenerPuntos(){
        String Puntos[]= new String[100];
        //recorremos la lista de tiempos
        for (int x = 0; x <Hitorial.size() ; x++) {
            //sin son iguales obtenemos su nodo
            Historial_Punteo aux=Hitorial.get(x);
            Puntos[x]=String.valueOf(aux.getPuntos());
        }
        return Puntos;
    }
}
//clase Historial
class Historial_Punteo{

    public Historial_Punteo() {
    }
    int Puntos;
    int Tiempos;
    public int getPuntos(){
        return Puntos;
    }
    public int  getTiempos(){
        return Tiempos;
    }
    public void setPuntos(int Puntos){
        this.Puntos=Puntos;
    }
    public void setTiempos(int Tiempos){
        this.Tiempos=Tiempos;
    }
    
}
