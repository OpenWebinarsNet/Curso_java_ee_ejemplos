package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DbConnection;
import dao.ServidorDao;
import model.Servidor;

public class BusquedaController extends HttpServlet {
    /**
     * Metodo POST para hacer la busqueda de servidores solicitados por el usuario.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibimos la cadena de busqueda del usuario
        String q = request.getParameter("query");               
        List<Servidor> lista = null;
        DbConnection conn = new DbConnection();
        // Con nuestro objeto DAO, hacemos la busqueda de servidores
        ServidorDao servidorDao = new ServidorDao(conn);
        lista = servidorDao.getByQuery(q);
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("servidores", lista);
        rd = request.getRequestDispatcher("/servidores.jsp");
        rd.forward(request, response);
    }

}
