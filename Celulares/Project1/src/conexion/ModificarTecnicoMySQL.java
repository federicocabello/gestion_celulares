package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarTecnicoMySQL {
    public ModificarTecnicoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarTecnico(String id, String nombre, String apellido, String correo, String telefono) {
                String sql = "UPDATE tecnico SET nombre_tecnico='" +nombre+ "', apellido_tecnico='"+apellido+"', email_tecnico='"+correo+"', telefono_tecnico='"+telefono+"' WHERE idtecnico='"+id+"';";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL=nRegBorrados+" registro editado.\nLos datos del t�cnico fueron actualizados con �xito.\nLos datos nuevos ingresados son:\nID del t�cnico: "+id+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nCorreo electr�nico: "+correo+"\nTel�fono: "+telefono;
                    }else{
                        ultimoMensajeMySQL=nRegBorrados+" registros editados.\nEl t�cnico ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }
