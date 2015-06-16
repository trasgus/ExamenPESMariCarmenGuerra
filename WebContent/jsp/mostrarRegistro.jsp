<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="es.curso.model.entity.Tarjeta"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ExamenPESMariCarmenGuerra/css/estilos.css" />
<title>Registro</title>

</head>
<body>

    <h1>REGISTRO</h1>

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
         <%-- <form id="formul<%= t.getId()%>" action="${pageContext.request.contextPath}/TarjetaCredito/" method="post">  --%>
          
            <form action="#" method="post">
            <tr>
             <td> <%= t.getId()%>></td>
              <td><%= t.getNumero()%></td>
              <td><%= t.getCupoMaximo()%><td/>
              <td><%= t.getCupoDisponible()%></td>
              <td><%= t.getTipo()%><td/>
              <td><%= t.getNumeroComprobacion()%></td>
              <td><input type="submit"   value="AumentarCupo"  name="Enviar" /></td>
                <td><input type="reset"   value="Reiniciar"  name="Reiniciar" /></td>
            </tr>
        </form>
        <%
            }
        %>

    </table>


</body>
</html>