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
package pack;

import com.birosoft.liquid.LiquidLookAndFeel;
import data.Usuario;
import gui.GuiAbogado;
import gui.GuiAdmin;
import gui.GuiGestionarArancel;
import gui.GuiSecretaria;
import gui.Login;
import gui.RegistroDocumento;
import java.awt.Frame;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import utils.Conexion;
import utils.ManagerArchivo;
import utils.SQL;

public class Main {

    public static void main(String[] args) {
        style();
        con = Conexion.getInstance();

        frame = login = new Login();
        //registroDocumento = new RegistroDocumento();
    }

    public static void style() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            LiquidLookAndFeel.setLiquidDecorations(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR ESTILO DE VENTANAS \n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR AL CARGAR ESTILO DE VENTANAS ->" + ex.getMessage());
        }
    }

    public static void iniciarSecion(int id_user) {
        ResultSet rs = con.consultar(SQL.mostrarDatosUsuario(id_user));
        String titulo = "";
        String ci = "";
        String nombre = "";
        String apellidoP = "";
        String apellidoM = "";
        int tipo = 0;
        try {
            while (rs.next()) {
                titulo = rs.getString("abreviatura");
                ci = rs.getString("ci");
                nombre = rs.getString("nombre");
                apellidoP = rs.getString("apellido_paterno");
                apellidoM = rs.getString("apellido_materno");
                tipo = rs.getInt("tipo");
            }
        } catch (Exception e) {
            ManagerArchivo.escribirLog("[" + new Date() + "] ERROR->" + e.getMessage());
        }
        ManagerArchivo.escribirLog("[" + new Date() + "] " + nombre + " " + apellidoP + " " + apellidoM + " Inicia sesión");
        login.dispose();
        switch (tipo) {
            case Usuario.SECRETARIA: {
                guiSecretaria = new GuiSecretaria();
            }
            break;
            case Usuario.ABOGADO: {
                frame = new GuiAbogado();
            }
            break;
            case Usuario.ADMINISTRADOR: {
                guiAdmin = new GuiAdmin();
                frame = guiAdmin;
            }
            break;
            default: {
                ManagerArchivo.escribirLog("[" + new Date() + "] ERROR: \"" + tipo + "\" es un tipo de Usuario no Definido en el Sistema");
                System.exit(-1);
            }
        }
    }

    public static GuiGestionarArancel guiGestionarArancel;
    public static String db;
    public static String host;
    public static String user;
    public static String password;
    public static String dirDoc;
    public static ManagerArchivo managerArchivo = new ManagerArchivo();
    public static Conexion con;
    public static Login login;
    public static Frame frame;
    public static RegistroDocumento registroDocumento;
    public static GuiAdmin guiAdmin;
    public static GuiSecretaria guiSecretaria;
   
    // tabla de valores
    public static int REGISTRODOCUMENTO = 0;
    public static int GUIADMIN = 1;
    public static int GUISECRETARIA = 2;
}
