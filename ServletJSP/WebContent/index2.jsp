<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<%-- Comentarios --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mi primer JSP</title>
</head>
<body>
	<h1>Ejemplo Scriplets</h1>
	<%-- Código Java: Creamos una lista e insertamos 3 items --%>
	<%
       String titulo = "Lista de productos";
       List<String> catalogo = new ArrayList();
       catalogo.add("Portatil");
       catalogo.add("Impresora");
       catalogo.add("Escaner");
    %>
    <%-- EXPRESION JSP --%>
	<h2><%=titulo%></h2>
	<select name="producto" multiple>
	<%-- Código Java: Utilizamos la lista para iterar por sus elementos y representarlos en HTML --%>
	<%
	  //Utilizamos el objeto implícito "out" (sin necesidad de crear una instancia del objeto response)
      for (String producto : catalogo){ 
      	out.print("<option>"+producto+"</option>");
      }
    %>
	</select>
</body>
</html>