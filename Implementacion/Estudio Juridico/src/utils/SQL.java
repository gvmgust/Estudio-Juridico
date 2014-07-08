/*
 * ESTE PROYECTO ES DESARROLLADO POR GUSTAVO VARGAS MIRANDA- MARCO AURELIO BARBA HENSLER
 * Y LUIS CARLO OSINAGA SORIA, PARA LA MATERIA DE SISTEMAS DE INFORMACION 2
 * DE LA UNIVERSIDAD AUTONOMA GABRIEL RENE MORENO EN LA FACULTAD INTEGRAL DEL CHACO
 * LOS DERECHOS INTELECTUALES DE ESTE SISTEMAS PERTENECEN A DICHA UNIVERSIDAD
 * Y ES DESARROLLADO CON FINES ACADEMICOS, POR LO QUE LA VENTA Y O COPIA PARCIAL O TOTAL
 * SOLO DEBERIA REALIZARSE PARA LOS MISMOS FINES
 */
/**
 *
 * @author [GVM - MABH - LCOS]
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class SQL {

/////////////////////HERRAMIENTAS USADAS PARA LAS CONSULTAS/////////////////////
    public static String sha1(String string) {
        String hash = "";
        try {
            MessageDigest md;
            byte[] buffer, digest;
            buffer = string.getBytes();
            md = MessageDigest.getInstance("SHA1");
            md.update(buffer);
            digest = md.digest();
            for (byte aux : digest) {
                int b = aux & 0xff;
                if (Integer.toHexString(b).length() == 1) {
                    hash += "0";
                }
                hash += Integer.toHexString(b);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    public static final SimpleDateFormat formatoDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat formatDates = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean pregunta(String pregunta) {
        int seleccion = JOptionPane.showOptionDialog(
                null, pregunta,
                "Seleccione una opción", // Título
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                "Si");
        if (seleccion != -1) {
            if ((seleccion + 1) == 1) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////REGISTRO DE DATOS/////////////////////////////
    public static String registrarPersona(String ci, String nombre, String app, String apm, String dir, int id_tit) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_paterno`,`apellido_materno`,`direccion`,`id_tit`) VALUES ('"
                + ci + "','"
                + nombre.toUpperCase() + "','"
                + app.toUpperCase() + "','"
                + apm.toUpperCase() + "','"
                + dir.toUpperCase() + "','"
                + id_tit + "');";
    }

    public static String registrarPersona(String ci, String nombre, String app, String apm, String dir) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_paterno`,`apellido_materno`,`direccion`) VALUES ('"
                + ci + "','"
                + nombre.toUpperCase() + "','"
                + app.toUpperCase() + "','"
                + apm.toUpperCase() + "','"
                + dir.toUpperCase() + "');";
    }

    public static String registrarUsuario(String usuario, String pass, int estado, String ci) {
        return "INSERT INTO `usuario`(`id_usu`,`user`,`pass`,`activo`,`ci`) VALUES ( NULL,'"
                + usuario.toUpperCase() + "','"
                + sha1(pass) + "','"
                + estado + "','"
                + ci + "'); ";
    }

    public static String registrarTelefono(String ci, String telf) {
        return "INSERT INTO `telefono`(`ci`,`numero`) VALUES ( '"
                + ci + "','"
                + telf + "'); ";
    }

    public static String registrarTitulo(String titulo, String abrev) {
        return "INSERT INTO `titulo`(`titulo`,`abreviatura`) VALUES ( '"
                + titulo.toUpperCase() + "','"
                + abrev.toUpperCase() + "'); ";
    }

    public static String backup(String sql) {
        return "INSERT INTO `backup`(`sql`)VALUES(\"" + sql + "\");";
    }

    public static String registrarCargo(String nombre) {
        return "INSERT INTO `cargo` (`nombre`)VALUES('" + nombre + "');";
    }

    public static String registrarOcupa(int id_car, String ci, Date inic_gest, Date fin_gest, String observacion) {
        return "INSERT INTO `ocupa` (id_car,ci,inic_gest,fin_gest,observacion)VALUES('"
                + id_car + "','"
                + ci + "','"
                + inic_gest + "','"
                + fin_gest + "','"
                + observacion + "');";
    }

    public static String registrarArancel(String nombre, float costo, int flag) {
        return "INSERT INTO arancel(nombre,costo,flag)VALUES('"
                + nombre + "','"
                + costo + "','"
                + flag + "');";
    }

    //////////////////////////ACTUALIZACION DE DATOS///////////////////////////
    public static String actualizarArancel(int id_ara, String nombre, float costo, int flag) {
        return "UPDATE arancel SET `nombre`='"
                + nombre + "',`costo`='"
                + costo + "',`flag`='"
                + flag + "' "
                + "WHERE id_ara='"
                + id_ara + "';";
    }

    //////////////////////////CONSULTA DE DATOS////////////////////////////////
    public static String iniciarSecion(String user, String pass) {
        return "SELECT id_usu FROM `usuario` WHERE `user`='" + user + "' AND `pass`='" + sha1(pass) + "'";
    }

    public static String buscarTitulo(int id_tit) {
        return "SELECT * FROM titulo WHERE id_tit = '" + id_tit + "';";
    }

    public static String buscarTitulo(String abrev) {
        return "SELECT * FROM titulo WHERE abreviatura = '" + abrev + "';";
    }

    public static String buscarArancel(int id_ara) {
        return "SELECT * FROM arancel WHERE id_ara = '" + id_ara + "'";
    }

    public static String buscarPersona(String ci) {
        return "select * from `persona` where `ci` = '" + ci + "';";
    }

    public static String buscarTelefono(String ci) {
        return "SELECT * FROM `telefono` WHERE `ci`='" + ci + "'";
    }

    ///////////////////////// VISTAS DE DATOS//////////////////////////////////
    public static String mostrarDatosUsuario(int id) {
        return "SELECT `titulo`.`abreviatura`,`persona`.*, `usuario`.`tipo`"
                + "FROM `usuario` INNER JOIN `persona` INNER JOIN `titulo` "
                + "ON `persona`.`ci` = `usuario`.`ci` AND `persona`.`id_tit` = `titulo`.`id_tit`"
                + "WHERE `id_usu`='" + id + "';";
    }

    public static String listarArancel(String nombre) {
        return "SELECT * FROM `arancel` WHERE `nombre` LIKE'%" + nombre + "%';";
    }

    public static String listarArancel(int flag) {
        return "SELECT * FROM `arancel` WHERE `flag` = '" + flag + "';";
    }

    public static String buscarAutoridad(String nombre, String apellido) {
        return "SELECT persona.*,cargo.*,ocupa.*\n"
                + "from persona inner join ocupa inner join cargo\n"
                + "on persona.`ci` = ocupa.`ci` and ocupa.`id_car` = cargo.`id_car`\n"
                + "where concat(persona.`nombre`,' ',persona.`apellido_paterno`,' ',persona.`apellido_materno`) like '%" + nombre + "%" + apellido + "%';";
    }

    public static String listarTitulos() {
        return "SELECT * FROM `titulo`;";
    }

    //////////////////////////////////Delete////////////////////////////////
    public static String eliminarTelefono(String ci, String numero) {
        return "DELETE FROM `estudio_juridico`.`telefono` WHERE `ci`='" + ci + "' AND `numero`='" + numero + "'; ";
    }
}
