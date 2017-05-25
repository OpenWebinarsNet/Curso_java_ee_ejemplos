<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Lista de todos las servidores</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Servidores disponibles</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="homepage">Inicio</a></li>            
            <li><a href="admin?action=login">Administración</a></li>                        
          </ul>
        </nav>
      </div>
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar servidor..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
      <br><br><br>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Lista de Servidores</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">ID</th>
                <th>Servidor</th>
                <th>Publicado</th>                
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${servidores}" var="servidor" varStatus="status">
                <tr>
                  <td class="left">${servidor.id}</td>
                  <td>${servidor.nombre}</td>
                  <td>${servidor.fechaPublicacion}</td>
                  <td><a class="btn btn-default" href="servidor?action=ver&id=${servidor.id}" role="button">Ver Detalles</a>                
                  
                  <c:if test="${usuario.id > 0}">
                    <a class="btn btn-default" href="admin?action=eliminar&idServidor=${servidor.id}" role="button">Eliminar</a> 
                  </c:if>
                        
                  </td>  
                </tr>
              </c:forEach>                      
            </tbody>           
          </table>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2017 JASR.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
