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
public class Titulo {
    private int id_tit;
    private String titulo;
    private String abrev;

    public Titulo(String titulo, String abrev) {
        this.titulo = titulo;
        this.abrev = abrev;
    } 

    public Titulo(int id_tit, String titulo, String abrev) {
        this.id_tit = id_tit;
        this.titulo = titulo;
        this.abrev = abrev;
    }
    
    
    public int getId_tit() {
        return id_tit;
    }

    public void setId_tit(int id_tit) {
        this.id_tit = id_tit;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }
}
