package model;

import java.time.LocalDate;

public interface AbstractFactoryPersona {
	Paciente crearPaciente(String nombre, String apellido, int dni,boolean jubilado,String seguroSocial,
			LocalDate fechaNacimiento,int telefono);
	Medico crearMedico(int idMedico,String nombre, String apellido, int dni,Especialidad especialidad);
	
}
