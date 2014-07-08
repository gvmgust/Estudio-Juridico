/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import data.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pack.Main;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerPersona {

    private Persona persona;

    ManagerPersona(String ci) {
        ResultSet rs = Main.con.consultar(SQL.buscarPersona(ci));
        try {
            while (rs.next()) {
                persona = new Persona(rs.getString("ci"), rs.getString("nombre"), rs.getString("apellido_paterno"), rs.getString("apellido_materno"), rs.getString("direccion"), null, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Persona buscarPersona(String ci) {
        Persona persona = null;
        int id_tit = 0;
        ResultSet rs = Main.con.consultar(SQL.buscarPersona(ci));
        try {
            while (rs.next()) {
                id_tit = rs.getInt("id_tit");
                persona = new Persona(rs.getString("ci"), rs.getString("nombre"), rs.getString("apellido_paterno"), rs.getString("apellido_materno"), rs.getString("direccion"), null, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (persona != null) {
            persona.setTelf(ManagerTelefono.buscarTelefono(ci));
            persona.setTitulo(ManagerTitulo.buscarTitulo(id_tit));
        }
        return persona;
    }

    public static void insertarPersona(Persona p) {
        if (SQL.pregunta("Desea registrar a \"" + p.getTitulo().getAbrev() + " " + p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno() + "\" En la Base de Datos")) {
            Main.con.ejecutar(SQL.registrarPersona(p.getCi(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), p.getDireccion(), p.getTitulo().getId_tit()));
        }
    }

    public static void actualizarPersona(Persona p) {
        if (SQL.pregunta("Desea actualizar los datos de \"" + p.getTitulo().getAbrev() + " " + p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno() + "\" En la Base de Datos")) {
            Main.con.ejecutar(SQL.actualizarPersona(p.getCi(), p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno(), p.getDireccion(), p.getTitulo().getId_tit()));
        }
    }

    ManagerPersona(Persona p) {
        this.persona = p;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
