<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="es.curso.model.entity.Tarjeta"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ExamenPESMariCarmenGuerra/css/estilos.css" />
<title>Listado de Tarjetas</title>

<script type="text/javascript">
    function enviar(boton) {
        var formulario = document.getElementById("formul"+ boton.name.substring(3));
        //alteramos el action de acuerdo al botón pulsado
        if (boton.value == "Bloquear")
            formulario.action = "${pageContext.request.contextPath}/banco/bloquearTarjeta";

        if (boton.value == "Desbloquear")
            formulario.action = "${pageContext.request.contextPath}/banco/desbloquearTarjeta";
            
        if (boton.value == "AumentarCupo")
            formulario.action = "${pageContext.request.contextPath}/banco/aumentarCupo";


        
        formulario.submit();

    }
</script>

</head>
<body>

    <h1>LISTADO</h1>


    <%
        ArrayList<Tarjeta> tarjetas = (ArrayList<Tarjeta>) request.getAttribute("tarjetas");
    %>
    
    <table>
        <tr>
            <th>ID:</th>
            <th>NUMERO:</th>
            <th>CUPO MAXIMO:</th>
            <th>CUPO DISPONIBLE:</th>
            <th>TIPO:</th>
            <th>NUMERO DE COMPROBACION:</th>
        </tr>
        <%
            for (Tarjeta t : tarjetas) {
        %>

   
         <form id="formul<%= t.getId()%>" action="${pageContext.request.contextPath}/TarjetaCredito/" method="post" onsubmit="return false;"> 
          
            <tr id="<%= t.getId()%>">
             <td>  <input type="text" name="id" value="<%= t.getId()%>"></td>
              <td>  <input type="text" name="numero" value="<%= t.getNumero()%>" /></td>
              <td>  <input type="text" name="cupoMaximo"
                    value="<%= t.getCupoMaximo()%>" />
              <td> <input type="text" name="cupoDisponible" value="<%= t.getCupoDisponible()%>" /></td>
              <td>  <input type="text" name="tipo" value="<%= t.getTipo()%>" />
              <td>  <input type="text" name="numeroComprobacion" value="<%= t.getNumeroComprobacion()%>" /></td>
                
                
                <td><input id="btnBloquear" type="submit" value="Bloquear"
                    name="btn<%= t.getId()%>" onclick="enviar(this)" /></td>
                <td><input id="btnDesbloquear" type="submit" value="Desbloquear"
                    name="btn<%= t.getId()%>" onclick="enviar(this)" /></td>
                <td><input id="btnAumentarCupo" type="submit" value="AumentarCupo"
                    name="btn<%= t.getId()%>" onclick="enviar(this)" /></td>

            </tr>
        </form>


        <%
            }
        %>

    </table>


</body>
</html>