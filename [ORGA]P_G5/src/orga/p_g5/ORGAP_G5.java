/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p_g5;


import java.util.ArrayList;
import Estructuras.Lista_Usuario;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Aragon Perez
 */
//Clase Nodo Usuarios

public class ORGAP_G5 {
    
    public static void main(String[] args) {
        //Lista de Usuarios Pendientes
        String [][]Usu_P=new String[15][2];
        //Lista de Usuarios
        ArrayList<Lista_Usuario> Usuarios = new ArrayList<>();
        F_Login F_login =new F_Login();
        F_login.show();
        F_login.setLocationRelativeTo(null);
        F_login.Usu_P=Usu_P;
        F_login.Usuarios=Usuarios;
    }
    
    
}
