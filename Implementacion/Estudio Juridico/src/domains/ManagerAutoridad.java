/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domains;

import data.Autoridad;
import data.Cargo;
import data.Persona;
import java.sql.ResultSet;
import java.util.Date;
import pack.Main;
import utils.ManagerArchivo;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerAutoridad {
    private Autoridad autoridad;
    
    public ManagerAutoridad(String nombre,String apellido){
        ResultSet rs = Main.con.consultar(SQL.buscarAutoridad(nombre,apellido));
        try {
            while (rs.next()) {
                autoridad = new Autoridad(new Cargo(rs.getInt("id_car"),rs.getString("ci")),new Persona(rs.getString("ci"),rs.getString("nombre"),rs.getString("apellido_paterno"),rs.getString("apellido_materno"),rs.getString("direccion"),null,null),rs.getInt("rep"),rs.getDate("inic_gest"),rs.getDate("fin_gest"),rs.getString("observacion"));
            }
        } catch (Exception ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] Error al buscar Arancel: " + ex.getMessage());
        }
    }
    public ManagerAutoridad(Autoridad autoridad){
        
    }
}
