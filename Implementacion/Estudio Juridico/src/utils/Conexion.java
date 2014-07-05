package utils;

/**
 *
 * @author [GVM - MABH - LCOS]
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private String user;
    private String password;
    private String host;
    private String url;
    private Connection conn = null;
    private Statement stm;
    private String db;

    public Conexion(String usuario, String contraseña, String servidor, String bd) {
        this.user = usuario;
        this.password = contraseña;
        this.db = bd;
        this.host = servidor;
        this.url = "jdbc:mysql://" + this.host + "/" + this.db;
        conectar();
    }

    private void conectar() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                stm = conn.createStatement();
                stm.addBatch("use " + db + ";");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    "SE PRODUJO UN ERROR MIENTRAS SE INTENTABA "
                    + "\nCONECTAR A LA BASE DE DATOS.\n\n"
                    + "REVISE EL ARCHIVO DE CONFIGURACION Y\n"
                    + "VERIFIQUE SI SU CONFIGURACION ES CORRECTA\n\n"
                    + "DE PERSISTIR EL PROBLEMA \n"
                    + "CONTACTE CON EL ADMINISTRADOR DE SISTEMAS",
                    "ERROR AL INTENTAR CONECTAR A LA BASE DE DATOS",JOptionPane.ERROR_MESSAGE);
            ManagerArchivo.escribirLog("["+new Date()+"] ERROR AL INTENTAR CONECTAR A LA BASE DE DATOS ->"+ex.getMessage());
            System.exit(0);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void ejecutar(String consulta) {
        try {
            stm.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la ejecucion de: " + consulta);
        }
    }

    public ResultSet consultar(String consulta) {
        ResultSet rs = null;
        try {
            rs = stm.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error realizar la Consutla: \n" + consulta + "\n");
        }
        return rs;
    }
}
