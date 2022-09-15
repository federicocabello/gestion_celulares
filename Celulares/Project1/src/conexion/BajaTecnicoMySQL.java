package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class BajaTecnicoMySQL {
    public BajaTecnicoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
        
        public String bajaTecnico(String id){
            String sql = "DELETE FROM tecnico WHERE idtecnico='"+id+"';";
            try {
                Statement st = Conexion.getConexion().createStatement();
                int nRegBorrados = st.executeUpdate(sql);
                if(nRegBorrados==1){
                ultimoMensajeMySQL= nRegBorrados + " registro borrado.\nEl técnico con ID: "+id+" fue borrado con éxito.\n";
                }else{
                    ultimoMensajeMySQL= nRegBorrados+" registros borrados.\nEl técnico ingresado no existe en el sistema.";
                }
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;                                   
                                                                  
        }
        }
