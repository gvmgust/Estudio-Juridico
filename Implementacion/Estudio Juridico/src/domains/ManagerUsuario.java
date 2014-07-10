/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domains;

import data.Usuario;
import pack.Main;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerUsuario {
    public static boolean registrarUsuario(Usuario u){
        if(SQL.pregunta("Desea registrar el usuario "+u.getUser()+" para la persona\n"+u.getPersona())){
            return Main.con.ejecutar(SQL.registrarUsuario(u.getUser(), u.getPass(), u.getPersona().getCi(),u.getActivo(),u.getTipo()));
        }
        return false;
    }

    public static boolean actualizarUsuario(Usuario u){
        if(u.getPass().equals("")){
            return Main.con.ejecutar(SQL.actualizarUsuario(u.getUser(),u.getActivo(),u.getPersona().getCi(),u.getTipo(),u.getId_usu()));
        }else{
            return Main.con.ejecutar(SQL.actualizarUsuario(u.getUser(),u.getPass(),u.getActivo(),u.getPersona().getCi(),u.getTipo(),u.getId_usu()));
        }
    
    }
}
