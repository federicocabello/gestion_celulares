package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarEstadoCelularMySQL {
    public ModificarEstadoCelularMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarEstadoCelular(String registro, int estado) {
                String sql = "UPDATE celulares SET estado='"+estado+"' WHERE registro="+registro+";";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL= nRegBorrados + " registro editado.\nEl estado del dispositivo N°"+registro+" fue actualizado con éxito.";
                    }else{
                        ultimoMensajeMySQL= nRegBorrados + " registros editados.\nEl dispositivo ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }