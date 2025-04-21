package co.edu.unbosque.parcial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="masotas")
public class Mascota {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private String nombre;
	private String raza;
	private String tamanio;
	private double peso;
	private String genero;
	private String especie;
	
	public Mascota() {
		// TODO Auto-generated constructor stub
	}

	public Mascota(String nombre, String raza, String tamanio, double peso, String genero, String especie) {
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
		// TODO Auto-generated method stub
		return super.toString();
	}

}
