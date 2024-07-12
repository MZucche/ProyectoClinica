package model;

import java.time.LocalDate;

public class ConcreteFactoryPaciente implements FactoryMethodPaciente {

	@Override
	public Persona crearPaciente(String nombre, String apellido, int dni, boolean jubilado, String seguroSocial,
			LocalDate fechaNacimiento, int telefono) {
		// TODO Auto-generated method stub
		return new Paciente(nombre, apellido, dni, jubilado, seguroSocial,
				 fechaNacimiento, telefono);
	}

}
