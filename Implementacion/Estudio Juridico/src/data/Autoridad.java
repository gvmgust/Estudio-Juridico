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
public class Autoridad {

    private Cargo cargo;
    private Persona persona;
    private int repite;
    private Date ini_gest;
    private Date fin_gest;
    private String observacion;

    public Autoridad(Cargo cargo, Persona persona, int repite, Date ini_gest, Date fin_gest, String observacion) {
        this.cargo = cargo;
        this.persona = persona;
        this.repite = repite;
        this.ini_gest = ini_gest;
        this.fin_gest = fin_gest;
        this.observacion = observacion;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getRepite() {
        return repite;
    }

    public void setRepite(int repite) {
        this.repite = repite;
    }

    public Date getIni_gest() {
        return ini_gest;
    }

    public void setIni_gest(Date ini_gest) {
        this.ini_gest = ini_gest;
    }

    public Date getFin_gest() {
        return fin_gest;
    }

    public void setFin_gest(Date fin_gest) {
        this.fin_gest = fin_gest;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
