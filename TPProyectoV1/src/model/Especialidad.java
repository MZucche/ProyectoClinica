package model;

import java.util.ArrayList;

public class Especialidad {
	private String nombre;
	private ArrayList<Procedimiento> procedimiento;

	public Especialidad(String nombre,ArrayList<Procedimiento> procedimiento) {
		this.nombre = nombre;
		this.procedimiento = procedimiento;
	}

	public ArrayList<Procedimiento> getProcedimiento() {
		return procedimiento;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProcedimiento(ArrayList<Procedimiento> procedimiento) {
		this.procedimiento = procedimiento;
	}

	public void getProcedimientos() {
		for (Procedimiento procedimiento2 : procedimiento) {
			System.out.println(procedimiento2);
			
		}
		
	}

	public String toString() {
		return "Especialidad [nombre=" + nombre + "]";
	}
	
}
