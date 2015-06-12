package es.curso.model.entity;

public class Tarjeta {
	private int id;
	private String numero;
	private int cupoMaximo;
	private String tipo;
	private String numeroComprobacion;
	private String contrasenha;
	private String claveVerificacion;
	private boolean bloqueada;
	
	private int pago;
	public static int cupoDisponible;
	
	
	
	public Tarjeta() {  //constructor vacio
		super();
	}


	public Tarjeta(int id, String numero, int cupoMaximo, String tipo,  //constructor lleno
			String numeroComprobacion, String contrasenha, String claveVerificacion, boolean bloqueada) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
		this.claveVerificacion = claveVerificacion;
		this.bloqueada = bloqueada;
	}

	public int calcularCupoDisponible(){    //otro método
		cupoDisponible = getCupoMaximo() - getPago();
		return cupoDisponible;
		
	}
	
	

	public String getClaveVerificacion() {
		return claveVerificacion;
	}


	public void setClaveVerificacion(String claveVerificacion) {
		this.claveVerificacion = claveVerificacion;
	}


	public int getPago() {
		return pago;
	}


	public void setPago(int pago) {
		this.pago = pago;
	}


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


	@Override     //toString
	public String toString() {
		return "Tarjeta [id=" + id + ", numero=" + numero + ", cupoMaximo="
				+ cupoMaximo + ", tipo=" + tipo + ", numeroComprobacion="
				+ numeroComprobacion + ", contrasenha=" + contrasenha
				+ ", bloqueada=" + bloqueada + "]";
	}

	
	
}
