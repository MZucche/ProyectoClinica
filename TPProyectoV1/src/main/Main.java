package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Clinica;
import model.ClinicaFacade;
import model.Especialidad;
import model.Medico;
import model.Paciente;
import model.Procedimiento;

public class Main {
	
	private static Clinica clinica = Clinica.getInstance();
	private static ClinicaFacade facade = new ClinicaFacade(); 

	public static void cargarEspecialidadXProcedimiento(String especialidad, String proc1, String proc2,
			String proc3, String proc4, String proc5) {
		ArrayList<Procedimiento> lista = new ArrayList<Procedimiento>();
	 	Procedimiento p1 = new Procedimiento(proc1);
        Procedimiento p2 = new Procedimiento(proc2);
        Procedimiento p3 = new Procedimiento(proc3);
        Procedimiento p4 = new Procedimiento(proc4);
        Procedimiento p5 = new Procedimiento(proc5);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        Especialidad esp = new Especialidad(especialidad, lista);
        clinica.getEspecialidades().add(esp);
	}
	
	public static void autoCarga() {
		// TODO Auto-generated method stub
		cargarEspecialidadXProcedimiento("Cardiologia", "Cateterismo cardíaco", "Angioplastia coronaria",
				"Implante de marcapasos", "Ablación cardíaca", "Ecocardiograma");
		System.out.println();
		cargarEspecialidadXProcedimiento("Dermatología", "Biopsia de piel", "Excisiones quirúrgicas de lesiones cutáneas",
				"Tratamientos con láser", "Crioterapia", "Microdermoabrasión");
		
		cargarMedicoXEspecialidad();
		registarPaciente();
	}
	
	public static void cargarMedicoXEspecialidad() {
		Medico m1 = new Medico(1,"Carlos", "Rodriguez", 1233456, clinica.getEspecialidades().get(0));
		
		
		clinica.getMedicos().add(m1);
		}
	
	public static void registarPaciente() {
		clinica.registrarPaciente(new Paciente("Ignacio", "Morinigo", 123456, false, "Osecac", LocalDate.of(2004, 3, 12), 1167963456));
		clinica.registrarPaciente(new Paciente("Pablo", "Morinigo", 1234589, false, "Osecac", LocalDate.of(2004, 3, 12), 1167963456));
		
	}
	
	public static void listas() {
		for (Medico medico : clinica.getMedicos()) {
			System.out.println(medico.toString());
		}
		
		for (Paciente paciente : clinica.getPacientes()) {
			System.out.println(paciente.toString());
		}
	}
	
	public static void cita() {
		System.out.println(facade.registrarCitaMedica(123456,1, clinica.getEspecialidades().get(0).getProcedimiento().get(0),  LocalDateTime.of(2023, 6, 16, 14, 30)));
		facade.registrarCitaMedica(1234589,2, clinica.getEspecialidades().get(0).getProcedimiento().get(0),  LocalDateTime.of(2023, 6, 14, 14, 30));
		facade.registrarCitaMedica(1234589,2, clinica.getEspecialidades().get(0).getProcedimiento().get(0),  LocalDateTime.of(2024, 4, 1, 15, 20));
		
		//System.out.println(facade.finalizarCitaMedica(123456, LocalDateTime.of(2023, 6, 16, 14, 30), "repo", "gripe", LocalDate.of(2024, 4, 1),LocalDate.of(2024, 4, 5)) );
		System.out.println(facade.cancelarCitaMedica(1234589, LocalDateTime.of(2023, 6, 14, 14, 30)));
	
		facade.filtarCitaPorEspecialidad(clinica.getEspecialidades().get(0).getNombre());
	}
	
	public static void main(String[] args) {
		autoCarga();
		listas();
		cita();
	}
}
