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
public class DocumentoEmitido {
    private Persona persona;
    private Plantilla plantilla;
    private int vez;
    private float costo;
    private float pagado;

    public DocumentoEmitido(Persona persona, Plantilla plantilla, int vez, float costo, float pagado) {
        this.persona = persona;
        this.plantilla = plantilla;
        this.vez = vez;
        this.costo = costo;
        this.pagado = pagado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
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
}
