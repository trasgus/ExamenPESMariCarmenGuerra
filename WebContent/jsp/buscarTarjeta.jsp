 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ExamenPESMariCarmenGuerra/css/estilos.css" />
<title>Datos Tarjeta</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/TarjetaCredito/buscarTarjetaPorNumero" name="buscarTarjetasPorNumero" >
       
    <label>Busqueda de Tarjeta:</label>
    <label>Numero Tarjeta:</label>
        <input type="text" name="numero" id="numero"/>
          
     <input type="submit" name="enviar" value="Mostrar datos de tarjeta"/>
    <input type="reset" name="reiniciar" value="Reiniciar"/>
        </form>

</body>
</html>