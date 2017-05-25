package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import model.Servidor;

public class ServidorDao {

    private DbConnection conn;

    public ServidorDao(DbConnection conn) {
        this.conn = conn;
    }

    /**
     * Metodo para insertar un registro en la tabla Servidor
     *
     * @param servidor
     * @return Regresa el id generado por la base de datos
     * @throws Exception
     */
    public boolean insert(Servidor srv) {

    	//Para dar formato a un String a tipo fecha.
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String sql = "insert into Servidor values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, srv.getId());
            //En lugar de setDate usamos un String dándole formato
            preparedStatement.setString(2, format.format(srv.getFechaPublicacion()));
            preparedStatement.setString(3, srv.getNombre());
            preparedStatement.setString(4, srv.getDescripcion());
            preparedStatement.setString(5, srv.getDetalle());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error ServidorDao.insert: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo que regresa una lista con los 3 ultimos servidores que seran
     * mostrados en la pagina principal
     *
     * @return
     * @throws Exception
     */
    public List<Servidor> getUltimos() {

        try {
            String sql = "select * from Servidor order by id desc limit 3";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Servidor> list = new LinkedList<>();
            Servidor srv;
            while (rs.next()) {
                srv = new Servidor(rs.getInt("id"));
                srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                srv.setNombre(rs.getString("nombre"));
                srv.setDescripcion(rs.getString("descripcion"));
                srv.setDetalle(rs.getString("detalle"));
                // Add servidor object to the list
                list.add(srv);
                System.out.println(list);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error ServidorDao.getUltimos: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para buscar en la base de datos un registro de Servidor por
     * medio del id
     *
     * @param idServidor
     * @return Objeto de tipo servidor. Si no lo encuentra, regresa null
     * @throws Exception
     */
    public Servidor getById(int idServidor){
        try {
            String sql = "select * from Servidor where id=? limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idServidor); // Set idServidor
            ResultSet rs = preparedStatement.executeQuery();
            Servidor srv = new Servidor(0);
            while (rs.next()) {
                // Create an object for the movie
            	srv.setId(rs.getInt("id"));
            	srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
            	srv.setNombre(rs.getString("nombre"));
            	srv.setDescripcion(rs.getString("descripcion"));
            	srv.setDetalle(rs.getString("detalle"));
            }
            return srv;

        } catch (SQLException e) {            
            System.out.println("Error ServidorDao.getById: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo que regresa una lista con todos los servidores.
     *
     * @return Lista de todos los objetos servidor
     * @throws Exception
     */
    public List<Servidor> getAll(){

        try {
            String sql = "select * from Servidor order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Servidor> list = new LinkedList<>();
            Servidor srv;
            while (rs.next()) {
            	srv = new Servidor(rs.getInt("id"));
                srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                srv.setNombre(rs.getString("nombre"));
                srv.setDescripcion(rs.getString("descripcion"));
                srv.setDetalle(rs.getString("detalle"));       
                // Add servidor object to the list
                list.add(srv);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error ServidorDao.getAll: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para hacer busqueda de servidores (la busqueda se hace por
     * descripcion y nombreServidor)
     *
     * @param query
     * @return Lista de todos los objetos servidores que fueron encontrados
     * @throws Exception
     */
    public List<Servidor> getByQuery(String query){

        try {
            String sql = "select * from Servidor where (descripcion like ? or nombre like ?) order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + query + "%");
            ResultSet rs = preparedStatement.executeQuery();
            List<Servidor> list = new LinkedList<>();
            Servidor srv;
            while (rs.next()) {
            	srv = new Servidor(rs.getInt("id"));
            	srv.setFechaPublicacion(rs.getDate("fechaPublicacion"));
            	srv.setNombre(rs.getString("nombre"));
            	srv.setDescripcion(rs.getString("descripcion"));
            	srv.setDetalle(rs.getString("detalle"));                
                // Add servidor object to the list
                list.add(srv);
            }
            return list;

        } catch (SQLException e) {            
            System.out.println("Error ServidorDao.getByQuery: " + e.getMessage());
            return null;
        }
    }
    
    
    /**
     * Metodo para eliminar un servidor.
     * @param idServidor
     * @return No. de filas afectadas
     */
    public int delete(int idServidor) {
        try {
            String sql = "delete from Servidor where id=?";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, idServidor);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (SQLException e) {            
            System.out.println("Error ServidorDao.eliminar: " + e.getMessage());
            return 0;
        }
    }

}
