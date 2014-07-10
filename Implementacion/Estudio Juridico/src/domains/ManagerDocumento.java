/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domains;

import data.Documento;
import pack.Main;
import utils.SQL;

/**
 *
 * @author Gustavo Vargas M
 */
public class ManagerDocumento {
    public static boolean insertarDocumento(Documento d){
        if(SQL.pregunta("Desea insertar el documento de "+d.getTipoDocumento().getNombre()+" para la persona: \n"+d.getCi().nombrePersona())){
            Main.con.ejecutar(SQL.registrarDocumento(d.getCi().getCi(), d.getTipoDocumento().getId_tip(), d.getUbicacion(), d.getUbicacionFisica()));
        }
        return false;
    }
}
