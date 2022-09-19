package conexion;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ReinicioBDMySQL {
    public ReinicioBDMySQL() {
            super();
            }
            private String ultimoMensajeMySQL="";

            public String reinicioBD(String msgsql) {
            String sql = "SELECT * from "+msgsql+";";
            try {
            Statement st = Conexion.getConexion().createStatement();
            st.executeUpdate(sql);
            ultimoMensajeMySQL="Reinicio del sistema exitoso!.\nEl sistema se apagará.\n"+sql+"\n"+msgsql;
                JOptionPane.showMessageDialog(null, ultimoMensajeMySQL);
                System.exit(0);
            } catch (SQLException e) {
            ultimoMensajeMySQL="Error: " + e.getMessage();
                JOptionPane.showMessageDialog(null, ultimoMensajeMySQL);
            }
            return ultimoMensajeMySQL;
            }
            }
