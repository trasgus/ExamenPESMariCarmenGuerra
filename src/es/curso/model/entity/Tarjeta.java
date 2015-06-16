package es.curso.model.entity;

public class Tarjeta {
	private int id;
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible; 
	private String tipo;
	private String numeroComprobacion;
	private String contrasenha;

	private boolean bloqueada;
	

	
	
	
	public Tarjeta() {  //constructor vacio
		super();
	}


	public Tarjeta(int id, String numero, int cupoMaximo, int cupoDisponible, String tipo,  //constructor lleno
			String numeroComprobacion, String contrasenha, boolean bloqueada) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible= cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
		this.bloqueada = bloqueada;
	}

//	public int calcularCupoDisponible(){    //otro método
//		cupoDisponible = getCupoMaximo() - getPago();
//		return cupoDisponible;
//		
//	}
//	



	public int getId() {     //getters and setters
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCupoMaximo() {
		return cupoMaximo;
	}


	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}


	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}


	public String getContrasenha() {
		return contrasenha;
	}


	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}


	public boolean isBloqueada() {
		return bloqueada;
	}


	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numero=" + numero + ", cupoMaximo="
				+ cupoMaximo + ", cupoDisponible=" + cupoDisponible + ", tipo="
				+ tipo + ", numeroComprobacion=" + numeroComprobacion
				+ ", contrasenha=" + contrasenha + ", bloqueada=" + bloqueada
				+ "]";
	}


	public int getCupoDisponible() {
		return cupoDisponible;
	}


	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}

	
}
