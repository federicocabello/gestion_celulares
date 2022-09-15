package conexion;

import java.sql.SQLException;
import java.sql.Statement;

public class ModificarClienteMySQL {
    public ModificarClienteMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";
            public String modificarCliente(String dni, String nombre, String apellido, String domicilio, String correo, String telefono) {
                String sql = "UPDATE cliente SET nombre_cliente='" +nombre+ "', apellido_cliente='"+apellido+"', domicilio_cliente='"+domicilio+"', email_cliente='"+correo+"', telefono_cliente='"+telefono+"' WHERE dni='"+dni+"';";
                try {
                    Statement st = Conexion.getConexion().createStatement();
                    int nRegBorrados = st.executeUpdate(sql);
                    if(nRegBorrados==1){
                    ultimoMensajeMySQL=nRegBorrados+" registro editado.\nLos datos del cliente fueron actualizados con éxito.\nLos datos nuevos ingresados son:\nDNI: "+dni+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nDomicilio: "+domicilio+"\nCorreo electrónico: "+correo+"\nTeléfono: "+telefono;
                    }else{
                        ultimoMensajeMySQL=nRegBorrados+" registros editados.\nEl cliente ingresado no existe en el sistema.";
                    }
                } catch (SQLException e) {
                    ultimoMensajeMySQL="Error: " + e.getMessage();
                }
            
                return ultimoMensajeMySQL;
        }
        }
