package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarMontoMySQL {
    public ModificarMontoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarMonto(String registro, int monto) {
                String sql = "UPDATE celulares SET monto="+monto+" WHERE registro="+registro+";";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL= nRegBorrados + " registro editado.\nEl monto del dispositivo N°"+registro+" fue actualizado con éxito.";
                    }else{
                        ultimoMensajeMySQL= nRegBorrados + " registros editados.\nEl dispositivo ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }