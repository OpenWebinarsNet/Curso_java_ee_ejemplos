package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XML
 */
@WebServlet("/XML")
public class XML extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<CATALOG>");
        out.println("<CD>");
        out.println("<TITLE>Empire Burlesque</TITLE>");
        out.println("<ARTIST>Bob Dylan</ARTIST>");
        out.println("<COUNTRY>USA</COUNTRY>");
        out.println("<COMPANY>Columbia</COMPANY>");
        out.println("<PRICE>10.90</PRICE>");
        out.println("<YEAR>1985</YEAR>");
        out.println("</CD>");
        out.println("</CATALOG>");
	}

}
