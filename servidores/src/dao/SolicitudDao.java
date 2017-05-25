package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import model.Solicitud;

public class SolicitudDao {
    
    private DbConnection conn;

    public SolicitudDao(DbConnection conn) {
        this.conn = conn;
    }
    /**
     * 1. Metodo para insertar una solicitud en la base de datos
     * @param solicitud
     * @return
     * @throws Exception 
     */
    public int insert(Solicitud solicitud) {
      
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      try {
         String sql = "insert into Solicitud values (?,?,?,?,?,?,?,?)";

         PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setInt(1, solicitud.getId());
         preparedStatement.setString(2, format.format(solicitud.getFecha()));
         preparedStatement.setString(3, solicitud.getNombre());         
         preparedStatement.setString(4, solicitud.getEmail());
         preparedStatement.setString(5, solicitud.getTelefono());
         preparedStatement.setString(6, solicitud.getDireccion());         
         preparedStatement.setString(7, solicitud.getArchivo());
         preparedStatement.setInt(8, solicitud.getServidor().getId());
         preparedStatement.executeUpdate();
         ResultSet rs = preparedStatement.getGeneratedKeys();
         int idSolicitud = 0;
         if (rs.next()) {
            idSolicitud = rs.getInt(1);
         }
         return idSolicitud;

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("Error SolicitudDao.insert: " + e.getMessage());
         return 0;
      } 
   }
   /**
    * Metodo que regresa una lista con todas las Solicitudes que le han llegado al Administrador
    * @return 
    */ 
   public List<Solicitud> getAll() {
      
      try {

         String sql = "select * from Solicitud order by id desc";

         PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
         ResultSet rs = preparedStatement.executeQuery();         
         List<Solicitud> list = new LinkedList<>();
         Solicitud solicitud;
         ServidorDao servidorDao = new ServidorDao(conn);
         while (rs.next()) {           
            solicitud = new Solicitud(rs.getInt("id"));
            solicitud.setFecha(rs.getDate("fecha"));
            solicitud.setNombre(rs.getString("nombre"));
            solicitud.setEmail(rs.getString("email"));
            solicitud.setTelefono(rs.getString("telefono"));
            solicitud.setDireccion(rs.getString("direccion"));
            solicitud.setArchivo(rs.getString("archivo"));              
            solicitud.setServidor( servidorDao.getById(rs.getInt("idServidor")) );            
            // Add servidor object to the list            
            list.add(solicitud);
            
         }
         
         return list;

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("Error SolicitudDao.getAll: "+e.getMessage());
         return null;
      } 
   } 
}
