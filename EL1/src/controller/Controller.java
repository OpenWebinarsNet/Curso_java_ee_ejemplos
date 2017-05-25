package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empleado;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibimos el parametro de la peticion get (Link)
		String noEmp = request.getParameter("noEmpleado");
		Empleado pagoBean = new Empleado(Integer.parseInt(noEmp));
		// Llenamos JavaBean (podriamos utilizar una bd)
		pagoBean.setNombre("Jose Antonio");
		pagoBean.setHorasTrabajadas(4);
		pagoBean.setPrecioHora(75);
		request.setAttribute("pago", pagoBean);
		RequestDispatcher rd = request.getRequestDispatcher("salario.jsp");
		rd.forward(request, response);
	}
}
