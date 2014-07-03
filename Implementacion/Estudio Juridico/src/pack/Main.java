package pack;

import com.birosoft.liquid.LiquidLookAndFeel;
import gui.GuiAbogado;
import gui.GuiAdmin;
import gui.GuiSecretaria;
import gui.Login;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import utils.Conexion;
import utils.Data;
import utils.ManagerArchivo;
import utils.SQL;

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
        style();
        login = new Login();
    }
    
    public static void style() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void iniciarSecion(int id_user){
        ResultSet rs = con.consultar(SQL.mostrarDatosUsuario(id_user));
        String titulo = "";
        String ci = "";
        String nombre = "";
        String apellidoP = "";
        String apellidoM = "";
        int tipo = 0;
        try{
            while (rs.next()){
                titulo = rs.getString("titulo");
                ci = rs.getString("ci");
                nombre = rs.getString("nombre");
                apellidoP = rs.getString("apellido_paterno");
                apellidoM = rs.getString("apellido_materno");   
                tipo = rs.getInt("tipo");
            }
        }catch(Exception e){
            ManagerArchivo.escribirLog("["+new Date()+"] ERROR->"+e.getMessage());
        }
        ManagerArchivo.escribirLog("["+new Date()+"] "+nombre+" "+apellidoP+" "+apellidoM+" Inicia sesión");
        login.dispose();
        switch(tipo){
            case Data.SECRETARIA:{
                new GuiSecretaria();
            }break;
            case Data.ABOGADO:{
                new GuiAbogado();
            }break;
            case Data.ADMINISTRADOR:{
                new GuiAdmin();
            }break;
            default: {
                ManagerArchivo.escribirLog("["+new Date()+"] ERROR: \""+tipo+"\" es un tipo de Usuario no Definido en el Sistema");
                System.exit(-1);
            }
        }
        System.out.println(ci+" | "+titulo+" | "+nombre+" | "+apellidoP+" | "+apellidoM);
    }
    
    public static String db;
    public static String host;
    public static String user;
    public static String password;
    public static ManagerArchivo managerArchivo = new ManagerArchivo();
    public static Conexion con = new Conexion(user,password,host,db);
    public static Login login;
}
