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
public class Arancel {

    public static final int CITA = 0;
    public static final int DOCUMENTO = 1;
    public static final int CASO = 2;
    private int ara;
    private String nombre;
    private float costo;
    private int flag;

    public Arancel(int ara, String nombre, float costo, int flag) {
        this.ara = ara;
        this.nombre = nombre;
        this.costo = costo;
        this.flag = flag;
    }

    public Arancel() {
        //constructor vacio
    }

    public int getAra() {
        return ara;
    }

    public void setAra(int ara) {
        this.ara = ara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
