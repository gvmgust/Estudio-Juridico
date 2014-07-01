package pack;

import gui.Login;
import utils.Conexion;
import utils.ManagerArchivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author [GVM - MABH - LCOS]
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    public static String db;
    public static String host;
    public static String user;
    public static String password;
    public static ManagerArchivo managerArchivo = new ManagerArchivo();
    public static Conexion con = new Conexion(user,password,host,db);
}
