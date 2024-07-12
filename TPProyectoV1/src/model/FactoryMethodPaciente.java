package model;

import java.time.LocalDate;

public interface FactoryMethodPaciente {
	Persona crearPaciente(String nombre, String apellido, int dni, boolean jubilado, String seguroSocial,
			LocalDate fechaNacimiento, int telefono);
}
