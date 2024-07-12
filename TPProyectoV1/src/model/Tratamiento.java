package model;

import java.time.LocalDate;

public class Tratamiento {
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	
	
	
	public Tratamiento(String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String toString() {
		return "Tratamiento [ descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}
	
	}
