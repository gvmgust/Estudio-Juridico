/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author [GVM - MABH - LCOS]
 */
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

    public static final SimpleDateFormat formatoDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ////////////////////////////REGISTRO DE DATOS/////////////////////////////
    public static String registrarPersona(String ci, String nombre, String app, String apm, String dir, int tipo) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_parterno`,`apellido_materno`,`direccion`,`id_tit`) VALUES ('"
                + ci + "','"
                + nombre.toUpperCase() + "','"
                + app.toUpperCase() + "','"
                + apm.toUpperCase() + "','"
                + dir.toUpperCase() + "','"
                + tipo + "');";
    }

    public static String registrarPersona(String ci, String nombre, String app, String apm, String dir) {
        return "INSERT INTO `persona`(`ci`,`nombre`,`apellido_parterno`,`apellido_materno`,`direccion`) VALUES ('"
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
                + titulo + "','"
                + abrev + "'); ";
    }

    public static String backup(String sql) {
        return "INSERT INTO `backup`(`sql`)VALUES(\"" + sql + "\");";
    }

    //////////////////////////CONSULTA DE DATOS////////////////////////////////
    public static String iniciarSecion(String user, String pass) {
        return "SELECT id_user FROM `usuario` WHERE `user`='" + user + "' AND `pass`='" + sha1(pass) + "'";
    }

    ///////////////////////// VISTAS DE DATOS//////////////////////////////////
    public static String mostrarDatosUsuario(int id) {
        return "SELECT `titulo`.`titulo`,`persona`.*, `usuario`.`tipo`"
                + "FROM `usuario` INNER JOIN `persona` INNER JOIN `titulo` "
                + "ON `persona`.`ci` = `usuario`.`ci` AND `persona`.`id_titulo` = `titulo`.`id_titulo`"
                + "WHERE `id_user`='" + id + "';";
    }
}
