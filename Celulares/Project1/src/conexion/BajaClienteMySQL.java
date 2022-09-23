package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class BajaClienteMySQL {
    public BajaClienteMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
        
        public String bajaCliente(String dni){
            String sql = "DELETE FROM cliente WHERE DNI='"+dni+"';";
            try {
                Statement st = Conexion.getConexion().createStatement();
                int nRegBorrados = st.executeUpdate(sql);
                if(nRegBorrados==1){
                ultimoMensajeMySQL= nRegBorrados + " registro borrado.\nEl cliente con DNI: "+dni+" fue borrado con éxito.\nTodos los dispositivos a nombre del cliente borrado se actualizaron al estado 'Cliente Borrado'.";
                }else{
                    ultimoMensajeMySQL= nRegBorrados+" registros borrados.\nEl cliente ingresado no existe en el sistema.";
                }
            } catch (SQLException e) {
                ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;                                   
                                                                  
        }
        }
