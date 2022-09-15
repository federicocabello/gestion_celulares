package app;

import java.sql.*;
import java.util.ArrayList;

public class conexion_consulta {
    static Connection conexion=null;
    static Statement sentencia;
    static ResultSet resultado;
    public static void conectar(){
        String ruta="jdbc:mysql://";
        String user="usuarionuevo";
        String pass="1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }
    public static ArrayList<String> llenar_combo(){
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM celulares.tecnico;";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista.add(resultado.getString("apellido_tecnico"));
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public static ArrayList<String> llenar_combo2(){
        ArrayList<String> lista2 = new ArrayList<String>();
        String q2 = "SELECT * FROM celulares.estado;";
        try {
            resultado = sentencia.executeQuery(q2);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while(resultado.next()){
                lista2.add(resultado.getString("descripcion"));
            }
        } catch (Exception e) {
        }
        return lista2;
    }
}
