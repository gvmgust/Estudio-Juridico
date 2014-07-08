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
public class Documento {
    private Persona ci;
    private TipoDocumento tipoDocumento;
    private int copia;
    private String ubicacion;
    private String ubicacionFisica;

    public Documento(Persona ci, TipoDocumento tipoDocumento, int copia, String ubicacion, String ubicacionFisica) {
        this.ci = ci;
        this.tipoDocumento = tipoDocumento;
        this.copia = copia;
        this.ubicacion = ubicacion;
        this.ubicacionFisica = ubicacionFisica;
    }
    
    public Persona getCi() {
        return ci;
    }

    public void setCi(Persona ci) {
        this.ci = ci;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getCopia() {
        return copia;
    }

    public void setCopia(int copia) {
        this.copia = copia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(String ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }
    
    
}
