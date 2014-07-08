/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Gustavo Vargas M
 */
public class Usuario {
    // tipos de usuario
    public static final int SECRETARIA = 0;
    public static final int ABOGADO = 1;
    public static final int ADMINISTRADOR = 2;
    // valores usados para estados de usuarios
    public static final int ACTIVADO = 1;
    public static final int DESACTIVADO = 0;
    // atributos de la clase
    private int id_usu;
    private String user;
    private String pass;
    private int activo;
    private Persona persona;
    private int tipo;

    public Usuario(int id_usu, String user, String pass, int activo, Persona persona, int tipo) {
        this.id_usu = id_usu;
        this.user = user;
        this.pass = pass;
        this.activo = activo;
        this.persona = persona;
        this.tipo = tipo;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
