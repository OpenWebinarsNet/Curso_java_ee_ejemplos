package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTML
 */
@WebServlet("/HTML")
public class HTML extends HttpServlet {
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/* TODO output your page here. You may use following sample code. */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Respuesta tipo HTML</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hemos recibido tu informacion.</h1>");
		out.println("<h2>Gracias por tus comentarios.</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
