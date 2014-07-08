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
public class Caso {

    private int id_cas;
    private TipoCaso tipoCaso;
    private Persona persona;
    private String descripcion;
    private Date inicio;
    private Date fin;
    private int pagado;

    public Caso(int id_cas, TipoCaso tipoCaso, Persona persona, String descripcion, Date inicio, Date fin, int pagado) {
        this.id_cas = id_cas;
        this.tipoCaso = tipoCaso;
        this.persona = persona;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.pagado = pagado;
    }

    public int getId_cas() {
        return id_cas;
    }

    public void setId_cas(int id_cas) {
        this.id_cas = id_cas;
    }

    public TipoCaso getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(TipoCaso tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getPagado() {
        return pagado;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

}
