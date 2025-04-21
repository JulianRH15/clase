package co.edu.unbosque.parcial.dto;

public class MascotaDTO {
	
	private Integer id;
	private String nombre;
	private String raza;
	private String tamanio;
	private double peso;
	private String genero;
	private String especie;
	
	public MascotaDTO() {
		// TODO Auto-generated constructor stub
	}

	public MascotaDTO(String nombre, String raza, String tamanio, double peso, String genero, String especie) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.tamanio = tamanio;
		this.peso = peso;
		this.genero = genero;
		this.especie = especie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "MascotaDTO [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", tamanio=" + tamanio + ", peso="
				+ peso + ", genero=" + genero + ", especie=" + especie + "]";
	}
	
	
	

}
