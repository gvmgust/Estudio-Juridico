/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Gustavo Vargas M
 */
public class Cita {

    private int id_cit;
    private Persona persona;
    private Caso caso;
    private Date fechaHora;
    private float costo;
    private float pagado;
    private int activa;

    public Cita(int id_cit, Persona persona, Caso caso, Date fechaHora, float costo, float pagado, int activa) {
        this.id_cit = id_cit;
        this.persona = persona;
        this.caso = caso;
        this.fechaHora = fechaHora;
        this.costo = costo;
        this.pagado = pagado;
        this.activa = activa;
    }

    public int getId_cit() {
        return id_cit;
    }

    public void setId_cit(int id_cit) {
        this.id_cit = id_cit;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPagado() {
        return pagado;
    }

    public void setPagado(float pagado) {
        this.pagado = pagado;
    }

    public int getActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

}
