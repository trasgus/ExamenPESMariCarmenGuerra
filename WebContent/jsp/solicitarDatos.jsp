<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ExamenPESMariCarmenGuerra/css/estilos.css" />
<title>Solicitar Datos</title>
</head>
<body>    
    
<form method="post" action="${pageContext.request.contextPath}/TarjetaCredito/darAlta" name="darAltaTarjeta"> 
<!-- enlace con # se queda en la misma página -->
    <fieldset>
    <label>SOLICITAR DATOS:</label>
    <br/>
    <label>Numero Tarjeta:</label>
    <input type="text" name="numero" id="numero"/>
    <br/>
    <label>Cupo Maximo:</label>
    <input type="text" name="cupoMaximo" id="cupoMaximo"/>
    <br/>
     <label>Tipo:</label>
    <input type="text" name="tipo" id="tipo"/>
    <br/>
     <label>Número de Comprobación:</label>
    <input type="text" name="numeroComprobacion" id="numeroComprobacion"/>
    <br/>
    <label>Password:</label>
    <input type="password" name="contrasenha" id="contrasenha"/>
    <br/>
    <label>Bloqueada:</label>
    <input type="radio" name="bloqueada" id="bloqueada" value="bloqueada"/><p>Bloqueada</p>
    <br/>
    <input type="radio" name="bloqueada" id="bloqueada" value="desbloqueada"/><p>Desbloqueada</p>
    <br/>
    <label>Cantidad a Pagar:</label>
    <input type="text" name="cantidad" id="cantidad"/>
    <br/>
    <input type="submit" name="enviar" value="enviar"/>
    <input type="reset" name="reiniciar" value="Reiniciar"/>
    </fieldset>
</form>




</body>
</html>