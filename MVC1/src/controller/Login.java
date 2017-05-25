package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.LoginBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se reciben o validan los datos enviados por el usuario
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		LoginBean bean = new LoginBean();
		bean.setName(name);
		bean.setPassword(password);

		// Realizamos la logica de negocio (procesar y validar los datos)
		boolean status = bean.validate();

		// Compartimos el objeto bean (en el alcance de la request) para poder usarlo en la vista (JSP)
		request.setAttribute("user", bean);

		// Dependiendo de nuestra lógica, redireccionamos (enviamos una respuesta)
		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
