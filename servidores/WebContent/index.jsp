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
    <title>Departamento de Soporte - Servidores disponibles</title>
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
      
      <!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->    
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar servidor..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
          
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>¡ENCUENTRA TU SERVIDOR!</h2>
        <!--
        <h4>ESTAMOS CONTRATANDO</h4>
        -->
        <p class="lead text-justify">Bienvenido, aquí podrás encontrar las máquinas necesarias para 
          tu trabajo diario. Haz clic en un servidor para ver los detalles y envíanos tu solicitud de reserva. 
          Nosotros revisaremos tu solicitud y contactaremos contigo.<br><br>

        <p><a class="btn btn-lg btn-success" href="servidor?action=lista" role="button">Ver todos los Servidores</a></p>                
      </div>

      <h1>Servidores recientes</h1>

      <!-- Example row of columns -->
      <div class="row">

        <c:forEach items="${ultimos}" var="servidor" varStatus="status">

          <div class="col-lg-4">
            <h3>Servidor: [${servidor.id}]</h3> 
            <p class="text-danger">${servidor.nombre}</p>          
            <p class="text-justify">${servidor.descripcion}</p>
            <p><a class="btn btn-primary" href="servidor?action=ver&id=${servidor.id}" role="button">Ver Detalles&raquo;</a></p>
          </div>

        </c:forEach> 

       
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2017 JASR.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
