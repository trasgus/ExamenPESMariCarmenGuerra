package es.curso.dispatchers;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllersEjb.ActualizarCupoControllerEjb;

import es.curso.controllersEjb.BuscarTarjetaPorNumeroControllerEjb;

import es.curso.controllersEjb.DarAltaTarjetaControllerEjb;
import es.curso.controllersEjb.ListarTarjetasControllerEjb;
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
			case "solicitarDatosParaAlta": 
				rd = request.getRequestDispatcher("/jsp/solicitarDatosParaAlta.jsp"); 
				rd.forward(request, response);
				break;
				
			case "listarTarjetas":
				ListarTarjetasControllerEjb todas= new ListarTarjetasControllerEjb();
				ArrayList<Tarjeta> tarjetas=todas.listarTodas();
				request.setAttribute("tarjetas", tarjetas);
				
				titulo= "Listado general de tarjetas";
				request.setAttribute("titulo", titulo);
				rd = request.getRequestDispatcher("/jsp/listarTarjetas.jsp"); 
				rd.forward(request, response);
				break;
				
			case "buscarTarjeta":
//				String numero4 = request.getParameter("numero");
//				BuscarTarjetasControllerEjb busc= new BuscarTarjetasControllerEjb();
//				ArrayList<Tarjeta> cards=busc.mostrarRegistro(numero4);
//				request.setAttribute("cards", cards);
//				
//				titulo= "Registro Encontrado";
//				request.setAttribute("titulo", titulo);
				rd = request.getRequestDispatcher("/jsp/buscarTarjeta.jsp"); 
				rd.forward(request, response);
				break;
		
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
			case "darAltaTarjeta": //va al controller y dao para ingresar datos cliente y objener numero tarjeta
			//	int x=0;
				String numero = request.getParameter("numero");
			    int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
			    int cupoDisponible = Integer.parseInt(request.getParameter("cupoDisponible"));
			    int pago = 0;
				String tipo = request.getParameter("tipo");
				String numeroComprobacion = request.getParameter("numeroComprobacion");
				String contrasenha = request.getParameter("contrasenha");
				boolean bloqueada = Boolean.parseBoolean(request.getParameter("bloqueada"));
				
				
				Tarjeta tarjeta = new Tarjeta(0, numero, cupoMaximo, cupoDisponible,  tipo, numeroComprobacion, contrasenha, bloqueada);
				//invocará al controlador adecuado
				DarAltaTarjetaControllerEjb controlador=new DarAltaTarjetaControllerEjb();
				controlador.agregar(tarjeta);
				break;
				
			case "aumentarCupo":
				String numero2 = request.getParameter("numero");
			    int cupoMaximo2 = Integer.parseInt(request.getParameter("cupoMaximo"));
			    int cupoDisponible2 = Integer.parseInt(request.getParameter("cupoDisponible"));
			   // int pago2 = 0;
				String tipo2 = request.getParameter("tipo");
				String numeroComprobacion2 = request.getParameter("numeroComprobacion");
				String contrasenha2 = request.getParameter("contrasenha");
				boolean bloqueada2 = Boolean.parseBoolean(request.getParameter("bloqueada"));
				int aumento = Integer.parseInt(request.getParameter("aumento"));
				
				//cupoMaximo2 = cupoMaximo2 + aumento;
			    Tarjeta tarjeta2 = new Tarjeta(0, numero2, cupoMaximo2, cupoDisponible2,  tipo2, numeroComprobacion2, contrasenha2, bloqueada2);
				//invocará al controlador adecuado
				ActualizarCupoControllerEjb controlador2=new ActualizarCupoControllerEjb();
				controlador2.actualizar(tarjeta2);
		
			break;
				
				
			case "buscarTarjetaPorNumero":
				// recuperar la cadena tecleada en el formulario
				String numeroRecuperado = request.getParameter("numero");
				
				// llamar al controlador adecuado
				BuscarTarjetaPorNumeroControllerEjb controladorNumero = new BuscarTarjetaPorNumeroControllerEjb();
				ArrayList<Tarjeta> result = controladorNumero.searchByNumber(numeroRecuperado);
				// meter en el request el arraylist de respuesta
				request.setAttribute("tarjetas", result);
				
				// mandarle un titulo diferente
				//request.setAttribute("titulo", "Búsqueda por " + numeroRecuperado);
				
				// y redirigir hacia el jsp ListarTodos
				rd = request.getRequestDispatcher("/jsp/mostrarRegistro.jsp");
				rd.forward(request, response);
											
				break;
								
		
	}

}
}
