/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import data.Arancel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pack.Main;
import utils.ManagerArchivo;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerArancel {

    private Arancel arancel;

    public static void insertarArancel(Arancel arancel) {
        if (SQL.pregunta("Desea registrar el Arancel " + arancel.getNombre() + " con un costo de: " + arancel.getCosto())) {
            Main.con.ejecutar(SQL.registrarArancel(arancel.getNombre(), arancel.getCosto(), arancel.getFlag()));
        }
    }

    public static boolean actualizarArancel(Arancel arancel) {
        if (SQL.pregunta("Desea Actualizar los datos del arancel " + arancel.getNombre())) {
            return Main.con.ejecutar(SQL.actualizarArancel(arancel.getAra(), arancel.getNombre(), arancel.getCosto(), arancel.getFlag()));
        } else {
            return false;
        }
    }

    public static boolean eliminarArancel(Arancel arancel) {
        if (SQL.pregunta("Desea Eliminar el arancel " + arancel.getNombre())) {
            return Main.con.ejecutar(SQL.eliminarArancel(arancel.getAra()));
        } else {
            return false;
        }
    }

    public static ArrayList<Arancel> listarArancel(String nombre) {
        ArrayList<Arancel> lista = new ArrayList<Arancel>();
        ResultSet rs = Main.con.consultar(SQL.listarArancel(nombre));
        try {
            while (rs.next()) {
                lista.add(new Arancel(rs.getInt("id_ara"), rs.getString("nombre"), rs.getFloat("costo"), rs.getInt("flag")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerArancel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static ArrayList<Arancel> listarArancel(int flag) {
        ArrayList<Arancel> lista = new ArrayList<Arancel>();
        ResultSet rs = Main.con.consultar(SQL.listarArancel(flag));
        try {
            while (rs.next()) {
                lista.add(new Arancel(rs.getInt("id_ara"), rs.getString("nombre"), rs.getFloat("costo"), rs.getInt("flag")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerArancel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public static String[] parseVector(Arancel a) {
        String[] r = {a.getNombre() + "", a.getCosto() + ""};
        return r;
    }

    public Arancel getArancel() {
        return arancel;
    }

    public void setArancel(Arancel arancel) {
        this.arancel = arancel;
    }
}
