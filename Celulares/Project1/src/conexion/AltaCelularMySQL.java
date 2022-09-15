package conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class AltaCelularMySQL {
    public AltaCelularMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String altaCelular(String marca, String modelo, String problema, String monto, String dia, String mes, String ano, String dni, int tecnico, int estado) {
        String sql = "INSERT INTO celulares (marca, modelo, problema, fechaingreso, dni_cliente, idtecnico, estado, monto, fechaentrega) VALUES ('"+marca+"','"+modelo+"','"+problema+"',current_date(),'"+dni+"',"+tecnico+","+estado+",'"+monto+"',"+ano+mes+dia+");";
        try {
        Statement st = Conexion.getConexion().createStatement();
        st.executeUpdate(sql);
        ultimoMensajeMySQL="Registro guardado.\nSe agregó con éxito un dispositivo al cliente DNI: "+dni+".";
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }
