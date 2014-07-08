/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domains;

import data.Telefono;
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
public class ManagerTelefono {

    private static Telefono telefono;
    
    public static Telefono buscarTelefono(String ci) {
        telefono = new Telefono(ci);
        ResultSet rs = Main.con.consultar(SQL.buscarTelefono(ci));
        try {
            while (rs.next()) {
                telefono.addTelf(rs.getString("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
        return telefono;
    }
    
    public static boolean registrarTelefono(Telefono t){
        if (SQL.pregunta("Desea agregar el telefono:\"+" + t.getTelf().get(0) + " a la lista de telefonos\"")) {
            if (Main.con.ejecutar(SQL.registrarTelefono(t.getCi(), t.getTelf().get(0)))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean eliminarTelefono(Telefono t,int index){
        if (SQL.pregunta("Desea eliminar el telefono:\"+" + t.getTelf().get(index) + " a la lista de telefonos\"")) {
            if (Main.con.ejecutar(SQL.eliminarTelefono(telefono.getCi(), telefono.getTelf().get(index)))) {
                return true;
            }
        }
        return false;
    }
}
