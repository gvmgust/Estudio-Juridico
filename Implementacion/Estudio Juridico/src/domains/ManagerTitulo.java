/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import data.Titulo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import pack.Main;
import utils.ManagerArchivo;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerTitulo {

    private Titulo titulo;

    public void cargarTitulo(int id_tit) {
        // cargar de la db
    }

    public void cargarTitulo(String titulo, String abrev) {
        // cargar los datos desde interface
    }

    public static Titulo buscarTitulo(int id_tit) {
        Titulo titulo = null;
        ResultSet rs = Main.con.consultar(SQL.buscarTitulo(id_tit));
        try {
            while (rs.next()) {
                titulo = new Titulo(rs.getInt("id_tit"), rs.getString("titulo"), rs.getString("abreviatura"));
            }
        } catch (Exception ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR al buscar Titulo: " + ex.getMessage());
        }
        return titulo;
    }

    public static Titulo buscarTitulo(String abrev) {
        Titulo titulo = null;
        ResultSet rs = Main.con.consultar(SQL.buscarTitulo(abrev));
        try {
            while (rs.next()) {
                titulo = new Titulo(rs.getInt("id_tit"), rs.getString("titulo"), rs.getString("abreviatura"));
            }
        } catch (Exception ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR al buscar Titulo: " + ex.getMessage());
        }
        return titulo;
    }

    public static ArrayList<Titulo> listarTitulo() {
        ArrayList<Titulo> titulos = new ArrayList();
        ResultSet rs = Main.con.consultar(SQL.listarTitulos());
        try {
            while (rs.next()) {
                titulos.add(new Titulo(rs.getInt("id_tit"), rs.getString("titulo"), rs.getString("abreviatura")));
            }
        } catch (Exception ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR al buscar Titulo: " + ex.getMessage());
        }
        return titulos;
    }

    public static boolean registrarTitulo(Titulo t) {
        if (SQL.pregunta("Desea agregar \"+" + t.getTitulo() + "\" con abreviatura \"" + t.getAbrev() + "\"")) {
            if (Main.con.ejecutar(SQL.registrarTitulo(t.getTitulo(), t.getAbrev()))) {
                return true;
            }
        }
        return false;
    }

}
