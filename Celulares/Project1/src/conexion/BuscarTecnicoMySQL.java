package conexion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarTecnicoMySQL {
    public BuscarTecnicoMySQL() {
            super();
            }
            private String ultimoMensajeMySQL="";

            public String buscarTecnico(String asterisco) {
            Statement st = null;
            ResultSet conjuntoResultados = null;
            String SQL = "SELECT "+asterisco+" FROM tecnico ORDER BY idtecnico ASC";
            try {
            st = Conexion.getConexion().createStatement();
            conjuntoResultados = st.executeQuery(SQL);
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            int numeroDeColumnas = metaDatos.getColumnCount();
            ultimoMensajeMySQL = "Columnas = " + numeroDeColumnas + "\n";
            for ( int i = 1; i <= numeroDeColumnas; i++ ) {
            ultimoMensajeMySQL = ultimoMensajeMySQL + metaDatos.getColumnName(i) + "\t";
            }
            ultimoMensajeMySQL = ultimoMensajeMySQL + "\n";
            while ( conjuntoResultados.next() ) {
            for ( int i = 1; i <= numeroDeColumnas; i++ ) {
            ultimoMensajeMySQL = ultimoMensajeMySQL + conjuntoResultados.getObject( i ) + "\t";
            }
            ultimoMensajeMySQL = ultimoMensajeMySQL + "\n";
            }   
            } catch (SQLException e) {
            ultimoMensajeMySQL="Error: " + e.getMessage();
            }
            return ultimoMensajeMySQL;
            }
            }

