package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
    private static final Clinica instance = new Clinica();
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Especialidad> especialidades;
	private ArrayList<CitaMedica> citasMedicas;
	
private Clinica() {
	this.pacientes = new ArrayList<Paciente>();
	this.medicos = new ArrayList<Medico>();
	this.especialidades = new ArrayList<Especialidad>();
	this.citasMedicas = new ArrayList<CitaMedica>();
	
}

public static Clinica getInstance () {
	return instance;
}

public String registrarPaciente(Paciente paciente) {
	String respuesta = null;
	try {
	if(this.getPaciente(paciente.dni) == null) {
		pacientes.add(paciente);
		respuesta = "Paciente registrado exitosamente.";
	}
	return respuesta;
	}catch(Exception e) {
		throw new Error ("El paciente ya esta en el sistema");
	}
}

public String registrarCitaMedica(int dniPaciente, int idMedico, Procedimiento procedimiento, LocalDateTime fechaYHora) {
    try {
	    Medico medico = this.getMedico(idMedico);
	    Paciente paciente = this.getPaciente(dniPaciente);
	    String respuesta ="";
	    
	    if (medico == null) {
	        throw new Error( "Error: Médico no encontrado.");
	    }
	    
	    if (paciente == null) {
	        throw new Error( "Error: Paciente no encontrado.");
	    }
	
	    if (!this.existeCita(idMedico, fechaYHora, dniPaciente)) {
	        Especialidad e = medico.getEspecialidad();
	        CitaMedica cita = new CitaMedica(paciente, medico, procedimiento, fechaYHora, e);
	        respuesta ="Cita programada exitosamente.";
	        citasMedicas.add(cita);
	    }
	    return respuesta;
    }catch(Exception e) {
    	throw new Error("Error: Existe una cita programada.");
    }
}



private Paciente getPaciente(int dni) {
	int index = 0;
	Paciente p = null;
	while(index < pacientes.size() && pacientes.get(index).getDni() != dni) 
		index++;
	if(index < pacientes.size())
		p = pacientes.get(index);
	return p;
}

public Medico getMedico(int idMedico) {
	int index = 0;
	Medico m = null;
	while(index < medicos.size() && medicos.get(index).getIdMedico() !=  idMedico) 
		index++;
	if(index < medicos.size())
		m = medicos.get(index);
	return m;
}

private CitaMedica getCitaMedica(LocalDateTime fechaYHora, int dni) {
	int index = 0;
	CitaMedica cm = null;
	while (index < citasMedicas.size() && 
			(!citasMedicas.get(index).getFechaYHora().isEqual(fechaYHora) || 
			citasMedicas.get(index).getPaciente().getDni() != dni)) {
		index++;
	}
	if (index < citasMedicas.size()) {
		cm = citasMedicas.get(index);
	}
	return cm;
}

public String finalizarCitaMedica(int dniPaciente, LocalDateTime fechaYHora, String tratamiento,
		String diagnostico,LocalDate fechaInicio,LocalDate fechaFin) {
	try {
	String mensaje ="";
	
	CitaMedica cita = this.getCitaMedica(fechaYHora, dniPaciente);
	
	 if(cita != null){
		this.asignarTratamientoYDiagnostico(cita, diagnostico, tratamiento, fechaInicio, fechaFin);
		mensaje = cita.finalizarCita();
		this.agregarCitaAPacienteYClinica(cita,dniPaciente);
	}
	return mensaje;
	}catch(Exception e) {
		throw new Error("No se encuentra la cita Medica.");
	}
}

public String cancelarCitaMedica(int dniPaciente, LocalDateTime fechaYHora) {
	try {
	String mensaje ="";
	CitaMedica cita = this.getCitaMedica(fechaYHora, dniPaciente);
	if(cita != null)
		mensaje = cita.cancelarCita();
	
	return mensaje;
	}catch(Exception e) {
		throw new Error("No se encuentra la cita Medica.");
	}
}

public ArrayList<CitaMedica> filtarCitaPorEspecialidad(String Especialidad) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getEspecialidad().getNombre().equals(Especialidad)) 
			cita.add(citaMedica);
	}
	return cita;
}

public ArrayList<CitaMedica> filtrarCitaPorMedicoAsignado(int idMedico) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getIdMedico() == idMedico) 
			cita.add(citaMedica);
	}
	return cita;
}

public ArrayList<CitaMedica> filtrarCitaPorFecha(LocalDate fecha) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getFechaYHora().toLocalDate().equals(fecha)) 
			cita.add(citaMedica);
	}
	return cita;
}

private boolean existeCita(int idMedico, LocalDateTime fechaYHora, int dniPaciente) {
    int i = 0;
    while((i < citasMedicas.size()) && 
          (citasMedicas.get(i).getMedico().getIdMedico() != idMedico ||
           citasMedicas.get(i).getPaciente().getDni() != dniPaciente ||
           !citasMedicas.get(i).getFechaYHora().isEqual(fechaYHora))) {
        i++;
    }
    return i < citasMedicas.size(); 
}



private void agregarCitaAPacienteYClinica(CitaMedica cita,int dniPaciente) {
	citasMedicas.add(cita);
	Paciente paciente = this.getPaciente(dniPaciente);
	paciente.agregarCitaMedica(cita);
}

private void asignarTratamientoYDiagnostico(CitaMedica cita, String diagnostico, String tratamiento, LocalDate fechaInicio, LocalDate fechaFin) {
	cita.setDiagnostico(diagnostico);
	cita.setTratamiento(new Tratamiento(tratamiento,fechaInicio,fechaFin));
}


//solo es para hacer pruebas.
public ArrayList<Paciente> getPacientes() {
	return pacientes;
}

public ArrayList<Medico> getMedicos() {
	return medicos;
}


public ArrayList<Especialidad> getEspecialidades() {
	return especialidades;
}

public ArrayList<CitaMedica> getCitasMedicas() {
	return citasMedicas;
}

}
