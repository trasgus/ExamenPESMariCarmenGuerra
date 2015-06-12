<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ExamenPESMariCarmenGuerra/css/estilos.css" />
<title>Tarjeta de Alta</title>
</head>
<body>

<%-- <form id="formul<%=c.getId()%>" action="#" method="post" onsubmit="return false;">
 --%>  
 <form action="#" method="post" onsubmit="return false;">
   <h2>Su tarjeta ha sido dada de alta los siguientes datos:</h2>
       
        <label>Solicitar Datos:</label>
    <label>Numero Tarjeta:</label>
    <input type="text" name="numero" id="numero"/>
    
    <label>Password:</label>
    <input type="password" name="clave" id="clave"/>
    
    <label>Código de verificación:</label>
    <input type="text" name="claveVerificacion" id="claveVerificacion"/>
    
    <label>Cantidad a Pagar:</label>
    <input type="text" name="cantidad" id="cantidad"/>
    
     <input type="submit" name="enviar" value="enviar"/>
    <input type="reset" name="reiniciar" value="Reiniciar"/>
        </form>



</body>
</html>