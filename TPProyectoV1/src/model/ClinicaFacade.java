package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClinicaFacade {
	private Clinica clinica;
	private AbstractFactoryPersona factory;
	
	public ClinicaFacade() {
		setClinica(Clinica.getInstance());
		setFactory(new ConcreteAbstractFactoryPersona());
	}
	public String registrarPaciente(String nombre, String apellido, int dni,boolean jubilado,String seguroSocial,
			LocalDate fechaNacimiento,int telefono) {
		return getClinica().registrarPaciente(getFactory().crearPaciente(nombre,apellido,dni,jubilado,seguroSocial,fechaNacimiento,telefono));
	}
	
	public String registrarCitaMedica(int dniPaciente,int idMedico,Procedimiento procedimiento,LocalDateTime fechaYHora ) {
		return getClinica().registrarCitaMedica(dniPaciente, idMedico, procedimiento, fechaYHora);
	}
	
	public String finalizarCitaMedica(int dniPaciente,LocalDateTime fechaYHora, String tratamiento, String diagnostico,LocalDate fechaInicio,LocalDate fechaFin) {
		return getClinica().finalizarCitaMedica(dniPaciente, fechaYHora, tratamiento, diagnostico,fechaInicio,fechaFin);
	}
	
	public String cancelarCitaMedica(int dniPaciente, LocalDateTime fechaYHora) {
		return getClinica().cancelarCitaMedica(dniPaciente, fechaYHora);
	}
	
	public ArrayList<CitaMedica> filtarCitaPorEspecialidad(String especilidad) {
		return getClinica().filtarCitaPorEspecialidad(especilidad);
	}
	
	public ArrayList<CitaMedica> filtrarCitaPorMedicoAsignado(int idMedico) {
		return getClinica().filtrarCitaPorMedicoAsignado(idMedico);
	}
	
	public ArrayList<CitaMedica> filtrarCitaPorFecha(LocalDate fecha) {
		return getClinica().filtrarCitaPorFecha(fecha);
	}
	//Solo para Test
	
	public AbstractFactoryPersona getFactory() {
		return factory;
	}
	public void setFactory(AbstractFactoryPersona factory) {
		this.factory = factory;
	}
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
	
}
