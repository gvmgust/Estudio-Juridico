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
    
    public ManagerArancel(int id_ara) {
        ResultSet rs = Main.con.consultar(SQL.buscarArancel(id_ara));
        try {
            while (rs.next()) {
                arancel = new Arancel(id_ara, rs.getString("nombre"), rs.getFloat("costo"), rs.getInt("flag"));
            }
        } catch (Exception ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] Error al buscar Arancel: " + ex.getMessage());
        }
    }
    
    public ManagerArancel(Arancel arancel) {
        this.arancel = arancel;
    }
    
    public static void insertarArancel(Arancel arancel) {
        Main.con.ejecutar(SQL.registrarArancel(arancel.getNombre(), arancel.getCosto(), arancel.getFlag()));
    }
    
    public static void actualizarArancel(Arancel arancel) {
        Main.con.ejecutar(SQL.actualizarArancel(arancel.getAra(), arancel.getNombre(), arancel.getCosto(), arancel.getFlag()));
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
    
    public Arancel getArancel() {
        return arancel;
    }
    
    public void setArancel(Arancel arancel) {
        this.arancel = arancel;
    }    
}
