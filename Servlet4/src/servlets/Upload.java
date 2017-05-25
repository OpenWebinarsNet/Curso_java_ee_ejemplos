package servlets;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Upload
 */

@WebServlet(name = "Upload", urlPatterns = {"/upload"})
@MultipartConfig(location = "/tmp",
	fileSizeThreshold = 1048576, // 1mb
	maxFileSize = 1048576, // 1mb
	maxRequestSize = 5242880) // 5mb
public class Upload extends HttpServlet {
	  /**
	    * Directory where uploaded files will be saved, its relative to the web
	    * application directory.
	    */
	   private static final String UPLOAD_DIR = "uploads";

	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      // gets absolute path of the web application
	      String applicationPath = request.getServletContext().getRealPath("");
	      // constructs path of the directory to save uploaded file
	      String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

	      String name = request.getParameter("name");
	      System.out.println("Name: " + name);
	      String email = request.getParameter("email");
	      System.out.println("email: " + email);

	      Part archivo = request.getPart("photo");

	      System.out.println("part.getContentType : " + archivo.getContentType());
	      System.out.println("part.getSize : " + archivo.getSize());
	      System.out.println("part.getName : " + archivo.getName());
	      System.out.println("part.getSubmittedFileName : " + archivo.getSubmittedFileName());
	      
	      String nombre = archivo.getSubmittedFileName();
	      
	      /*
	      
	      // Podriamos validar el tipo de archivo de la siguiente forma.    
	      if (nombre.endsWith("pdf") || nombre.endsWith("doc") || nombre.endsWith("docx")) {
	         // archivo valido
	      }else{
	         // archivo no permitido
	      }
	      
	      */
	      // Escribimos el archivo al disco duro del servidor
	      archivo.write(uploadFilePath + File.separator + nombre);
	      request.setAttribute("message", "File uploaded successfully ("+ uploadFilePath +")!");
	      getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
	   }
}
