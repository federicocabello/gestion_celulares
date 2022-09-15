package conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class AltaClienteMySQL {
    public AltaClienteMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String altaCliente(String dni, String nombre, String apellido, String domicilio, String correo, String telefono) {
        String sql = "INSERT INTO cliente VALUES ('"+dni+"','"+nombre+"','"+apellido+"','"+domicilio+"','"+correo+"','"+telefono+"');";
        try {
        Statement st = Conexion.getConexion().createStatement();
        st.executeUpdate(sql);
        ultimoMensajeMySQL="Registro guardado.\nEl cliente fue agregado con éxito al sistema.\nLos datos ingresados del nuevo cliente son:\nDNI: "+dni+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nDomicilio: "+domicilio+"\nCorreo electrónico: "+correo+"\nTeléfono: "+telefono;
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }
