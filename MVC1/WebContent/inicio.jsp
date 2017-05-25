<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido</title>
</head>
<body>
    <!-- Mostramos al usuario, haciendo uso (EL), los objetos compartidos por el Controller. EL llamará de forma interna al método getName() -->
    <h1>Welcome usuario: ${user.name}</h1>
</body>
</html>
