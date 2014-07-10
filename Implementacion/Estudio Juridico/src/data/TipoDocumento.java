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
public class TipoDocumento {

    private int id_tip;
    private String nombre;

    public TipoDocumento(int id_tip, String nombre) {
        this.id_tip = id_tip;
        this.nombre = nombre;
    }

    public TipoDocumento(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
