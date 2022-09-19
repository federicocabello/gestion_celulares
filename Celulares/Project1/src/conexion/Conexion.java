package conexion;

import app.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import app.conexion_consulta;
import app.VentanaPrincipal;

public class Conexion {
    private String ultimoMensajeMySQL="";
    private String CONTROLADOR="com.mysql.cj.jdbc.Driver";
    private String URL_BASEDATOS = "jdbc:mysql://";
    private static Connection Conexion = null;
    private String usuario="";
    private String clave="";
    private String nombreDB="";
    private String servidorIP="";
    private String puerto="";
    
    
    public Conexion(String usuario, String clave, String nombreDB, String servidorIP, String puerto) {
        super();
        this.usuario=usuario;
        this.clave=clave;
        this.nombreDB=nombreDB;
        this.servidorIP=servidorIP;
        this.puerto=puerto;
        URL_BASEDATOS=URL_BASEDATOS + servidorIP + ":" + puerto + "/" + nombreDB;
    }
    public String conectar(){
        try { 
            Class.forName(CONTROLADOR);
            Conexion=DriverManager.getConnection(URL_BASEDATOS,usuario,clave);
            //ultimoMensajeMySQL = "Conexión realizada!";
            VentanaPrincipal.jLabel1.setVisible(true);
            VentanaPrincipal.jMenu1.setEnabled(true);
            VentanaPrincipal.jMenu2.setEnabled(true);
            VentanaPrincipal.jMenu3.setEnabled(true);
            VentanaPrincipal.jMenu4.setEnabled(true);
            VentanaPrincipal.jTextField1.setEnabled(true);
            VentanaPrincipal.jTextField2.setEnabled(true);
            VentanaPrincipal.jTextField3.setEnabled(true);
            VentanaPrincipal.jTextField4.setEnabled(true);
            VentanaPrincipal.jTextField5.setEnabled(true);
            VentanaPrincipal.jTextField6.setEnabled(true);
            VentanaPrincipal.jTextField7.setEnabled(true);
            VentanaPrincipal.jTextField8.setEnabled(true);
            VentanaPrincipal.jScrollPane1.setEnabled(true);
            VentanaPrincipal.jButton3.setEnabled(true);
            VentanaPrincipal.jButton4.setEnabled(true);
            VentanaPrincipal.jComboBox1.setEnabled(true);
            VentanaPrincipal.jComboBox2.setEnabled(true);
            VentanaPrincipal.jLabel2.setEnabled(true);
            VentanaPrincipal.jLabel3.setEnabled(true);
            VentanaPrincipal.jLabel4.setEnabled(true);
            VentanaPrincipal.jLabel5.setEnabled(true);
            VentanaPrincipal.jLabel6.setEnabled(true);
            VentanaPrincipal.jLabel7.setEnabled(true);
            VentanaPrincipal.jLabel8.setEnabled(true);
            VentanaPrincipal.jLabel9.setEnabled(true);
            VentanaPrincipal.jLabel10.setEnabled(true);
            VentanaPrincipal.jLabel11.setEnabled(true);
            VentanaPrincipal.jLabel12.setEnabled(true);
            VentanaPrincipal.jLabel13.setEnabled(true);
            conexion_consulta.conectar();
            VentanaPrincipal.jComboBox1.removeAllItems();
            ArrayList<String> lista = new ArrayList<String>();
            lista = conexion_consulta.llenar_combo();
            for(int i = 0; i<lista.size();i++){
                VentanaPrincipal.jComboBox1.addItem(lista.get(i));
            }
            VentanaPrincipal.jComboBox2.removeAllItems();
            ArrayList<String> lista2 = new ArrayList<String>();
            lista2 = conexion_consulta.llenar_combo2();
            for(int i = 1; i<lista2.size();i++){
                VentanaPrincipal.jComboBox2.addItem(lista2.get(i));
            }
            String uu=BaseDatos.jTextField1.getText();
            if(uu.equals("root")){
                ultimoMensajeMySQL="Conexión realizada! Bienvenid@.\nHa ingresado al sistema como ADMINISTRADOR ("+uu+").";
                VentanaPrincipal.jMenu5.setEnabled(true);
            }else{
                ultimoMensajeMySQL="Conexión realizada! Bienvenid@.\nHas ingresado al sistema como USUARIO ("+uu+").";
            } 

        }   catch (ClassNotFoundException e){
            ultimoMensajeMySQL="Error ajeno con la conexión: "+e.getMessage();
            }   catch (SQLException e){
                ultimoMensajeMySQL="Error con la conexión de SQL: "+e.getMessage();
                }   catch (Exception e){
                    ultimoMensajeMySQL="Error con la conexión de Java: "+e.getMessage();
                } return ultimoMensajeMySQL;
            }

    public static Connection getConexion() {
        return Conexion;
    }
}

