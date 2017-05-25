package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSON
 */
@WebServlet("/JSON")
public class JSON extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        out.println("{\"employees\":[\n"
                + "    {\"firstName\":\"John\", \"lastName\":\"Doe\"},\n"
                + "    {\"firstName\":\"Anna\", \"lastName\":\"Smith\"},\n"
                + "    {\"firstName\":\"Peter\", \"lastName\":\"Jones\"}\n"
                + "]}");
	}

}
