/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Vargas M
 */
public class Telefono {

    private String ci;
    private ArrayList<String> telf;

    public Telefono(String ci) {
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public ArrayList<String> getTelf() {
        return telf;
    }

    public void setTelf(ArrayList<String> telf) {
        this.telf = telf;
    }

    public void addTelf(String telf) {
        this.telf.add(telf);
    }
}
