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
public class Plantilla {
    private int id_pla;
    private String nombre;
    private String directorio;

    public Plantilla(int id_pla, String nombre, String directorio) {
        this.id_pla = id_pla;
        this.nombre = nombre;
        this.directorio = directorio;
    }

    public int getId_pla() {
        return id_pla;
    }

    public void setId_pla(int id_pla) {
        this.id_pla = id_pla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }    
}
