package test;

import dao.DbConnection;
import dao.UsuarioDao;
import model.Usuario;

public class testDB {

	public static void main(String[] args) {
		DbConnection conn = new DbConnection();
		UsuarioDao userdao = new UsuarioDao(conn);
		Usuario user = userdao.login("admin","admin");
		System.out.println(user);
	}

}
