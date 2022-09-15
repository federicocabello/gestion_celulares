package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class BajaCelularMySQL {
    public BajaCelularMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
        
        public String bajaCelular(String registro){
            String sql = "DELETE FROM celulares WHERE registro='"+registro+"';";
            try {
                Statement st = Conexion.getConexion().createStatement();
                int nRegBorrados = st.executeUpdate(sql);
                if(nRegBorrados == 1){
                ultimoMensajeMySQL= nRegBorrados + " registro borrado.\nEl dispositivo N°"+registro+" fue eliminado con éxito.";
                }else{
                    ultimoMensajeMySQL= nRegBorrados + " registros borrados.\nEl dispositivo ingresado no existe en el sistema.";
                }
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;                                   
                                                                  
        }
        }
