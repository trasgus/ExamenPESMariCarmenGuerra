package es.curso.persistence.daoJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;

public class TarjetaDaoJdbc implements TarjetaDao{
	
	
   private Connection cx;
   public TarjetaDaoJdbc() {
		super();
	}
	@Override
	public void create(Tarjeta tarjeta) {
		try {
			// van las instrucciones 
			// para 
			//1. conectar con la base de datos
			abrirConexion();
			//2. preparar la sentencia -sql- para agregar
			PreparedStatement ps = 
			 cx.prepareStatement("INSERT INTO tarjeta VALUES(?,?,?,?,?,?,?,?)");
			  // 2.1 insertar los datos del cliente en los ?
			  ps.setInt(1, 0);
			  ps.setString(2, tarjeta.getNumero());
			  ps.setInt(3, tarjeta.getCupoMaximo());
			  ps.setInt(4, tarjeta.getCupoDisponible()); //tarjeta nueva con cero pagos
			  
			  ps.setString(5, tarjeta.getTipo());
			  ps.setString(6, tarjeta.getNumeroComprobacion());
			  ps.setString(7, tarjeta.getContrasenha());
			  ps.setBoolean(8, tarjeta.isBloqueada());
			//3. Ejecutar la sentencia -sql-
			  ps.executeUpdate();  // = q dar al play en heidi
			        // nota: se usae executeUpdate() para las instrucciones sql
			        // como: insert delete update 
			        // Esta instruciÃ³n devuelve como resultado el nÃºmero de
			        // registros (o filas) afectadas.
			  // 3.1 hacer le commit... 
			  cx.commit();
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//4. Cerrar la conexiÃ³n
			cerrarConexion();
		}
		
	}

	@Override
	public ArrayList<Tarjeta> findAll() {
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		   try {
			//1. abrir la conexiÃ³n
			     abrirConexion();
			   // 2. preparar las sentencias
			     PreparedStatement ps= cx.prepareStatement("SELECT * FROM tarjeta");
			   // 3. ejecutar la sentencia...
			     ResultSet consulta =ps.executeQuery();
			     // 3.1 traspasar los datos de la respuesta al arrayList
			     while(consulta.next()){
			    	 Tarjeta tar = new Tarjeta(); 
			    	 // codigo para traspasar de la consulta(ResultSEt)
			    	 // hacia clienteTemporal
			    	 tar.setId(consulta.getInt("id"));
			    	 tar.setNumero(consulta.getString("numero"));
			    	 tar.setCupoMaximo(consulta.getInt("cupoMaximo"));
			    	 tar.setCupoDisponible(consulta.getInt("cupoDisponible"));
			    	 tar.setTipo(consulta.getString("tipo"));
			    	 tar.setNumeroComprobacion(consulta.getString("numeroComprobacion"));
			    	 tar.setContrasenha(consulta.getString("contrasenha"));
			    	 tar.setBloqueada(consulta.getBoolean("bloqueada"));
			    	 tarjetas.add(tar);
			     }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		   // 4. cerrar la conexion
			cerrarConexion();
		}
	return tarjetas;
	}
	
	private  void abrirConexion(){
			try {
				//1. determinar y validar si tengo el driver o conector (de mysql)
				Class.forName("com.mysql.jdbc.Driver");
				//2. Establecer la conexiÃ³n..
				cx= DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/banco",
						"rootTienda",
						"rootTienda"
						);
				//3. iniciar el autoCommit en false para gestionar TRANSACCIONES
				cx.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	private void cerrarConexion(){
		try {
			if(cx!=null)
			   cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public ArrayList<Tarjeta> searchByNumber(String number) {
		ArrayList<Tarjeta> tarjetas= new ArrayList<Tarjeta>();
		try {
			// 1. Establecer la conexión con la bbdd
			     abrirConexion();
			// 2. Preparar la sentencia sql ,. paramÃ©trizada (son las q tienen ?)
			     PreparedStatement ps = cx.prepareStatement("SELECT * FROM TARJETA WHERE NUMERO LIKE ?");
			  // 2.1 Especificar lo que va en ?
			     ps.setString(1, number);
			// 3. Ejecutar la query
			     ResultSet resultado = ps.executeQuery();
			// 3.1 Pasar los datos que vienen de la bbdd (ResultSet) hacia
			    // el ArrayList<Cliente>
			     while(resultado.next()){
			    	 Tarjeta t = new Tarjeta();
				    	 t.setId(resultado.getInt("id"));
				    	 t.setNumero(resultado.getString("numero"));
				    	 t.setCupoMaximo(resultado.getInt("cupoMaximo"));
				    	 t.setCupoDisponible(resultado.getInt("cupoDisponible"));
				    	 t.setTipo(resultado.getString("tipo"));
				    	 t.setNumeroComprobacion(resultado.getString("numeroComprobacion"));
				    	 t.setContrasenha(resultado.getString("contrasenha"));
				    	 t.setBloqueada(resultado.getBoolean("bloqueada"));
				    	 tarjetas.add(t);
			     }
	    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			// 4.cerrar la conexiÃ³n (en el finally)
              cerrarConexion();			
		}
		return tarjetas;
	}
	@Override
	public void update(Tarjeta tarjeta) {
		try {
			// 1. establecer la conexion
			abrirConexion();
			// 2. preparar la sentnecia
			PreparedStatement ps = cx.prepareStatement(
				   "UPDATE tarjeta SET NUMERO=?, CUPOMAXIMO=?,"
				   + " CUPODISPONIBLE=?,TIPO=?, NUMEROCOMPROBACION=?,"
				   + "CONTRASENHA=?, BLOQUEADA=? WHERE ID =?");
		    // 2.1. RELLENAR LOS ?
				//ps.setInt(1, tarjeta.getId());
				ps.setString(1, tarjeta.getNumero());
				ps.setInt(2, tarjeta.getCupoMaximo());
				ps.setInt(3, tarjeta.getCupoDisponible());
				ps.setString(4, tarjeta.getTipo());
				ps.setString(5, tarjeta.getNumeroComprobacion());
				ps.setString(6, tarjeta.getContrasenha());
				ps.setBoolean(7, tarjeta.isBloqueada());
				ps.setInt(8, tarjeta.getId());
		   // 3. Ejecutar la sentencia
				ps.executeUpdate();
		  // 3.1. hacer el commitc
				cx.commit();
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			//4.cerrar conexion
			cerrarConexion();
		}
	}

    
}
