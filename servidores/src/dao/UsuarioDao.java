package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDao {

    private DbConnection conn;

    public UsuarioDao(DbConnection conn) {
        this.conn = conn;
    }
    /**
     * Metodo para validar un usuario administrador en la base de datos
     * @param user
     * @param pass
     * @return Objeto de tipo Usuario con id, perfil, estado, etc.
     */
    public Usuario login(String user, String pass) {

        try {
            String sql = "select * from Usuario where username=? and password = md5(?) and estado='activo' limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            Usuario usuario = new Usuario(0);
            while (rs.next()) {
                // Create an object for the user
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setEstado(rs.getString("estado"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.login: " + e.getMessage());
            return null;
        }
    }
}
