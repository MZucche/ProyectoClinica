package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.CitaMedica;
import model.Clinica;
import model.ClinicaFacade;
import model.Especialidad;
import model.Medico;
import model.Procedimiento;

public class ClinicaTestAssert {
	
	private ClinicaFacade facade = new ClinicaFacade();
	private Clinica clinica;
	@Before
	public void cargarDatos() {
		
		clinica = Clinica.getInstance();
		ArrayList<Procedimiento> ar = new ArrayList<Procedimiento>();
		Procedimiento p = new Procedimiento("Electro");
		ar.add(p);
		Especialidad e = new Especialidad("Cardiologia",ar);
		clinica.getEspecialidades().add(e);
		Medico m1 = new Medico(1,"Carlos", "Rodriguez", 1233456, e);
		m1.setEspecialidad(e);
		clinica.getMedicos().add(m1);
		
		
		facade.registrarPaciente("Ignacio","Morinigo", 1234567, false, "Osecac", LocalDate.of(2004,01,04), 1234567);
		
		facade.registrarCitaMedica(1234567,1,new Procedimiento("Electro") , LocalDateTime.of(2023, 12, 25, 10, 0));
		
		facade.registrarCitaMedica(1234567,1,new Procedimiento("Electro") , LocalDateTime.of(2023, 12, 25, 12, 0));
		
	
		}
	
	@Test
	public void registrarPaciente() {
		
		
		String pacienteIngresaPorPrimeraVez = facade.registrarPaciente("Ignacio","Morinigo", 123456, false, "Osecac", LocalDate.of(2004,01,04), 1234567);
		assertEquals(pacienteIngresaPorPrimeraVez,"Paciente registrado exitosamente.");
		
		
		//Paciente ya registrado.
		
		try {
		 facade.registrarPaciente("Ignacio","Morinigo", 123456, false, "Osecac", LocalDate.of(2004,01,04), 1234567);
		}catch(RuntimeException e) {
			assertEquals("El paciente ya esta en el sistema",e.getMessage());
		}
	}
	
	@Test
	public void registrarCita() {
	
		String obtenido = facade.registrarCitaMedica(1234567,1,new Procedimiento("Electro") , LocalDateTime.of(2025, 12, 25, 12, 0));
		assertEquals("Cita programada exitosamente.",obtenido);
		
		//Cita superpuesta,
		try {
		facade.registrarCitaMedica(1234567,1,new Procedimiento("Electro") , LocalDateTime.of(2025, 12, 25, 12, 0));
		
		}catch(RuntimeException e) {
			assertEquals("Error: Existe una cita programada.",e.getMessage());
		}
	}
	
	@Test
	public void finalizarCita() {
		String obtenido = facade.finalizarCitaMedica(1234567, LocalDateTime.of(2023, 12, 25, 10, 0),"descansar", "gripe", LocalDate.of(2025, 12, 25), LocalDate.of(2025, 12, 28));
		assertEquals("Se ha finalizado la cita medica.",obtenido);
	}
	
	@Test
	public void cancelarCitaMedica() {
		String obtenido = facade.cancelarCitaMedica(1234567,LocalDateTime.of(2023, 12, 25, 12, 0));
		assertEquals("Se ha cancelado la cita medica.",obtenido);
	}
	
	@Test
	public void filtarCitaPorEspecialidad() {
		ArrayList<CitaMedica> esperado = new ArrayList<CitaMedica>();
		CitaMedica c1 =	clinica.getCitasMedicas().get(0);
		CitaMedica c2 =	clinica.getCitasMedicas().get(1);
		CitaMedica c3 =	clinica.getCitasMedicas().get(2);
		esperado.add(c1);esperado.add(c2);esperado.add(c3);
		
		ArrayList<CitaMedica> obtenido = facade.filtarCitaPorEspecialidad("Cardiologia");
		
		assertEquals(esperado,obtenido);
	}
	
	@Test
	public void filtrarCitaPorMedicoAsignado() {
		ArrayList<CitaMedica> esperado = new ArrayList<CitaMedica>();
		CitaMedica c1 =	clinica.getCitasMedicas().get(0);
		CitaMedica c2 =	clinica.getCitasMedicas().get(1);
		CitaMedica c3 =	clinica.getCitasMedicas().get(2);
		esperado.add(c1);esperado.add(c2);esperado.add(c3);
		
		ArrayList<CitaMedica> obtenido = facade.filtrarCitaPorMedicoAsignado(1);
		
		assertEquals(esperado,obtenido);
	}
	
	@Test
	public void filtrarCitaPorFecha() {
		ArrayList<CitaMedica> esperado = new ArrayList<CitaMedica>();
		CitaMedica c1 =	clinica.getCitasMedicas().get(0);
		CitaMedica c2 =	clinica.getCitasMedicas().get(1);
		esperado.add(c1);esperado.add(c2);
		
		ArrayList<CitaMedica> obtenido = facade.filtrarCitaPorFecha(LocalDate.of(2023, 12, 25));
		
		assertEquals(esperado,obtenido);
	}
	
	
}