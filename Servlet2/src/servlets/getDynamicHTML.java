package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Producto;
import beans.ProductoDB;

/**
 * Servlet implementation class getDynamicHTML
 */
@WebServlet("/getDynamicHTML")
public class getDynamicHTML extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// La respuesta sera una pagina HTML
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Catalogo de productos</title>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Catalogo de productos</h3>");
		out.println("<table border='1' style='width:100%;'>");
		out.println("<tr>");
		out.println("<th>id</th>");
		out.println("<th>Categoria</th>");
		out.println("<th>Nombre</th>");
		out.println("<th>Precio</th>");
		out.println("</tr>");

		// Generamos contenido HTML dinamico
		ProductoDB db = new ProductoDB();
		List<Producto> lista = db.getAll();
		for (Producto prod : lista) {
			out.println("<tr>");
			out.println("<td>" + prod.getId() + "</td>");
			out.println("<td>" + prod.getCategoria() + "</td>");
			out.println("<td>" + prod.getNombre() + "</td>");
			out.println("<td>" + prod.getPrecio() + " €</td>");
			out.println("</tr>");
		}

		// Termina contenido dinamico
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
		
}
