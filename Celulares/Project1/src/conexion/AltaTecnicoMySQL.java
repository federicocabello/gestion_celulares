package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class AltaTecnicoMySQL {
    public AltaTecnicoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String altaTecnico(String nombre, String apellido, String correo, String telefono) {
        String sql = "INSERT INTO tecnico (nombre_tecnico, apellido_tecnico, email_tecnico, telefono_tecnico) VALUES ('"+nombre+"','"+apellido+"','"+correo+"','"+telefono+"');";
        try {
        Statement st = Conexion.getConexion().createStatement();
        st.executeUpdate(sql);
        ultimoMensajeMySQL="Registro guardado.\nEl t�cnico fue agregado con �xito al sistema.\nLos datos ingresados del nuevo t�cnico son:\nNombre: "+nombre+"\nApellido: "+apellido+"\nCorreo electr�nico: "+correo+"\nTel�fono: "+telefono;
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }