package model;

public class Procedimiento {
	private String nombre;

	public Procedimiento(String nombre) {
		this.nombre = nombre;
	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Procedimiento [nombre=" + nombre + "]";
	}
	
	
}
