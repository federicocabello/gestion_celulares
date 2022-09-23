package conexion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarTodosCelularesMySQL {
    public MostrarTodosCelularesMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String mostrarTodosCelulares(String asterisco) {
        Statement st = null;
        ResultSet conjuntoResultados = null;
        //String SQL = "SELECT "+asterisco+" FROM celulares";
        String SQL = "SELECT celulares.registro,celulares.marca,celulares.modelo,celulares.problema,celulares.fechaingreso,celulares.dni_cliente,cliente.apellido_cliente,celulares.idtecnico,tecnico.apellido_tecnico,estado.descripcion,celulares.monto,celulares.fechaentrega FROM celulares JOIN cliente ON celulares.dni_cliente=cliente.dni JOIN estado ON celulares.estado=estado.idestado JOIN tecnico ON celulares.idtecnico=tecnico.idtecnico ORDER BY registro ASC;";
        try {
        st = Conexion.getConexion().createStatement();
        //String SQL = "SELECT celulares.registro AS REGG,celulares.marca,celulares.modelo,celulares.problema,celulares.fechaingreso,celulares.dni_cliente,cliente.apellido_cliente,celulares.idtecnico,tecnico.apellido_tecnico,estado.descripcion,celulares.monto,celulares.fechaentrega FROM celulares JOIN cliente ON celulares.dni_cliente=cliente.dni JOIN estado ON celulares.estado=estado.idestado JOIN tecnico ON celulares.idtecnico=tecnico.idtecnico;";
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
