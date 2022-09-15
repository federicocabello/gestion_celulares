package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarFechaMySQL {
    public ModificarFechaMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarFecha(String registro, String dia, String mes, String ano) {
                String sql = "UPDATE celulares SET fechaentrega="+ano+mes+dia+" WHERE registro="+registro+";";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL= nRegBorrados + " registro editado.\nLa fecha estimada de entrega del dispositivo N°"+registro+" fue actualizada con éxito\nal día "+dia+" del mes "+mes+" del año "+ano+".";
                    }else{
                        ultimoMensajeMySQL= nRegBorrados + " registros editados.\nEl dispositivo ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }
