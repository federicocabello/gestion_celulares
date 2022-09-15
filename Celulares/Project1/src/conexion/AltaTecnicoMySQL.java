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
        ultimoMensajeMySQL="Registro guardado.\nEl técnico fue agregado con éxito al sistema.\nLos datos ingresados del nuevo técnico son:\nNombre: "+nombre+"\nApellido: "+apellido+"\nCorreo electrónico: "+correo+"\nTeléfono: "+telefono;
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }