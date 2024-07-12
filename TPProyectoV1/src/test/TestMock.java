package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.AbstractFactoryPersona;
import model.Clinica;
import model.ClinicaFacade;
import model.Paciente;

public class TestMock {

	@Mock
	private Clinica clinica;

	@Mock
	private AbstractFactoryPersona factory;

	@InjectMocks
	private ClinicaFacade clinicaFacade;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Abre los mocks de Mockito
	}

	@Test
	public void testRegistrarPaciente() {
		// Datos de prueba
		String nombre = "Ignacio";
		String apellido = "Morinigo";
		int dni = 12345678;
		boolean jubilado = false;
		String seguroSocial = "123-45-6789";
		LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
		int telefono = 123456789;
		Paciente paciente = new Paciente(nombre, apellido, dni, jubilado, seguroSocial, fechaNacimiento, telefono);

		// Configurar comportamiento de los mocks
		when(factory.crearPaciente(nombre, apellido, dni, jubilado, seguroSocial, fechaNacimiento, telefono)).thenReturn(paciente);
		when(clinica.registrarPaciente(paciente)).thenReturn("Paciente registrado exitosamente.");

		// Llamar al método a probar
		String resultado = clinicaFacade.registrarPaciente(nombre, apellido, dni, jubilado, seguroSocial, fechaNacimiento, telefono);

		// Verificar el resultado
		assertEquals("Paciente registrado exitosamente.", resultado);

		// Verificar que los métodos fueron llamados correctamente
		verify(factory).crearPaciente(nombre, apellido, dni, jubilado, seguroSocial, fechaNacimiento, telefono);
		verify(clinica).registrarPaciente(paciente);
	}
}
