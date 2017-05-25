

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAtributos
 */
@WebServlet("/SetAtributos")
public class SetAtributos extends HttpServlet {
		/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set application scoped attribute
        request.getServletContext().setAttribute("email", "email@gmail.com");

        // set session scoped attribute
        HttpSession session = request.getSession();
        session.setAttribute("usuario", "supervisor");

        // set request scoped attribute
        request.setAttribute("producto", "Portatil Dell");

        
        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        if ("reenviar".equals(action)) {
            RequestDispatcher rd;
            // Reenviamos la respuesta a la vista Menu.jsp
            rd = request.getRequestDispatcher("/Menu.jsp");
            rd.forward(request, response);
        }else{
            // send redirect to other servlet
            request.getRequestDispatcher("GetAtributos").forward(request, response);
        }
	}
}
