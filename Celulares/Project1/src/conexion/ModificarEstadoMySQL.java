package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarEstadoMySQL {
    public ModificarEstadoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarEstado(String id, String nombre) {
                String sql = "UPDATE estado SET descripcion='"+nombre+"' WHERE idestado='"+id+"';";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL=nRegBorrados+" registro editado.\nLos descripción del estado con ID:"+id+" fueron actualizados con éxito.\nLa nueva descripción ingresada es: "+nombre+".";
                    }else{
                        ultimoMensajeMySQL=nRegBorrados+" registros editados.\nEl el estado con ID:"+id+" ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }
