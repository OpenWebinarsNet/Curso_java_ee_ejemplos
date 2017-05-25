<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Detalles del pago</h1>
    <h2>No Emp: ${pago.noEmpleado}</h2>
    <h2>Empleado: ${pago.nombre}</h2>
    <h2>Horas trabajadas: ${pago.horasTrabajadas}</h2>
    <h2>Precio por hora: ${pago.precioHora}</h2>
    <h2><font color="red">Total a pagar: ${ pago.horasTrabajadas * pago.precioHora } euros </font></h2>
    <h2></h2>
  </body>
</html>
