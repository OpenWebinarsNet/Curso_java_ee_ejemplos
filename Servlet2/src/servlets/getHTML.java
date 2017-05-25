package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getHTML
 */
@WebServlet("/getHTML")
public class getHTML extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// El método devolverá una página HTML estática
		
		//Especificamos que la respuesta será texto en formato HTML
        response.setContentType("text/html;charset=UTF-8");
        
        //Utilizando el objeto out escribimos el código HTML de respuesta
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
        out.println("<tr>");
        out.println("<th>1</th>");
        out.println("<th>Sonido</th>");
        out.println("<th>Auriculares</th>");
        out.println("<th>12€</th>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

	}
}
