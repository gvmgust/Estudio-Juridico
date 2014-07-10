/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domains;

import data.TipoDocumento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import pack.Main;
import utils.ManagerArchivo;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerTipoDocumento {

    public static ArrayList<TipoDocumento> listar() {
        ArrayList<TipoDocumento> r = new ArrayList();
        ResultSet rs = Main.con.consultar(SQL.listarTipoDocumento());
        try {
            while (rs.next()) {
                r.add(new TipoDocumento(rs.getInt("id_tip"), rs.getString("tipo")));
            }
        } catch (SQLException ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR al realizar busqueda de tipo de documento: " + ex.getMessage());
        }
        return r;
    }
    
    public static TipoDocumento getDocumento(String nombreTipo) {
        ResultSet rs = Main.con.consultar(SQL.buscarTipoDocumento(nombreTipo));
        try {
            while (rs.next()) {
                return new TipoDocumento(rs.getInt("id_tip"), rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR al buscar documento " + nombreTipo + " :" + ex.getMessage());
        }
        return null;
    }
    
    public static boolean registrarTipoDocumento(TipoDocumento td){
        if(SQL.pregunta("Desea Registrar "+td.getNombre()+" como nuevo tipo de Documento")){
            return Main.con.ejecutar(SQL.registrarTipoDocumento(td.getNombre().toUpperCase()));
        }
        return false;
    }
    
    public static boolean actualizarTipoDocumento(TipoDocumento td){        
        if(SQL.pregunta("Desea Actualizar el Tipo de Documento: "+td.getNombre())){
            return Main.con.ejecutar(SQL.actualizarTipoDocumento(td.getId_tip(), td.getNombre().toUpperCase()));
        }
        return false;
    }
}
