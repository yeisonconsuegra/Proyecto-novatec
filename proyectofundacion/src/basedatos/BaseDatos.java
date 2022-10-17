package basedatos;

import conexion.Conexion;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Donaciones;
import modelo.Donadores;
import modelo.ImprimirCsv;

public class BaseDatos {
    private Conexion con;
    private Connection connection;

    public BaseDatos(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    
    //Registramos los donadores
    
    public boolean insertarDonador(Donadores donadores) throws SQLException {
        String sql = "INSERT INTO regis_donadores VALUES (?,?,?,?,?)";
        con.conectar();
        connection = con.getConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, donadores.getDocumento());
        statement.setString(2, donadores.getNombre());
        statement.setString(3, donadores.getApellido());
        statement.setDouble(4, donadores.getDinero());
        statement.setString(5, donadores.getFundacion_pertenece());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
    
    
        //Insertar registros donaciones
    
    public boolean insertarDonaciones(Donaciones donaciones) throws SQLException {
        String sql = "INSERT INTO donaciones VALUES (?,?,?,?)";
        con.conectar();
        connection = con.getConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, donaciones.getDocu_usuario());
        statement.setString(2, donaciones.getMoneda());
        statement.setDouble(3, donaciones.getCantidad_donada());
        statement.setString(4, donaciones.getFecha_donada());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
    
    
    //lista 
    
        public List<ImprimirCsv> listarCliente() throws SQLException {

        List<ImprimirCsv> lista = new ArrayList<ImprimirCsv>();
        String sql = "SELECT * FROM imprimir_csv";
        con.conectar();
        connection = con.getConexion();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int document_id = resulSet.getInt("document_id");
            String usuario = resulSet.getString("usuario");
            double donado = resulSet.getDouble("donado");
            String nom_fundacion = resulSet.getString("nom_fundacion");
            String fecha_registro = resulSet.getString("fecha_registro");
            ImprimirCsv imprimir = new ImprimirCsv(document_id,usuario, donado, nom_fundacion, fecha_registro);
            lista.add(imprimir);
        }
        con.desconectar();
        return lista;
    }
        
        
        //agregar datos imprimir
        
    public boolean insertarCsv(ImprimirCsv imprimir) throws SQLException {
        String sql = "INSERT INTO imprimir_csv VALUES (?,?,?,?,?)";
        con.conectar();
        connection = con.getConexion();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, imprimir.getDocumento());
        statement.setString(2, imprimir.getUsuarioNombre());
        statement.setDouble(3, imprimir.getDonado());
        statement.setString(4, imprimir.getNomFundacion());
        statement.setString(5, imprimir.getFechaRegistro());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
    
    
}
