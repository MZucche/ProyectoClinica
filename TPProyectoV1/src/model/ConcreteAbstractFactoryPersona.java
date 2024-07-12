package model;

import java.time.LocalDate;

public class ConcreteAbstractFactoryPersona implements AbstractFactoryPersona {

	@Override
	public Paciente crearPaciente(String nombre, String apellido, int dni,boolean jubilado,String seguroSocial,
			LocalDate fechaNacimiento,int telefono) {
		// TODO Auto-generated method stub
		return new Paciente(nombre, apellido, dni, jubilado, seguroSocial,fechaNacimiento,telefono);
	}

	@Override
	public Medico crearMedico(int idMedico, String nombre, String apellido, int dni,Especialidad especialidad) {
		// TODO Auto-generated method stub
		return new Medico(idMedico,nombre,apellido,dni,especialidad);
	}

}
