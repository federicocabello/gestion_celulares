package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class BajaEstadoMySQL {
    public BajaEstadoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
        
        public String bajaEstado(String id){
            String sql = "DELETE FROM estado WHERE idestado='"+id+"';";
            try {
                Statement st = Conexion.getConexion().createStatement();
                int nRegBorrados = st.executeUpdate(sql);
                if(nRegBorrados==1){
                ultimoMensajeMySQL= nRegBorrados + " registro borrado.\nEl estado con ID: "+id+" fue borrado con éxito.\n";
                }else{
                    ultimoMensajeMySQL= nRegBorrados+" registros borrados.\nEl estado ingresado no existe en el sistema.";
                }
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;                                   
                                                                  
        }
        }
