package conexion;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarTecnicoEspecificoMySQL {
    public BuscarTecnicoEspecificoMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String buscarTecnicoEspecifico(String id) {
        Statement st = null;
        ResultSet conjuntoResultados = null;
        String SQL = "SELECT * FROM tecnico WHERE idtecnico="+id+";";
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
            public String buscarTecnicoEspecifico2(String id) {
            Statement st = null;
            ResultSet conjuntoResultados = null;
            //String SQL = "ALTER TABLE registro RENAME TO regcel;";
            //String SQL = "ALTER TABLE celulares RENAME COLUMN registro TO regcel;";
            //String SQL = "ALTER TABLE celulares CHANGE regcel registro tinyint(5) auto_increment;";
            //String SQL2 = "SELECT celulares.registro,celulares.marca,celulares.modelo,celulares.problema,celulares.fechaingreso,tecnico.apellido_tecnico,estado.descripcion,celulares.monto,celulares.fechaentrega FROM celulares JOIN tecnico ON celulares.idtecnico=tecnico.idtecnico JOIN estado ON celulares.estado=estado.idestado WHERE dni_cliente="+dni+";";
            //String SQL2 = "SELECT celulares.registro,cliente.apellido_cliente,celulares.marca,celulares.modelo,celulares.problema,celulares.fechaingreso,tecnico.apellido_tecnico,estado.descripcion,celulares.monto,celulares.fechaentrega FROM celulares JOIN tecnico ON celulares.idtecnico=tecnico.idtecnico JOIN estado ON celulares.estado=estado.idestado JOIN cliente ON celulares.dni_cliente=cliente.dni WHERE tecnico.idtecnico="+id+";";
            String SQL2 = "SELECT celulares.registro,celulares.marca,celulares.modelo,celulares.problema,celulares.fechaingreso,celulares.dni_cliente,cliente.apellido_cliente,estado.descripcion,celulares.monto,celulares.fechaentrega FROM celulares JOIN cliente ON celulares.dni_cliente=cliente.dni JOIN estado ON celulares.estado=estado.idestado WHERE celulares.idtecnico="+id+";";
            try {
            st = Conexion.getConexion().createStatement();
            //st.executeUpdate(SQL);
            conjuntoResultados = st.executeQuery(SQL2);
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
