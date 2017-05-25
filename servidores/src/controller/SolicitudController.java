package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import dao.DbConnection;
import dao.SolicitudDao;
import dao.ServidorDao;
import model.Solicitud;
import model.Servidor;
import util.Utility;

public class SolicitudController extends HttpServlet {

    /*
    Directorio donde se guardaran los archivos fisicos.
    webapps/servidores/uploads
     */
    private static final String UPLOAD_DIR = "uploads";

    /**
     * 1. Guardar un registro de una solicitud para un servidor
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        // Recibimos los campos de tipo texto
        String nombreParam = request.getParameter("nombre");
        String emailParam = request.getParameter("email");
        String telefonoParam = request.getParameter("telefono");
        String direccionParam = request.getParameter("direccion");
        // Este parametro idServidor es el que viene en la URL del boton "Enviar"
        // servidor?action=enviar&id=${servidor.id}
        // Para insertarlo en la tabla Solicitud reservamos el idServidor (Foreign key)
        int idServidorParam = Integer.parseInt(request.getParameter("idServidor"));

        // Creamos el objeto que guardaremos
        Solicitud solicitud = new Solicitud(0);
        solicitud.setFecha(new Date());
        solicitud.setNombre(nombreParam);
        solicitud.setEmail(emailParam);
        solicitud.setTelefono(telefonoParam);
        solicitud.setDireccion(direccionParam);
        DbConnection conn = new DbConnection();
        ServidorDao servidorDao = new ServidorDao(conn);
        // Buscamos el objeto Servidor, por medio del parametro idServidor que viene del boton "Enviar"
        Servidor srv = servidorDao.getById(idServidorParam);
        //Inyeccion del objeto Servidor en la solicitud (Foreign Key)
        solicitud.setServidor(srv);

        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        /*
        La clase Part, representa un archivo fisico que subio el usuario. Este nombre "archivo" debe ser el especificado
        en el formulario HTML para input de tipo file
            <input type="file" required id="archivo" name="archivo">
        */
        Part archivo = request.getPart("archivo");
        String archivoParam = archivo.getSubmittedFileName();
        RequestDispatcher rd;
        //Archivo valido, si lo guardamos
        String msg="";
        if (archivoParam.endsWith("pdf") || archivoParam.endsWith("odt")) {

            /**
             * El nombre del archivo que guardaremos sera como sigue:
             *  1. Generamos una cadena de 10 caractereas aleatorios apoyandonos de la clase Utility.randomAlphaNumeric
             *  2. Posteriomente, al nombre del archivo "archivoParam", le hacemos un reemplazo de cualquier caracter de espacio
             *  por guiones. Suponiendo que el archivo que subio el usuario se llama "datos prueba.doc", con este procedimiento quedara
             *  por ejemplo   "O8PJYTTPJ7datos-prueba.doc"
             *  Ese sera el nombre del archiivo que guardaremos en la BD.
             *  Con esto nos aseguramos de que nunca se reemplazaran.
             */
            
            String archivoFisico = Utility.randomAlphaNumeric(10) + archivoParam.replace(" ", "_");
            // Asignamos el nombre del archivo que guadaremos en la bd
            solicitud.setArchivo(archivoFisico);

            SolicitudDao solicitudDao = new SolicitudDao(conn);
            solicitudDao.insert(solicitud);
            conn.disconnect();
            msg = "<b>" + solicitud.getNombre() + "</b> hemos recibido tus datos."
                    + "<br> Revisaremos tu solicitud y nos pondremos en contacto contigo.<br><br>Gracias.";
            request.setAttribute("message", msg);
            
            // Escribimos el archivo al disco duro del servidor
            // Aqui se guarda el archivo al directorio webapps/servidores/uploads con el nombre formado anteriormente
            archivo.write(uploadFilePath + File.separator + archivoFisico); 
            rd = request.getRequestDispatcher("/mensaje_guest.jsp");
            rd.forward(request, response);
        } else { // No es un archivo valido...
            
            msg = "Solo se permiten archivos de tipo PDF y ODT";
            request.setAttribute("message", msg);
            /**
             * Si subio otro tipo de archivo, no lo permitimos.
             * Aqui lo que hacemos es compartir el JavaBean solicitud que en este punto ya esta completo con lo que capturo
             * el usuario. Aqui hacemos una redireccion a la vista frm.jsp que es la vista donde el usuario captura su nombre, 
             * correo, direccion, telefono. Entonces como estamos regresando el Javabean solicitud a la vista, no tendra que capturar de nuevo su
             * nombre, correo, direccion, telefono, ya que al estar disponible este Javabean, mostramos los valores de cada propiedad en
             * cada input del formulario por ejemplo. <input type="text" class="form-control" name="nombre" value="${solicitud.nombre}" required id="nombre">
             * De esta forma el formulario quedara lleno con lo que habia capturado el usuario anteriomente y solo tendra que volver a subir otro archivo.
             */
            request.setAttribute("solicitud", solicitud);
            /**
             * Tambien regresamos a la vista frm.jsp el Javabean servidor, porque lo ocupamos para indicar el valor del idServidor para la solicitud 
             * del usuario. Esto lo hacemos en <input type="hidden" value="${servidor.id}" name="idServidor">
             */
            request.setAttribute("servidor", solicitud.getServidor());
            rd = request.getRequestDispatcher("/frm.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibimos el parametro action, el cual servira para saber que accion GET se ejecutara
        String action = request.getParameter("action");
        // Recuperamos la session activa que viene junto con el request
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        switch (action) {
            case "solicitudes":
                if (session.getAttribute("usuario") == null) {
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.verSolicitudes(request, response);
                }
                break;
        }

    }

    /**
     * Metodo que se ejecuta, si el parametro action, es solicitudes
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void verSolicitudes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        String msg = null;
        List<Solicitud> lista = null;
        DbConnection conn = new DbConnection();
        SolicitudDao solicitudDao = new SolicitudDao(conn);
        lista = solicitudDao.getAll();
        conn.disconnect();

        request.setAttribute("message", msg);
        request.setAttribute("solicitudes", lista);
        rd = request.getRequestDispatcher("/solicitudes.jsp");
        rd.forward(request, response);
    }

}
