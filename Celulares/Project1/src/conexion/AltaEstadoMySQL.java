package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class AltaEstadoMySQL {
    public AltaEstadoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String altaEstado(String nombre) {
        String sql = "INSERT INTO estado (descripcion) VALUES ('"+nombre+"');";
        try {
        Statement st = Conexion.getConexion().createStatement();
        st.executeUpdate(sql);
        ultimoMensajeMySQL="Registro guardado.\nEl estado "+nombre+" para un dispositivo fue agregado con éxito al sistema.";
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }