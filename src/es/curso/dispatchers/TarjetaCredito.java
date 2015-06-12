package es.curso.dispatchers;

import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.curso.controllersEjb.DarAltaTarjetaControllerEjb;
import es.curso.model.entity.Tarjeta;



/**
 * Servlet implementation class TarjetaCredito
 */
@WebServlet("/TarjetaCredito/*")
public class TarjetaCredito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarjetaCredito() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String titulo = "sin título";
		RequestDispatcher rd; 
		switch(action){
			case "darAltaTarjeta": 
//				darAltaTarjetaControllerEjb listado= new darAltaTarjetaControllerEjb();
//				ArrayList<Tarjeta> tarjetas=listado.listarTarjetas();
//				request.setAttribute("tarjetas", tarjetas);
//				
//				titulo= "Listado general de tarjetas";
//				request.setAttribute("titulo", titulo);
				rd = request.getRequestDispatcher("/jsp/solicitarDatos.jsp"); 
				rd.forward(request, response);
				break;
		
				                
				                
				
//			case "listarTodos":
//				
//				ListarTodosControllerEjb todos= new ListarTodosControllerEjb();
//				ArrayList<Cliente> clientes=todos.listarTodos();
//				request.setAttribute("clientes", clientes);
//				
//				titulo= "Listado general de clientes";
//				request.setAttribute("titulo", titulo);
//				rd = request.getRequestDispatcher("/jsp/listarTodos.jsp"); 
//				rd.forward(request, response);
//				break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String titulo = "sin título";
		RequestDispatcher rd; 
		switch(action){
			case "darAlta": //va al controller y dao para ingresar datos cliente y objener numero tarjeta
				int x=0;
				String numero = request.getParameter("numero");
			    int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
				String tipo = request.getParameter("tipo");
				String numeroComprobacion = request.getParameter("numeroComprobacion");
				String contrasenha = request.getParameter("contrasenha");
				String claveVerificacion = request.getParameter("claveVerificacion");
				boolean bloqueada = Boolean.parseBoolean(request.getParameter("bloqueada"));
				
				
				Tarjeta tarjeta = new Tarjeta(0, numero, cupoMaximo, tipo, numeroComprobacion, contrasenha, claveVerificacion, bloqueada);
				//invocará al controlador adecuado
				DarAltaTarjetaControllerEjb controlador=new DarAltaTarjetaControllerEjb();
				controlador.agregar(tarjeta);
				rd = request.getRequestDispatcher("/index.jsp"); //lo redicionamos a index
				rd.forward(request, response);
				break;

				                
		
		
		
	}

}
}
