package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Persona {
	private boolean jubilado;
	private String seguroSocial;
	private LocalDate fechaNacimiento;
	private int telefono;
	private ArrayList<CitaMedica> historiaClinica;
	
		


	public Paciente(String nombre, String apellido, int dni, boolean jubilado, String seguroSocial,
			LocalDate fechaNacimiento, int telefono) {
		super(nombre, apellido, dni);
		this.jubilado = jubilado;
		this.seguroSocial = seguroSocial;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.historiaClinica = new ArrayList<CitaMedica>();
	}

	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}

	public String getSeguroSocial() {
		return seguroSocial;
	}

	public void setSeguroSocial(String seguroSocial) {
		this.seguroSocial = seguroSocial;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public void agregarCitaMedica(CitaMedica citaMedica) {
		this.historiaClinica.add(citaMedica);
	}

	@Override
	public String toString() {
		return "Paciente [jubilado=" + jubilado + ", seguroSocial=" + seguroSocial + ", fechaNacimiento="
				+ fechaNacimiento + ", telefono=" + telefono + "]";
	}
	

	
	
	
}
